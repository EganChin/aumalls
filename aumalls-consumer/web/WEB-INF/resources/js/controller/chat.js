
$(function () {

    var userCss = "lis_lf";
    var adminCss = "lis_rt";

    var dialog = $("#chat-dialog");
    var content = $("#msg-content");
    var chatMsg = $("#chat-msg");
    var sendBtn = $("#send-button");

    var ws = {};


    var getUserToken = function () {
        var user = AWLStorage.get("user");
        return (user != null ? user.token : null);
    };

    var getUserName = function () {
        var user = AWLStorage.get("user");
        return (user != null ? user.userName : null);
    };


    var packetMessage = function (token, isAdmin, name, msg) {


        return "(" + token + ")" + "(" + isAdmin + ")" + "(" + name + ")" + msg;

    };

    var sendMessage = function () {

        var msg = chatMsg.val();

        if (!msg) {
            alert("消息不能为空");
            return;
        }

        ws.send(packetMessage(getUserToken(), !isUser, getUserName(), msg));

        chatMsg.val("");
    };

    sendBtn.click(function () {
        console.log("click");
        sendMessage();
    });

    $("#chat-close").click(function () {
        $("#chat-dialog").css("display", "none");
    });

    var appendChatContent = function (msg, isAdmin, name) {
        content.append("<div class='" + (isAdmin ? adminCss : userCss) + "'><span class=\"peo\">" + name + "</span><p class=\"lis_txt\">" + msg + "</p></div>");
    };

    var appendSystemContent = function (msg) {
        content.append("<div scro class=\"lis_md\"><p class=\"lis_txt\">" + msg + "</p></div>");
    };

    $("#link-cservice").click(function () {

        if (!AWLStorage.get("user")) {
            $("#login-dialog").css("display", "block");
            return;
        }

        dialog.css("display", "block");

        if (!window.WebSocket) {
            content.append("<div class=\"lis_md\"><p class=\"lis_txt\">本浏览器不支持 WebSocket</p></div>")
            return;
        }



        ws = new WebSocket("ws://127.0.0.1:8900/ws");

        ws.onmessage = function (event) {
            var pattern = /^\(.*\)\(.*\)\(.*\)/g;
            var rawMsg = event.data;
            console.log("接收数据：" + rawMsg);
            var header = rawMsg.match(pattern)[0];
            var msg = rawMsg.split(pattern)[1];

            var headerPattern = /\([^\)]{0,}\)/g;

            var type = header.match(headerPattern)[0];
            var admin = header.match(headerPattern)[1];
            var name = header.match(headerPattern)[2];

            if (type === "(system)") {
                //系统消息
                //用户未登录
                if (msg === "请先登录") {
                    sendBtn.attr("disabled", true);
                    AWLStorage.remove("user");
                }
                appendSystemContent(msg);
            } else {
                appendChatContent(msg, admin === "(true)", name);
            }
        };

        ws.onopen = function (event) {

            console.log("建立连接");
            //解除发送按钮的禁用
            sendBtn.removeAttr("disabled");
        };
        ws.onclose = function (event) {
            console.log("关闭连接")
        };
    });

    var getChatLog = function(){
        AWLHttp.get(httpAddress.chatLogDetail, {}, {
            success:function (response) {
                var list  = response.data.vo;
                for(var i=0; i<list.length; i++){
                    var pattern = /^\(.*\)\(.*\)\(.*\)/g;
                    var rawMsg = list[i].content;
                    console.log("接收数据：" + rawMsg);
                    var header = rawMsg.match(pattern)[0];
                    var msg = rawMsg.split(pattern)[1];

                    var headerPattern = /\([^\)]{0,}\)/g;
                    var admin = header.match(headerPattern)[1];
                    var name = header.match(headerPattern)[2];

                    appendChatContent(msg, admin === ("(true)"), name);
                }
            }
        })
    };

    if(AWLStorage.get("user"))
        getChatLog();
});
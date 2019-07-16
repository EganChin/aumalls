var isUser = true;

$(function () {

    var me = isUser ? "lis_lf" : "lis_rt";
    var other = isUser ? "lis_rt" : "lis_lf";

    var dialog = $("#chat-dialog");
    var content = $("#msg-content");
    var chatMsg = $("#chat-msg");
    var sendBtn = $("#send-button");

    var ws = {};


    var getUserToken = function () {
        var user = AWLStorage.get("user");
        return (user != null ? user.token : null);
    };




    var sendMessage = function () {

        var msg = chatMsg.val();

        if (!msg) {
            alert("消息不能为空");
            return;
        }

        ws.send("(" + getUserToken() + ")" + msg);

        chatMsg.val("");
    };


    sendBtn.click(function () {
        console.log("click");
        sendMessage();
    });

    $("#chat-close").click(function () {
        $("#chat-dialog").css("display", "none");
    });

    $("#link-cservice").click(function () {

        if (!AWLStorage.get("user")){
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
            var typePattern = /^\(.*\)/g;
            var rawMsg = event.data;
            console.log("接收数据：" + rawMsg);
            var type = rawMsg.match(typePattern)[0];
            var msg = rawMsg.split(typePattern)[1];
            if (type === "(system)") {
                //系统消息
                //用户未登录
                if (msg === "请先登录") {
                    sendBtn.attr("disabled", true);
                    AWLStorage.remove("user");
                }
                content.append("<div class=\"lis_md\"><p class=\"lis_txt\">" + msg + "</p></div>");
            } else {
                var role = ("(" + getUserToken() + ")" === type ? me : other);
                content.append("<div class='" + role + "'><span class=\"peo\"></span><p class=\"lis_txt\">" + msg + "</p></div>");
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
});
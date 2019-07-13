$(function () {

    function setCookie(name,value,time)
    {
        var strsec = getsec(time);
        var exp = new Date();
        exp.setTime(exp.getTime() + strsec*1);
        document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
    }

    function getsec(str)
    {
        alert(str);
        var str1=str.substring(1,str.length)*1;
        var str2=str.substring(0,1);
        if (str2=="s")
        {
            return str1*1000;
        }
        else if (str2=="h")
        {
            return str1*60*60*1000;
        }
        else if (str2=="d")
        {
            return str1*24*60*60*1000;
        }
    }

    var closeDialog = function(){
        loginDialog.css("display", "none");
    };

    var openDialog = function(){
        loginDialog.css("display", "block");
    };

    var loginDialog = $("#login-dialog");


    var loginStatus = function (username) {
        $("#user-group").css("display", "none");
        $("#welcome").html("嗨，" + username +"，澳猫团欢迎你");
    };

    var logoutStatus = function () {
        $("#user-group").css("display", "block");
        $("#welcome").html("嗨，澳猫团欢迎你");
        AWLStorage.remove("user");
        setCookie("token", "token", "h-1");
    };

    if(AWLHttp.getParam("login-status")==="401"){

        openDialog();
    }

    if(AWLStorage.get("user")!=null){
        loginStatus(AWLStorage.get("user").userName);
    }

    $("#close").click(function () {
        closeDialog();
    });

    $("#cancel-btn").click(function () {
        closeDialog();
    });

    $("#login").click(function () {
        openDialog();
    });

    $("#login-btn").click(function () {
        var account = $("#account").val();
        var password = $("#password").val();
        if(!account || !password){
            alert("账号或密码不能为空")
            return;
        }

        AWLHttp.post(httpAddress.login, {account: account, password:password}, {
            success:function (msg) {
                var vo = msg.data.vo;
                document.cookie = "token="+vo.token + $("#remember").val() === true ? ";expires=7":"";
                setCookie("token", vo.token, "d7");
                closeDialog();

                AWLStorage.save("user", msg.data.vo);

                loginStatus(vo.userName);
            }
        })
    });



});
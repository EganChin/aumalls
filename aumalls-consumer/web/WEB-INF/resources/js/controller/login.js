$(function () {

    var loginDialog = $("#login-dialog");


    var loginStatus = function (username) {
        $("#user-group").css("display", "none");
        $("#welcome").html("嗨，" + username +"，澳猫团欢迎你");
    };

    if(AWLStorage.get("user")!=null){
        loginStatus(AWLStorage.get("user").userName);
    }

    var closeDialog = function(){
        loginDialog.css("display", "none");
    };

    var openDialog = function(){
        loginDialog.css("display", "block");
    };

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
                closeDialog();

                AWLStorage.save("user", msg.data.vo);

                loginStatus(vo.userName);
            }
        })
    });

});
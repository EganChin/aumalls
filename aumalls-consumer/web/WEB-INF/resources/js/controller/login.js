$(function () {

    var loginDialog = $("#login-dialog");

    var closeDialog = function(){
        loginDialog.css("display", "none");
    };

    $("#close").click(function () {
        closeDialog();
    });

    $("#cancel-btn").click(function () {
        closeDialog();
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
                closeDialog();
                console.log(msg.data);
                $("#user-group").css("display", "none");
            }
        })
    })
});
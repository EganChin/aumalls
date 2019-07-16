$(function () {

    var isAdmin = (AWLHttp.getParam("admin") === "true");

    var redirect = AWLHttp.getParam("redirect");

    if (!redirect)
        redirect = "/";

    var closeDialog = function () {
        AWLPage.redirectTo(redirect);
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
        if (!account || !password) {
            alert("账号或密码不能为空");
            return;
        }

        var address = (isAdmin ? httpAddress.adminLogin : httpAddress.userLogin)

        AWLHttp.post(address, {account: account, password: password}, {
            success: function (msg) {
                AWLStorage.remove("user");
                var vo = msg.data.vo;
                document.cookie = "token=" + vo.token + $("#remember").val() === true ? ";expires=7" : "";
                AWLStorage.setCookie("token", vo.token, "d1");
                closeDialog();

                AWLStorage.save("user", vo);

                closeDialog();
                // loginStatus(vo.userName);
            }
        })
    });

});
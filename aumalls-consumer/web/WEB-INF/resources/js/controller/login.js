$(function () {

    var isAdmin = (AWLHttp.getParam("admin") === "true");

    var redirect = AWLHttp.getParam("redirect");

    if (!redirect)
        redirect = "/";

    var closeDialog = function () {
        AWLPage.redirectTo(redirect);
    };

    $('.checkbox').click(function(event) {
        if ($(this).hasClass('checked')) {
            $(this).removeClass('checked');
        } else {
            $(this).addClass('checked');
        }
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
                AWLStorage.setCookie("token", vo.token, "d1");
                closeDialog();

                vo.isAdmin = isAdmin;
                AWLStorage.save("user", vo);

                closeDialog();
                // loginStatus(vo.userName);
            }
        })
    });

});
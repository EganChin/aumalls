$(function () {

    $("#order").click(function () {
        AWLPage.redirectTo("order/order");
    });

    var loginStatus = function (username) {
        $("#user-group").css("display", "none");
        $("#logout-group").css("display", "block");
        $("#welcome").html("嗨，" + username + "，澳猫团欢迎你");
    };

    var logoutStatus = function () {
        // $("#user-group").css("display", "block");
        // $("#logout-group").css("display", "none");
        // $("#welcome").html("嗨，澳猫团欢迎你");
        AWLStorage.remove("user");
        AWLStorage.setCookie("token", "token", "h-100");
        location.reload();

    };

    var user = AWLStorage.get("user");

    if (user){
        if(user.isAdmin){
            AWLPage.redirectTo("manager/");
            return;
        }
        loginStatus(user.userName);
    }

    $("#login").click(function () {
        toLogin();
    });

    $("#logout").click(function () {
        logoutStatus();
    });


    var toLogin = function () {
        var pn = AWLHttp.getParam("pn");
        if (!pn)
            pn = 1;
        AWLPage.redirectTo("/login?redirect=/?pn=" + pn);
    }

});
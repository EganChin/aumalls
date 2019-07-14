$(function () {
    var orderPage = $("#order-page");

    var openOrderPage = function () {
        orderPage.css("display", "block");
    }

    $("#order").click(function () {
        openOrderPage();
    });
}
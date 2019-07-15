$(function () {
    var orderPage = $("#order-page");

    //打开订单页面方法
    var openOrderPage=function(){
        alert("hello");
    };


    //清除页面除头标签和页脚的内容
    function clearPage(){
        $(".logoAndSearch").remove();
        $(".center_1200.nav_list_wrap").remove();
        $(".BZ").remove();
    }

    $("#order").click(function () {
        clearPage();
        openOrderPage();

    });
});
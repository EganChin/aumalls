
<%@page pageEncoding="UTF-8"%>
<%@include file="base.jsp" %>
<div class="order-page" id="order-page" style="display:none">
    <div class="order">
    这是订单界面~~~雷浩

    </div>
</div>

<script type="text/javascript">
    /*var orderPage = $("#order-page");

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
    });*/
    /*var openOrderPage = function () {
        window.alert("前");
        $.ajax({
           type:"GET",
           url:"order/orderDetail",
           dataType:"json",
           success:function (data) {
               alert(data);
           }, error:function () {
                alert("获取订单详情失败！")
           }
        });

        $(".mainArea").html("");
        $(".mainArea").append(orderPage.css("display","block"));
    };*/
</script>
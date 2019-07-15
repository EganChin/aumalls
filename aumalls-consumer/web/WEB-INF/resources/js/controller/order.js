$(function () {
    var orderPage = $("#order-page");

    //打开订单页面方法
    var openOrderPage = function () {
        /*$.ajax({
            type: "GET",
            url: "order/orderDetail?orderId=17431d1ab0f34ff1ae48527a69fe05ee",
            dataType: "json",
            success: function (data) {

                mts=JSON.stringify(data)
                mts=JSON.parse(mts)

                alert(mts)

            }, error: function () {
                alert("获取订单详情失败！")
            }
        });*/
        AWLHttp.get(httpAddress.orderDetail, {orderId:"17431d1ab0f34ff1ae48527a69fe05ee"},{
            success:function (result) {
                alert(result);
            },
            error:function (result) {
                alert("获取数据失败！")
            }
        })

        $(".mainArea").html("").append(orderPage.css("diplay","block"))
    }


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
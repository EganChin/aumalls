$(function () {

    var orders;

    $(document).ready(function () {
        openOrderPage(0);
    })

    //打开订单页面
    function openOrderPage(status){

        var ordersList=$("#orders-list");
        ordersList.html("");

        AWLHttp.get(httpAddress.ordersPage,{status:status},{
            success:function (msg) {
                orders=msg.data.page.list;

                ordersList.html("");
                    for (var i in orders) {
                        var statusName;
                        var handleStr;
                        switch(orders[i].orderStatus){
                            case 1:
                                statusName="报关中";
                                handleStr="等待报关"
                                break;
                            case 2:
                                statusName="报关成功，待付款";
                                handleStr="<a href='#' class='link' id='payOrder'>付款</a></td>"
                                break;
                            case 3:
                                statusName="付款成功，即将发货";
                                handleStr="<a href='#' class='link' id='urgeOrder'>催单</a></td>"
                                break;
                            case 4:
                                statusName="已发货";
                                handleStr="等待运送"
                                break;
                            case 5:
                                statusName="交易成功";
                                handleStr="<a href='#' class='link' id='commentOrder'>评论</a></td>"
                                break;
                            default:statusName="未知状态";
                        }

                        ordersList.append("<tr id='order"+i+"' >\n"+
                            "<th scope='row'><img class='mr-3' src='...' href='#'></th>\n"+
                            "<td>"+orders[i].orderId+"</td>\n"+
                            "<td>"+orders[i].orderPrice+"</td>\n"+
                            "<td>"+statusName+"</td>\n"+
                            "<td>"+orders[i].orderTime+"</td>\n"+
                            "<td>"+handleStr+"</td>\n"+
                            "</tr>");
                    }
            }
        })
    }

    //打开订单详情方法
    function openOrderDetail(orderId) {
        AWLHttp.get(httpAddress.orderDetail, {orderId:orderId},{
            success:function (msg) {
                //获取订单详情
                var orderDetail=msg.data.orderDetail;
                alert(orderDetail.orderId);
            }
        })

    }


    $("#myOrder").click(function () {
        AWLPage.redirectTo("order");
    });

    $("#backToIndex").click(function () {
        AWLPage.redirectTo("/");
    })

    //点击状态菜单栏
    $(".nav-link").click(function () {
        //获取选中的订单状态值
        var status=parseInt($(this).attr("aria-controls").substr(3,1))
        openOrderPage(status);
    })

});
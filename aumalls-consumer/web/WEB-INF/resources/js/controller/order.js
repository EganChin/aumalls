$(function () {

    var status=0;

    $(document).ready(function () {
        openOrderPage(0,1);
    });


    //打开订单页面
    function openOrderPage(status,pn){

        var ordersList=$("#orders-list");
        ordersList.html("");

        AWLHttp.get(httpAddress.ordersPage,{status:status,pn:pn,ps:5},{
            success:function (msg) {
                var orders=msg.data.page.list;

                ordersList.html("");
                    for (var i in orders) {
                        var statusName;
                        var handleStr;
                        switch(orders[i].orderStatus){
                            case 1:
                                statusName="报关中";
                                handleStr=""
                                break;
                            case 2:
                                statusName="报关成功，待付款";
                                handleStr="<a href='#' class='link' id='payOrder'>付款</a>"
                                break;
                            case 3:
                                statusName="付款成功，即将发货";
                                handleStr="<a href='#' class='link' id='urgeOrder'>催单</a>"
                                break;
                            case 4:
                                statusName="已发货";
                                handleStr="<a href='#' class='link' id='orderTrace'>物流</a>"
                                break;
                            case 5:
                                statusName="交易成功";
                                handleStr="<a href='#' class='link' id='commentOrder'>评论</a>"
                                break;
                            default:statusName="未知状态";
                        }

                        ordersList.append("<tr id='order"+i+"' >\n"+
                            "<th scope='row'><img style=\"height: 120px;width: 120px\" class='mr-3 img-responsive center-block img-thumbnail' src='../resources/images/"+orders[i].goodsImg+"' href='#'></th>\n"+
                            "<td>"+orders[i].orderId+"</td>\n"+
                            "<td>￥"+orders[i].orderPrice+".00</td>\n"+
                            "<td>"+statusName+"</td>\n"+
                            "<td>"+orders[i].orderTime+"</td>\n"+
                            "<td><ul class='list-unstyled'><li>"+handleStr+"</li>" +
                            "<li><a href='#' class='toOrderDetail' id='detail"+orders[i].orderId+"'>查看详情</a></li></td>\n"+
                            "</tr>");
                    }

                initPageNav(orders);
                $(".toOrderDetail").click(function () {
                    var orderId=$(this).attr("id").substr(6);
                    console.log("订单Id为："+orderId);
                    openOrderDetail(orderId);
                })
            }

        })


    }

    function initPageNav(orders) {
        AWLHttp.get(httpAddress.orderSum,{status:status}, {
            success: function (msg) {
                var sum = msg.data.orderSum;
                var pagination=$(".pagination").html("").append("<li class=\"page-item\">\n" +
                    "                <a class=\"page-link\" href=\"#\" aria-label=\"Previous\">\n" +
                    "                    <span aria-hidden=\"true\">&laquo;</span>\n" +
                    "                    <span class=\"sr-only\">上一页</span>\n" +
                    "                </a>\n" +
                    "            </li>");
                var pages=parseInt(sum/5)+1;

                for(i=0;i<pages;i++){
                    pagination.append("<li class=\"page-item\"><a class=\"page-link\" href=\"#\" id='page"+(i+1)+"'>"+(i+1)+"</a></li>");
                }

                pagination.append("<li class=\"page-item\">\n" +
                    "                <a class=\"page-link\" href=\"#\" aria-label=\"Next\">\n" +
                    "                    <span aria-hidden=\"true\">&raquo;</span>\n" +
                    "                    <span class=\"sr-only\">下一页</span>\n" +
                    "                </a>\n" +
                    "            </li>")

                $(".page-link").click(function () {
                    var toPage=$(this).attr("id").substr(4);
                    openOrderPage(status,toPage);
                })
            }, error: function () {
            }
        });
    }
    
    //打开订单详情方法
    function openOrderDetail(orderId) {
        AWLPage.redirectTo("orderDetail?orderId="+orderId);
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
        status=parseInt($(this).attr("aria-controls").substr(3,1))
        openOrderPage(status);
    })

});
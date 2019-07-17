/**
 * AWLHttp请求辅助类
 * 在这里定义一系列的请求常量。
 * date: 2019/5/23 10:00
 * by: 陈奕铠
 */
var serverURL = "http://" + location.hostname +"/";
var httpCode = {
    "error": 500,
    "success": 200,
    "unauthorized": 401
};
var roles = {

};
var httpAddress = {
    "userLogin": "user/login",
    "adminLogin": "admin/login",
    "getSeniorGoodsTypeList": "goods/type/senior",
    "getGoodsPage": "goods/page",
    "orderDetail":"order/orderDetail",
    "ordersPage":"order/ordersPage",
    "order":"order/order",
    "chatLogDetail": "chat/detail",
    "flushCartIterm":"shopcart/flushCartIterm",
    "updataCartNum":"shopcart/updataCartNum",
    "getUserShopCartIterm":"shopcart/getUserShopCartIterm",
    "flushCartIterm":"shopcart/flushCartIterm",
    "addTouserCart":"shopcart/addTouserCart",
    "getUserItermNum":"shopcart/getUserItermNum",
    "updataUserWhitetime":"useradmin/updataUserWhitetime",
    "showAllUser":"useradmin/showAllUser"
};
(function () {
    for (var objSub in httpAddress) {
        httpAddress[objSub] = serverURL + httpAddress[objSub];
    }
})();
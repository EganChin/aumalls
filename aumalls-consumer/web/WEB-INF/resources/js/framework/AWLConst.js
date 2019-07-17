/**
 * AWLHttp请求辅助类
 * 在这里定义一系列的请求常量。
 * date: 2019/5/23 10:00
 * by: 陈奕铠
 */
var serverURL = "http://localhost/";
var httpCode = {
    "error": 500,
    "success": 200,
    "unauthorized": 401
};
var roles = {

};
var httpAddress = {
    "login": "user/login",
    "getSeniorGoodsTypeList": "goods/type/senior",
    "getGoodsPage": "goods/page",
    "orderDetail":"order/orderDetail",
    "ordersPage":"order/ordersPage",
    "order":"order/order",
};
(function () {
    for (var objSub in httpAddress) {
        httpAddress[objSub] = serverURL + httpAddress[objSub];
    }
})();
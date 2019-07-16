function homepageDisplay() {
    $(".controlDisplay").hide()
    $("#managerHomePage").show()
}
function managerGoodsDisplay(){
    $(".controlDisplay").hide()
    $("#managerGoods").show()
}
function managerUserDisplay() {
    $(".controlDisplay").hide()
    $("#controlDisplay").show()
}
function managerOrderDisplay() {
    $(".controlDisplay").hide()
    $("#managerOrder").show()
}
function managerSystemDisplay() {
    $(".controlDisplay").hide()
    $("#managerSystem").show()
}
(function () {
    $(".controlDisplay").hide()
    $("#managerHomePage").show()
})();
$(function () {
    $("#list1").click(function () {
        homepageDisplay()
    })
    $("#list2").click(function () {
        managerUserDisplay()
    })
    $("#list3").click(function () {
        managerGoodsDisplay()
    })
    $("#list4").click(function () {
        managerOrderDisplay()
    })
    $("#list8").click(function () {
        managerSystemDisplay()
    })
})
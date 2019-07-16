// $(function () {

var minPrice = AWLHttp.getParam("minPrice");
var maxPrice = AWLHttp.getParam("maxPrice");
if (minPrice){

    $("#price-"+minPrice).attr("class", "price-active");
    minPrice = "&minPrice=" + minPrice;
}
else minPrice = "";
if (maxPrice)
    maxPrice = "&maxPrice=" + maxPrice;
else maxPrice = "";

var pn = AWLHttp.getParam("pn");

if (!pn) pn = 1;

var addPageBtn = function (ps, total) {


    //分页功能
    var pageNum = parseInt(total / ps);
    if (total % ps !== 0)
        pageNum += 1;
    var totalPages = pageNum;
    var current = parseInt(pn);

    //初始化分页按钮
    var nowPage = current;
    //注意，pgBtnNum必须为奇数
    var pgBtnNum = 7;
    var pageUtil = new AWLPageUtil();
    pageUtil.init({
        "btnNum": pgBtnNum,
        "currentPage": nowPage,
        "allPageNum": totalPages
    });
    var pageRange = pageUtil.getPageRange();
    var rithtButton = $("#right");
    for (i = pageRange.start; i <= pageRange.end; i++) {
        var cls = i === current ? "\"active\"" : "\"page\"";
        rithtButton.before("<span class=" + cls + "><a href='/?&pn=" + i + maxPrice + minPrice + "' target=\"_self\" class='page-link'> " + i + "</a></span>");
    }
    // console.log(btns);
    // $("#right").append(btns);
};

var screenPrice = function (minP, maxP, ele) {
    var cls = ele.getAttribute("class");
    console.log(cls);
    var uri = "/?pn=" + pn;
    if (minP)
        minP = "&minPrice=" + minP;
    else if(minP === 0)
        minP = "&minPrice=0";
    else minP = "";
    if (maxP)
        maxP = "&maxPrice=" + maxP;
    else maxP = "";
    if (cls === "price-active"){

        AWLPage.redirectTo("/");
        return;
    }
    uri = uri + minP +  maxP;
    AWLPage.redirectTo(uri)
};

var userPageBtn = function (ps, total) {
    var pn = AWLHttp.getParam("pagenum");

    if (!pn) pn = 1;

    //分页功能
    var pageNum = parseInt(total / ps);
    if (total % ps !== 0)
        pageNum += 1;
    var totalPages = pageNum;
    var current = parseInt(pn);

    //初始化分页按钮
    var nowPage = current;
    //注意，pgBtnNum必须为奇数
    var pgBtnNum = 7;
    var pageUtil = new AWLPageUtil();
    pageUtil.init({
        "btnNum": pgBtnNum,
        "currentPage": nowPage,
        "allPageNum": totalPages
    });
    var pageRange = pageUtil.getPageRange();
    var rithtButton = $("#right");
    for (i = pageRange.start; i <= pageRange.end; i++) {
        var cls = i === current ? "\"active\"" : "\"page\"";
        rithtButton.before("<span class=" + cls + "><a href='/useradmin/showAllUser?pagenum=" + i + "' target=\"_self\" class='page-link'> " + i + "</a></span>");
    }
    // console.log(btns);
    // $("#right").append(btns);
};


// });

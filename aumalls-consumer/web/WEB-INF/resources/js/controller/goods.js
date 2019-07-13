$(function () {

    var totalPages = 0;
    var ps = 8;

    var loadTypeList = function () {
        AWLHttp.get(httpAddress.getSeniorGoodsTypeList, {}, {
            success: function (msg) {
                if (msg.code === 200) {
                    var typeList = $("#type-list");
                    var dataList = msg.data.list;
                    for (var i = 0; i < dataList.length; i++) {
                        var data = dataList[i];
                        typeList.append(
                            "<dl >" +
                            "<dt><a href=\"#\">" + data["typeName"] + "</a></dt>" +
                            "<dd class='cli'><em></em><ul id=typeList" + i + "></ul></dd> " +
                            "</dl>");
                        //二级分类列表
                        var secondType = $("#typeList" + i);
                        var children = data["children"];
                        // console.log(children);
                        for (var j = 0; j < children.length; j++) {
                            var child = children[j];
                            // console.log(child);
                            secondType.append("<li><a href=\"#\">·&nbsp;&nbsp;" + child["typeName"] + "</a></li>")
                        }
                    }
                }
            }
        })
    };

    var loadProductTable = function () {
        var pn = AWLHttp.getParam("pn");
        if(!pn) pn = 1;
        AWLHttp.get(httpAddress.getGoodsPage, {ps:ps, pn:pn}, {
            success: function (msg) {
                if (msg.code === 200) {
                    var productTable = $("#product-table");
                    var dataList = msg.data.page.list;
                    for (var i = 0; i < dataList.length; i++) {
                        var data = dataList[i];
                        productTable.append("<li>\n" +
                            "                        <div class='hoverShow collect\'><em></em>收藏</div>\n" +
                            // "                        <div class=\"hoverShow wish\"><em></em>加入心愿单</div> \n" +
                            "                        <div class=\"show\">\n" +
                            "                            <a class=\"add\" href=\"#\">加入购物车</a>\n" +
                            "                            <a class=\"contrast\" href=\"#\">商品对比</a>\n" +
                            "                        </div>\n" +
                            "                        <div class=\"proImg\">\n" +
                            "                            <a href=\"#\">\n" +
                            "                                <img class=\"lazy\" src=\"images/" + data["goodsImg"] + "\" height='165' width='183' data-original=\"images/" + data["goodsImg"] + "\" alt=\"\" style=\"display: inline-block;\">\n" +
                            "                            </a>\n" +
                            "                        </div>\n" +
                            "                        <div class=\"proTxt\">\n" +
                            "                            <p><a href=\"#\">" + data["goodsName"] + "</a></p>\n" +
                            "                            <p class=\"num\">已售出" + data["goodsNum"] + "件</p>\n" +
                            "                            <p>\n" +
                            "                                <strong>￥" + data["goodsPrice"] + "</strong>\n" +
                            "                            </p>\n" +
                            "                        </div>\n" +
                            "                    </li>");
                    }

                    //分页功能
                    var total = parseInt(msg.data.page.total);
                    var pageNum = parseInt(total / ps);
                    if (total % ps !== 0)
                        pageNum += 1;
                    totalPages = pageNum;
                    var current = parseInt(msg.data.page.pn);

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
                        rithtButton.before("<span class="+cls+"><a href='index.html?pn="+i+"' target=\"_blank\" class='page-link'> "+i+"</a></span>");
                    }
                    // console.log(btns);
                    // $("#right").append(btns);
                }

            }
        })
    };

    loadProductTable();

    loadTypeList();
});

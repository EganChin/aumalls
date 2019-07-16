var managerGoods = (function () {
    var pn = parseInt(util.param.pn ? util.param.pn : 1);
    var ps = parseInt(util.param.ps ? util.param.ps : 5);
    var flag = 0;
    // list3为商品
    $("#list3").click(function () {
        if (flag === 0) {
            getGoodsE0()
        }
    });

    function getGoodsE0() {
        $.ajax({
            url: "../manager/goodsE0",
            type: "GET",
            dataType: "json",
            data: {"pn": pn, "ps": ps},
            // contentType : "application/json; charset=utf-8",
            success: function (msg) {
                flag = 1;
                //获取当前页数据（记录）
                var GoodsList = msg.data.page.list;
                var rightButton = $("#right");
                //获取总记录数
                var total = parseInt(msg.data.page.total);
                //分页功能
                var pageNum = parseInt(total / ps);
                if (total % ps !== 0)
                    pageNum += 1;
                var totalPages = pageNum;
                var current = parseInt(pn);

                //初始化分页按钮
                var nowPage = current;
                //注意，pgBtnNum必须为奇数
                var pgBtnNum = 5;
                var pageUtil = new AWLPageUtil();
                pageUtil.init({
                    "btnNum": pgBtnNum,
                    "currentPage": nowPage,
                    "allPageNum": totalPages
                });
                var pageRange = pageUtil.getPageRange();
                for (i = pageRange.start; i <= pageRange.end; i++) {
                    var cls = i === current ? "\"active\"" : "\"page\"";
                    rightButton.before("<span class=" + cls + "><a href='/manager/?page=topage&pn=" + i + "&ps=" + ps + "' target=\"_self\" class='page-link'> " + i + "</a></span>");
                }

                for (var i = 0; i < GoodsList.length; i++) {
                    var good = GoodsList[i]
                    var annexHtml = "<tr>"
                        + "<td>" + good.goodsName + "</td>"
                        + "<td>" + good.goodsPrice + "</td>"
                        + "<td>" + good.goodsNum + "</td>"
                        + "<td>" + good.typeName + "</td>"
                        + "<td style='color: #005cbf'>" + "<button id='agreeAdd-" + good.goodsId + "'>同意</button>"
                        + "<button id='refuseAdd-" + good.goodsId + "'>拒绝</button></td>"
                        + "</tr>"
                    $("#goods-apply").append(annexHtml)
                }
            }
        })
        /**
         * 设置动态表的点击事件
         */
        $("table").on("click","button",function () {
            var mychoice = new Array(2);
            mychoice = $(this).attr("id").split("-");
            if(mychoice.length>1&&mychoice[0]==="agreeAdd"){
                $.ajax({
                    url:"../manager/addGoods",
                    type: "GET",
                    data:{"id":parseInt(mychoice[1])},
                    // dataType: "json",
                    success: function (data) {
                        location.href="?page=topage";
                    }
                })
            }
            if(mychoice.length>1&&mychoice[0]==="refuseAdd"){
                $.ajax({
                    url:"../manager/deleteGoods",
                    type: "GET",
                    data:{"id":parseInt(mychoice[1])},
                    // dataType: "json",
                    success: function (data) {
                        location.href="?page=topage";
                    }
                })
            }
        })
    }


    var init = (function(){
        var pageName = util.param.page;
        if(pageName==="topage"){
            managerGoodsDisplay();
            getGoodsE0();
        }
    })();

    var inform = $('#chat-inform');

    $("#logout").click(function () {
        AWLStorage.setCookie("token", "token", "h-100");
        AWLStorage.remove("user");
        AWLPage.redirectTo("/");
    })
    // $('#chat-cservicen').hover(function(e) {
    //     console.log("hover");
    //     inform.children().stop().slideToggle();
    // })
})();

var goodsManager = (function () {
    var flag = 0;
    $("#menu1Manager").click(function () {
        $(".GoodsPageController").hide();
        if(flag===0){
            getGoodsE1();
        }
        $("#menu1").show();
    });
    $("#homeManager").click(function () {
        $(".GoodsPageController").hide();
        $("#home").show();
    });
    $("#testManager").click(function () {
        $(".GoodsPageController").hide();
        $("#menul2").show();
    });

    var pn = parseInt(util.param.pn ? util.param.pn : 1);
    var ps = parseInt(util.param.ps ? util.param.ps : 5);



    function getGoodsE1() {
        $.ajax({
            url: "../manager/goodsE1",
            type: "GET",
            dataType: "json",
            data: {"pn": pn, "ps": ps},
            // contentType : "application/json; charset=utf-8",
            success: function (msg) {
                flag = 1;
                //获取当前页数据（记录）
                var GoodsList = msg.data.page.list;
                var menu1LefButton = $("#menu1Right");
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
                    menu1LefButton.before("<span class=" + cls + "><a href='/manager/?page=goodsManager&pn=" + i + "&ps=" + ps + "' target=\"_self\" class='page-link'> " + i + "</a></span>");
                }

                for (var i = 0; i < GoodsList.length; i++) {
                    var good = GoodsList[i]
                    var annexHtml = "<tr>"
                        + "<td>" + good.goodsName + "</td>"
                        + "<td>" + good.goodsPrice + "</td>"
                        + "<td>" + good.goodsNum + "</td>"
                        + "<td>" + good.typeName + "</td>"
                        + "<td style='color: #005cbf'>" + "<button id='view-" + good.goodsId + "'>查看</button>"
                        + "<button id='ls-" + good.goodsId + "'>下架</button></td>"
                        + "</tr>"
                    $("#goods-manager").append(annexHtml)
                }
            }
        })
        /**
         * 设置动态表的点击事件
         */
        $("table").on("click","button",function () {
            var mychoice = new Array(2);
            mychoice = $(this).attr("id").split("-");
            if(mychoice.length>1&&mychoice[0]==="view"){

            }
            if(mychoice.length>1&&mychoice[0]==="ls"){
                $.ajax({
                    url:"../manager/ls",
                    type: "GET",
                    data:{"id":parseInt(mychoice[1])},
                    // dataType: "json",
                    success: function (data) {
                        location.href="?page=goodsManager&ps="+ps+"&pn="+pn;
                    }
                })
            }
        })
    }


    var init = (function(){
        var pageName = util.param.page;
        if(pageName==="goodsManager"){
            managerGoodsDisplay();
            $(".GoodsPageController").hide();
            $("#menu1").show();
            getGoodsE1();
        }
    })();
})();

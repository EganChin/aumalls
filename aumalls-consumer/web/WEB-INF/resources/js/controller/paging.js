// $(function () {


    var addPageBtn = function (ps, total) {
        var pn = AWLHttp.getParam("pn");
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
            rithtButton.before("<span class=" + cls + "><a href='/?pn=" + i + "' target=\"_self\" class='page-link'> " + i + "</a></span>");
        }
        // console.log(btns);
        // $("#right").append(btns);
    };

// });

/**
 * 核心工具类
 * author:陈奕铠
 * date:2019-07-11 14:56
 */
var util = {};

/**
 * 核心数据存储类
 */
util.data = (function () {
    var dataObj = {};
    /**
     * 保存数据
     * @param name
     * @param value:想要存储的对象
     */
    dataObj.set = function (name, value) {
        window.localStorage.setItem(name, JSON.stringify(value));
    };
    /**
     * 获取数据
     * @param name:获取一个对象
     */
    dataObj.get = function (name) {
        return JSON.parse(window.localStorage.getItem(name));
    };
    dataObj.remove = function (name) {
        window.localStorage.removeItem(name);
    };
    return dataObj;
})();

/**
 * 获取浏览器地址栏参数
 * 调用方法:util.param.xxx(参数名称)
 */
util.param = (function () {
    var paramObj = {};

    function initQuery() {
        var href = window.location.href;
        var query = href.split("?");
        if (query.length > 1) {
            var queryParamStr = query[1].split("&");
            for (var i = 0; i < queryParamStr.length; i++) {
                var queryParam = queryParamStr[i].split("=");
                paramObj[queryParam[0] + ""] = queryParam[1];
            }
        }
    }

    paramObj.init = (function () {
        initQuery();
    })();
    return paramObj;
})();

/**
 * 日期格式化工具
 * 参数：util.date.format(datetime,fmt)
 */
util.date = (function () {
    var dateObj = {};

    function Format(datetime, fmt) {
        if (parseInt(datetime) === datetime) {
            if (datetime.length === 10) {
                datetime = parseInt(datetime) * 1000;
            } else if (datetime.length === 13) {
                datetime = parseInt(datetime);
            }
        }
        datetime = new Date(datetime);
        var o = {
            "M+": datetime.getMonth() + 1,                 //月份
            "d+": datetime.getDate(),                    //日
            "h+": datetime.getHours(),                   //小时
            "m+": datetime.getMinutes(),                 //分
            "s+": datetime.getSeconds(),                 //秒
            "q+": Math.floor((datetime.getMonth() + 3) / 3), //季度
            "S": datetime.getMilliseconds()             //毫秒
        };
        if (/(y+)/.test(fmt))
            fmt = fmt.replace(RegExp.$1, (datetime.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }

    dateObj.format = function (datetime, fmt) {
        return Format(datetime, fmt);
    };
    dateObj.getAge = function (datetime) {
        var strBirthday = dateObj.format(datetime, "yyyy-MM-dd");
        var strBirthdayArr = strBirthday.split("-");
        var d = new Date();
        var yearDiff = d.getFullYear() - strBirthdayArr[0];
        var monthDiff = d.getMonth() + 1 - strBirthdayArr[1];
        var dayDiff = d.getDate() - strBirthdayArr[2];
        var age = monthDiff < 0 || (monthDiff === 0 && dayDiff < 0) ? yearDiff - 1 : yearDiff;
        return age = age < 0 ? 0 : age;
    };
    return dateObj;
})();
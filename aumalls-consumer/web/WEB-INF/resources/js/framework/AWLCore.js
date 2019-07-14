/**
 * 臻我生活核心类
 * date: 2019/5/23 10:00
 * by: 陈奕铠
 */
/**
 * 核心存储类
 */
var AWLStorage = (function () {
    var AWLStorageObj = {};
    if (!window.localStorage) {
        alert("您的浏览器版本过低，暂时不支持访问！");
        return false;
    }

    function isQuotaExceeded(e) {
        var quotaExceeded = false;
        if (e) {
            if (e.code) {
                switch (e.code) {
                    case 22:
                        quotaExceeded = true;
                        break;
                    case 1014: // Firefox
                        if (e.name === 'NS_ERROR_DOM_QUOTA_REACHED') {
                            quotaExceeded = true;
                        }
                        break;
                }
            } else if (e.number === -2147024882) { // IE8
                quotaExceeded = true;
            }
        }
        return quotaExceeded;
    }

    function setLocalStorage(key, value) {
        var curtime = new Date().getTime(); // 获取当前时间 ，转换成JSON字符串序列
        var valueDate = JSON.stringify({
            val: value,
            timer: curtime
        });
        try {
            localStorage.setItem(key, valueDate);
        } catch (e) {
            // 兼容性写法
            if (isQuotaExceeded(e)) {
                console.log("Error: 本地存储超过限制");
                localStorage.clear();
            } else {
                console.log("Error: 保存到本地存储失败");
            }
        }
    }

    function getLocalStorage(key) {
        var exp = 60 * 60 * 24 * 1000;
        if (localStorage.getItem(key)) {
            var vals = localStorage.getItem(key); // 获取本地存储的值
            var dataObj = JSON.parse(vals); // 将字符串转换成JSON对象
            // 如果(当前时间 - 存储的元素在创建时候设置的时间) > 过期时间
            var isTimed = (new Date().getTime() - dataObj.timer) > exp;
            if (isTimed) {
                console.log("存储已过期");
                localStorage.removeItem(key);
                return null;
            } else {
                var newValue = dataObj.val;
            }
            return newValue;
        } else {
            return null;
        }
    }

    AWLStorageObj.sessionSave = function (key, value) {
        setLocalStorage(key, value);
        return true;
    };
    AWLStorageObj.sessionGet = function (key) {
        return getLocalStorage(key);
    };
    AWLStorageObj.save = function (key, value) {
        // localStorage.setItem(key, value);
        // return true;
        setLocalStorage(key, value);
        return true;
    };
    AWLStorageObj.get = function (key) {
        return getLocalStorage(key);
        // return localStorage.getItem(key);
    };
    AWLStorageObj.remove = function (key) {
        localStorage.removeItem(key);
        return true;
    };
    return AWLStorageObj;
})();
/**
 * 日期转换类
 */
var AWLDateUtil = (function () {
    var AWLDateUtilObj = {};
    AWLDateUtilObj.dateToTime = function (dateStr) {
        return (new Date(dateStr)).getTime();
    };
    AWLDateUtilObj.dateToEnStr = function (dateStr) {
        return dateToEn(new Date(dateStr));
    };
    AWLDateUtilObj.timeToDate = function (timesteamp) {
        return dateToString(new Date(parseInt(timesteamp)));
    };
    return AWLDateUtilObj;
})();

var dateToEn = function (date) {
    var dt = date;
    var m = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Spt", "Oct", "Nov", "Dec"];
    var w = ["Monday", "Tuseday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];
    var d = ["st", "nd", "rd", "th"];
    mn = dt.getMonth();
    wn = dt.getDay();
    dn = dt.getDate();
    var dns;
    if (((dn % 10) < 1) || ((dn % 10) > 3)) {
        dns = d[3];
    }
    else {
        dns = d[(dn % 10) - 1];
        if ((dn === 11) || (dn === 12)) {
            dns = d[3];
        }
    }
    return m[mn] + " " + dn + dns + ", " + dt.getFullYear() + ", " + w[wn - 1];
};
var dateToString = function (date) {
    var year = date.getFullYear();
    var month = (date.getMonth() + 1).toString();
    var day = (date.getDate()).toString();
    if (month.length === 1) {
        month = "0" + month;
    }
    if (day.length === 1) {
        day = "0" + day;
    }
    return year + "-" + month + "-" + day;
};
/**
 * 页面跳转
 */
var AWLPage = (function () {
    var AWLPageObj = {};
    AWLPageObj.redirectTo = function (link) {
        window.location.href = link;
    };
    AWLPageObj.open = function (link) {
        window.open(link);
    };
    AWLPageObj.refresh = function (link) {
        window.location.reload();
    };
    AWLPageObj.back = function (link) {
        window.history.back();
    };
    AWLPageObj.forward = function (link) {
        window.history.forward();
    };
    AWLPageObj.return = function (link) {
        window.history.go(-1);
    };
    return AWLPageObj;
})();

var AWLUtils = (function () {
    var AWLUtilsObj = {};
    /**
     * select生成器
     */
    AWLUtilsObj.loadSelectData = function (selectElem, dataList, titleName, valueName, hasDefault) {
        $(selectElem).html("");
        if (hasDefault) {
            var defaultItem = $("<option></option>");
            $(defaultItem).text("请选择..");
            $(defaultItem).val(-1);
            $(selectElem).append(defaultItem);
        }
        console.log(dataList);
        for (var i = 0; i < dataList.length; i++) {
            //初始化数据
            var data = dataList[i];
            if (!data) {
                continue;
            }
            var title = data[titleName];
            var value = data[valueName];
            //初始化选择对象
            var optionElem = $("<option></option>");
            $(optionElem).text(title);
            $(optionElem).val(value);
            //添加到选择容器
            $(selectElem).append(optionElem);
        }
    };

    /**
    * role头像转换器
    * */
    AWLUtilsObj.getAvatar = function (role) {
        return "/avatar/"+role.toLowerCase()+".png";
    };
    return AWLUtilsObj;


    /**
     * 根据roles获取主角色id
     * */
    AWLUtilsObj.getMainRole = function (roles) {
        var max = 0;
        roles = roles.split(",");
        for(var i=0; i<roles.length; i++){
            var roleInt = parseInt(roles[i]);
            if(roleInt > max)
                max = roleInt;
        }

        return max;
    }
})();
/**
 *
 */
var AWLPageUtil = function () {
    var pageUtilObj = {};
    var pageStart = 1;
    var pageEnd = 1;
    var offset = 0;
    var btnNum = 0;
    var currentPage = 0;
    var allPageNum = 0;

    function findStart() {
        pageStart = currentPage - parseInt(btnNum / 2);
        if (pageStart < 1) {
            offsetEnd(1 - pageStart);
            pageStart = 1;
            return false;
        }
        return true;
    }

    function offsetStart(num) {
        pageStart = currentPage - parseInt(btnNum / 2) - num;
        if (pageStart < 1) {
            pageStart = 1;
            return false;
        }
        return true;
    }


    function findEnd() {
        pageEnd = currentPage + parseInt(btnNum / 2);
        if (pageEnd > allPageNum) {
            offsetStart(pageEnd - allPageNum);
            pageEnd = allPageNum;
            return false;
        }
        return true;
    }

    function offsetEnd(num) {
        pageEnd = currentPage + parseInt(btnNum / 2) + num;
        if (pageEnd > allPageNum) {
            pageEnd = allPageNum;
            return false;
        }
        return true;
    }

    pageUtilObj.getPageRange = function () {
        if (btnNum > allPageNum) {
            btnNum = allPageNum;
        }
        if (findStart()) {
            findEnd();
        }
        return {
            "start": pageStart,
            "end": pageEnd
        }
    };
    pageUtilObj.init = function (conf) {
        btnNum = conf.btnNum;
        currentPage = conf.currentPage;
        allPageNum = conf.allPageNum;
    };
    return pageUtilObj;
};
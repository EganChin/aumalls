/**
 * 臻我生活专用http请求框架
 * date: 2019/5/23 10:00
 * by: 陈奕铠
 */

/**
 * AWLHttp类
 * 全局对象，使用AWLHttp可以快速轻松的访问指定请求
 */
var AWLHttp = (function () {
    var AWLHttpObj = {};
    var header = {
        "token": ""
    };

    AWLHttpObj.post = function (addr, params, callBack) {
        AWLHttpObj.sendRequest({address: addr, method: "POST", header: {}, params: params, callBack: callBack});
    };
    AWLHttpObj.get = function (addr, params, callBack) {
        AWLHttpObj.sendRequest({address: addr, method: "GET", header: {}, params: params, callBack: callBack});
    };

    AWLHttpObj.strToJson = function (str) {
        return JSON.parse(str);
    };
    AWLHttpObj.jsonToStr = function (obj) {
        return JSON.stringify(obj);
    };
    AWLHttpObj.setToken = function (token) {
        header.token = token;
    };
    AWLHttpObj.getToken = function () {
        return header.token;
    };
    (function tokenSet() {
        var session = AWLHttpObj.strToJson(AWLStorage.sessionGet("userSession"));
        if (session !== null && session !== undefined) {
            AWLHttpObj.setToken(session.token);
        }
    })();
    AWLHttpObj.uploadImg = function (file, type, callBack) {
        var formData = new FormData();
        formData.append("files", file);
        formData.append("type", type);
        $.ajax({
            url: httpAddress.resourceImage,
            type: "POST",
            data: formData,
            headers: header,
            contentType: false,
            processData: false,
            success: function (message) {
                if (message.code === httpCode.unauthorized)
                    AWLPage.redirectTo("/back/admin-adminlogin.html");
                if (message.code !== httpCode.success) {
                    AWLDialog.showMsg("提示信息", message.msg);
                } else {
                    callBack(message.data.images);
                }
            },
            error: function (message) {
                AWLDialog.showMsg("网络异常", message.statusText);
            }
        });
    };
    AWLHttpObj.sendRequest = function (json) {
        console.log("request");
        var method = json["method"];
        var params = json["params"];
        var async = json["async"];
        var contentType = json["contentType"];
        var callBack = json["callBack"];

        //设置默认值
        if (async === null) async = true;
        if (!contentType) contentType = "application/json; charset=utf-8";

        var loadingDiv = $("#loadingDiv");
        // //封锁页面
        // if (!json["block"]) {
        //     //防止重复创建
        //     if (loadingDiv.length === 0) {
        //         console.log("creating loading div");
        //         $("body").append("<div id=\"loadingDiv\">\n" +
        //             "\t<img id='loadingImg' src=\"assets/images/loading.png\" /> \n" +
        //             "     </div>");
        //         loadingDiv = $("#loadingDiv");
        //     }
        //     loadingDiv.fadeTo(200, 0.5);
        // }
        if (method === "POST")
            params = AWLHttpObj.jsonToStr(params);

        console.log(" send request to " + json["address"]);
        $.ajax({
            type: method,
            async: async,
            url: json["address"],
            contentType: contentType,
            dataType: "json",
            headers: json["header"],
            data: params,
            success: function (message) {
                // $("#loadingDiv").fadeOut(200);
                // 用户未登录，显示登录框
                if (message.code === httpCode.unauthorized) {
                    // AWLPage.redirectTo("/login.html");
                    AWLStorage.remove("user");
                    document.cookie = "token=xxx&expire=-10000";
                    location.reload();
                    return;
                }
                if (message.code !== httpCode.success) {
                    alert(message.message);
                    return;
                }
                callBack.success(message);
            },
            error: function (message) {
                // $("#loadingDiv").fadeOut(200);
                AWLStorage.setCookie("token", "token", "h-100");
                AWLStorage.remove("user");
                if (message.code){

                    alert("发生脚本或网络错误：" + message.code);
                }
                location.reload();
                // callBack.error(message);
            }
        });
    };
    /**
     * 获取指定URL的参数值
     * @param name 参数名称
     * @return 参数值
     */
    AWLHttpObj.getParam = function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    };
    return AWLHttpObj;
})();
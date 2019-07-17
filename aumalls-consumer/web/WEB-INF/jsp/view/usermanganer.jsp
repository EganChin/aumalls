<%@ page import="com.mall.common.utils.DateUtils" %>
<%--@elvariable id="DateUtils" type="com.mall.common.utils.DateUtils"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="base.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>managerGoods</title>
    <link rel="stylesheet" href="/resources/css/list.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminnistrators.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/manager.css">

    <script src="/resources/js/framework/AWLCore.js"></script>
    <script src="/resources/js/framework/AWLConst.js"></script>
    <script src="/resources/js/framework/AWLHttp.js"></script>

</head>
<body>
<nav class="navigation-back fixed-top">
    <div class="navbar navbar-expand-sm" style="width:1024px;margin: 0 auto;">
        <a class="nav-logo col-1" style="margin-right: 50px" href="#">
            <img src="${pageContext.request.contextPath}/resources/images/headimg.png" height="35"/>
        </a>
        <div class="collapse navbar-collapse col-3" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="navigation-link" href="#">管理员</a>
                </li>
                <li class="nav-item">
                    <a class="navigation-link" href="#"> </a>
                </li>
                <li class="nav-item">
                    <a class="navigation-link" href="#">退出管理</a>
                </li>
            </ul>
        </div>

        <div class="row" style="margin-left: 225px">
            <button type="button" id="Popover8-toggle" aria-haspopup="true" aria-expanded="false"
                    aria-owns="Popover8-content" class="Button PushNotifications-icon Button--plain"><span
                    style="display: inline-flex; align-items: center;">&#8203;<svg class="Zi Zi--Bell"
                                                                                   fill="currentColor"
                                                                                   viewBox="0 0 24 24" width="22"
                                                                                   height="22"><path
                    d="M4.523 15.076l.804-6.757a6.753 6.753 0 0 1 4.945-5.7 1.823 1.823 0 0 1 3.623 0 6.753 6.753 0 0 1 4.945 5.7l.804 6.757a2.293 2.293 0 0 0 1.712 2.108 1.093 1.093 0 0 1-.297 2.15H3.108a1.093 1.093 0 0 1-.297-2.15 2.293 2.293 0 0 0 1.712-2.108zM12.083 23a2.758 2.758 0 0 1-2.753-2.509.229.229 0 0 1 .232-.24h5.043a.229.229 0 0 1 .232.24 2.759 2.759 0 0 1-2.753 2.51z"></path></svg></span>
            </button>
            <button type="button" id="Popover9-toggle" aria-haspopup="true" aria-expanded="false"
                    aria-owns="Popover9-content" class="Button Messages-icon Button--plain"><span
                    style="display: inline-flex; align-items: center;">&#8203;<svg class="Zi Zi--Comments"
                                                                                   fill="currentColor"
                                                                                   viewBox="0 0 24 24" width="22"
                                                                                   height="22"><path
                    d="M11 2c5.571 0 9 4.335 9 8 0 6-6.475 9.764-11.481 8.022-.315-.07-.379-.124-.78.078-1.455.54-2.413.921-3.525 1.122-.483.087-.916-.25-.588-.581 0 0 .677-.417.842-1.904.064-.351-.14-.879-.454-1.171A8.833 8.833 0 0 1 2 10c0-3.87 3.394-8 9-8zm10.14 9.628c.758.988.86 2.009.86 3.15 0 1.195-.619 3.11-1.368 3.938-.209.23-.354.467-.308.722.12 1.073.614 1.501.614 1.501.237.239-.188.562-.537.5-.803-.146-1.495-.42-2.546-.811-.29-.146-.336-.106-.563-.057-2.043.711-4.398.475-6.083-.927 5.965-.524 8.727-3.03 9.93-8.016z"
                    fill-rule="evenodd"></path></svg></span></button>
            <!--<button type="button" id="Popover10-toggle" aria-haspopup="true" aria-expanded="false"-->
            <!--aria-owns="Popover10-content" class="Button Button&#45;&#45;plain"><img-->
            <!--class="Avatar AppHeader-profileAvatar" width="40" height="40"-->
            <!--src="https://pic4.zhimg.com/da8e974dc_is.jpg" srcset="${pageContext.request.contextPath}/assets/img/headimg.png">-->
            <!--</button>-->
        </div>
    </div>
</nav>
<div class="color-container position-container row">
    <div class="col-2">
        <div class="list-group list-box">
            <a id="list1" href="#" class="list-group-item list-group-item-dark list-set" style="margin-top: 25px">系统首页</a>
            <a id="list2" href="#" class="list-group-item list-group-item-dark list-set">用户管理</a>
            <a id="list3" href="#" class="list-group-item list-group-item-dark list-set">商品管理</a>
            <a id="list4" href="#" class="list-group-item list-group-item-dark list-set">订单管理</a>
            <a id="list5" href="#" class="list-group-item list-group-item-dark list-set">发布公告</a>
            <a id="list6" href="#" class="list-group-item list-group-item-dark list-set">管理员</a>
            <a id="list7" href="#" class="list-group-item list-group-item-dark list-set">图表显示</a>
            <a id="list8" href="#" class="list-group-item list-group-item-dark list-set">系统管理</a>
        </div>
    </div>
    <div class="col-9" style="background: #f4f4f4;margin-left: 10px;margin-top: 20px">
        <div id="managerUser" class="">


            <ul id="userdata">
                <li>
                    <p style="display: inline-table">用户名            </p>
                    <p style="display: inline-table">用户地址          </p>
                    <p style="display: inline-table">用户电话          </p>
                    <p style="display: inline-table">用户限制时间       </p>
                </li>
                <c:forEach var="item" items="${data.list}">
                    <li>
                        <p style="display: inline-table">${item.userName}         </p>
                        <p style="display: inline-table">${item.userAddress}      </p>
                        <p style="display: inline-table">${item.userPhone}        </p>
                        <p style="display: inline-table" data_obj="${item.userId}"><input class="usertime" type="datetime-local" min="2017-06-30T00:00" value="${item.userWhitetime}"></p>

                    </li>

                </c:forEach>
            </ul>

            <div class="change" id="pn">
                <span class="left" id="left">&lt;</span>
                <span class="right" id="right">&gt;</span>
            </div>

        </div>
        <div id="managerOrder" class="controlDisplay">

        </div>
        <div id="managerSystem" class="controlDisplay">

        </div>
        <div id="">

        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/resources/js/controller/paging.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controlDisplay.js"></script>
<script>

    userPageBtn(${data.ps}, ${data.total})

    $(".usertime").change(function () {

        var t = $(this).val();
        var id = $(this).parent().attr("data_obj")

        if(confirm("是否修改用户显示登录限制时间")){
            AWLHttp.post(httpAddress.updataUserWhitetime + "?userid=" +id + "&time="+ t, {}, {
                success:function(result){
                    if(result.code == 200){
                        alert("修改成功！")
                    }
                }
            })
        }
    })


</script>
</html>
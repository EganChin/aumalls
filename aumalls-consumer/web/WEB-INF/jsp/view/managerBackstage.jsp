<%@page pageEncoding="UTF-8" %>
<%@ include file="base.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>managerGoods</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/resources/js/manager/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminnistrators.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/manager.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/list.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/chat.css">
    <script src="${pageContext.request.contextPath}/resources/js/framework/AWLCore.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/framework/AWLConst.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/framework/AWLHttp.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/manager/manageUtil.js"></script>

</head>
<body>
<jsp:include page="chat.jsp"/>
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
                    aria-owns="Popover9-content" class="Button Messages-icon Button--plain">
                <span id="chat-cservice" style="display: inline-flex; align-items: center;">&#8203;
                <svg class="Zi Zi--Comments"
                     fill="currentColor"
                     viewBox="0 0 24 24" width="22"
                     height="22"><path
                        d="M11 2c5.571 0 9 4.335 9 8 0 6-6.475 9.764-11.481 8.022-.315-.07-.379-.124-.78.078-1.455.54-2.413.921-3.525 1.122-.483.087-.916-.25-.588-.581 0 0 .677-.417.842-1.904.064-.351-.14-.879-.454-1.171A8.833 8.833 0 0 1 2 10c0-3.87 3.394-8 9-8zm10.14 9.628c.758.988.86 2.009.86 3.15 0 1.195-.619 3.11-1.368 3.938-.209.23-.354.467-.308.722.12 1.073.614 1.501.614 1.501.237.239-.188.562-.537.5-.803-.146-1.495-.42-2.546-.811-.29-.146-.336-.106-.563-.057-2.043.711-4.398.475-6.083-.927 5.965-.524 8.727-3.03 9.93-8.016z"
                        fill-rule="evenodd"></path>
                </svg>
                    <div id="chat-inform" class="all">
                        <ul>
                        <%--<ul>--%>
                            <li><h5>（周志远）</h5> 那怎么办</li>
                            <li><h5>（周志勇）</h5> 我也不是很清楚</li>
                            <li><h5>（周志信）</h5> 我也不是很懂</li>
                        <%--</ul>--%>
		            </ul>
                    </div>

                </span>

            </button>
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
            <a id="list1" href="#" class="list-group-item list-group-item-dark list-set"
               style="margin-top: 25px">系统首页</a>
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
        <div id="managerHomePage" class="context-container controlDisplay">
            <div class="card bg-info text-white col-2 card-modify">
                <div id="userManager" class="card-body cardBody-modify">用户管理</div>
            </div>
            <div class="card bg-primary text-white col-2 card-modify">
                <div id="goodsManager" class="card-body cardBody-modify">商品管理</div>
            </div>
            <div class="card bg-success text-white col-2 card-modify">
                <div id="ordersManager" class="card-body cardBody-modify">订单管理</div>
            </div>
            <div class="card bg-warning text-white col-2 card-modify">
                <div id="systemManager" class="card-body cardBody-modify">系统管理</div>
            </div>
            <div>
                <div class="system-info col-3">
                    <label class="system-item1">系统现状</label>
                    <div class="system-div">
                        <span class="system-item2">注册用户数:</span>
                        <span>${userNumber}</span>
                    </div>
                    <div class="system-div">
                        <span class="system-item2">注册店铺数:</span>
                        <span>3</span>
                    </div>
                </div>
                <div class="system-info col-3">
                    <label class="system-item1">系统运营</label>
                    <div class="system-div">
                        <span class="system-item2">系统运营时长:</span>
                        <span>50</span>
                    </div>
                    <div class="system-div">
                        <span class="system-item2">系统运营时长:</span>
                        <span>50</span>
                    </div>
                </div>
                <div class="system-info col-4">
                    <label class="system-item1">系统管理员</label>
                    <div class="system-div">
                        <span class="system-item2">昵称:</span>
                        <span>李大拿</span>
                        <span class="system-item2" style="margin-left: 20px">角色:</span>
                        <span>李大拿</span>
                    </div>
                </div>
            </div>
        </div>
        <div id="managerGoods" class="context-container controlDisplay">
            <div class="container">
                <h3>商品管理</h3>
                <br>
                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist">
                    <li class="nav-item" id="homeManager">
                        <a class="nav-link active" data-toggle="tab" href="#home">商品审批</a>
                    </li>
                    <li class="nav-item" id="menu1Manager">
                        <a class="nav-link" data-toggle="tab" href="#menu1">商品管理</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#menu2">Menu 2</a>
                    </li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                    <div id="home" class="container tab-pane active"><br>
                        <div class="change" id="pn">
                            <span class="left" id="left">&lt;</span>
                            <span class="right" id="right">&gt;</span>
                        </div>
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>商品名</th>
                                <th>商品价格</th>
                                <th>商品数量</th>
                                <th>商品类型</th>
                            </tr>
                            </thead>
                            <tbody id="goods-apply">
                            <!--动态生成-->
                            </tbody>
                        </table>
                    </div>
                    <div id="menu1" class="container tab-pane fade"><br>
                        <div class="change" id="menulPn">
                            <span class="left" id="menu1Left">&lt;</span>
                            <span class="right" id="menu1Right">&gt;</span>
                        </div>
                        <table>
                            <thead>
                            <tr>
                                <th>商品名</th>
                                <th>商品价格</th>
                                <th>商品数量</th>
                                <th>商品类型</th>
                            </tr>
                            </thead>
                            <tbody id="goods-manager">
                            <c:forEach items="${page.list}" var="goods">
                                <tr>
                                    <td>${goods.goodsName}</td>
                                    <td>${goods.goodsPrice}</td>
                                    <td>${goods.goodsNum}</td>
                                    <td>${goods.typeName}</td>
                                    <td>
                                        <button id="goodsView-${goods.goodsId}">查看</button>
                                        <button id="goodsLs-${goods.goodsId}">下架</button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div id="menu2" class="container tab-pane fade"><br>
                        <h3>Menu 2</h3>
                        <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                            laudantium, totam rem aperiam.</p>
                    </div>
                </div>
            </div>
        </div>
        <div id="managerUser" class=" controlDisplay">

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
<script src="${pageContext.request.contextPath}/resources/js/controlDisplay.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/manager/managerGoods.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/manager/managerGoodsIn.js"></script>
<script>
    addPageBtn(${page.ps}, ${page.total})
</script>
</html>
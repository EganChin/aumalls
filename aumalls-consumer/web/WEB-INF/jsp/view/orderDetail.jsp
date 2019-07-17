<%@page pageEncoding="UTF-8"%>
<%@ include file="base.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>orderDetail</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/resources/js/framework/AWLCore.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/framework/AWLConst.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/framework/AWLHttp.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap-4.3.1-dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-light">

<nav class="navbar navbar-dark bg-primary" style="background-color: #e3f2fd;">
    <a class="navbar-brand" href="#" id="back-to-orders"><h6><返回我的订单</h6></a>
</nav>

<nav class="navbar navbar-dark bg-primary" style="background-color: #e3f2fd;">
    <div class="container" >
        <div class="jumbotron navbar navbar-dark bg-primary">
            <h1 class="display-3 text-white" id="statusName">
                ${orderDetail.orderStatusName}
            </h1>
        </div>
    </div>
</nav>

<div class="container" id="orderDetail-Page">

    <div class="media border pt-3 pb-3 pl-2 pr-2">
        <div style="height: 50px;width: 50px"  class="pr-2 align-self-center"><img class="mr-3 img-responsive center-block img-thumbnail border-0" src="${pageContext.request.contextPath}/resources/js/lazyload/locImg.jpg" alt="locImgae"></div>
        <div class="media-body">
            <h5 class="mt-0" id="name-and-phone">${orderDetail.orderName}  ${orderDetail.orderPhone}</h5>
            <span id="adress">${orderDetail.orderAddress}</span>
        </div>
    </div>

    <ul class="list-unstyled">
        <c:forEach var="detail" items="${orderDetail.orderDetails}">
            <li class="media p-2 border">
                <img style="height: 120px;width: 120px" class="mr-3 align-self-center img-responsive center-block img-thumbnail" src="${pageContext.request.contextPath}/resources/images/${detail.goodsImg}" alt="商品图片">
                <div class="media-body">
                    <h5 class="mt-0 mb-1" >${detail.goodsName}</h5>
                    <div class="float-right">￥${detail.detailPrice}<p/>×${detail.detailNum}</div>
                </div>
            </li>
        </c:forEach>
    </ul>

    <table class="table border">
        <thead>
        <tr>
            <th scope="col"><b>订单信息</b></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">订单编号：</th>
            <td id="orderId">${orderDetail.orderId}</td>
        </tr>
        <tr>
            <th scope="row">订单总价：</th>
            <td id="orderPrice">￥${orderDetail.orderPrice}</td>
        </tr>
        <tr>
            <th scope="row">创建时间：</th>
            <td id="orderTime">${orderDetail.orderTime}</td>
        </tr>
        </tbody>
    </table>

    <c:choose>
        <c:when test="${orderDetail.orderStatus==2}">
            <div class="row float-right pr-3" id="orderHandle"><button type="button" class="btn btn-outline-primary handleButton" id="pay">付款</button></div>
        </c:when>
        <c:when test="${orderDetail.orderStatus==3}">
            <div class="row float-right pr-3" id="orderHandle"><button type="button" class="btn btn-outline-primary handleButton" id="urge">催单</button></div>
        </c:when>
        <c:when test="${orderDetail.orderStatus==4}">
            <div class="row float-right pr-3" id="orderHandle"><button type="button" class="btn btn-outline-primary handleButton" id="trace">查看物流</button></div>
        </c:when>
        <c:when test="${orderDetail.orderStatus==5}">
            <div class="row float-right pr-3" id="orderHandle"><button type="button" class="btn btn-outline-primary handleButton" id="评论">评论</button></div>
        </c:when>
    </c:choose>


    <div class="mb-5"></div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/controller/orderDetail.js"></script>
</body>
</html>
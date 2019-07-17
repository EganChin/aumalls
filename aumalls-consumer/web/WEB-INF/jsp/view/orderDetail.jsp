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
            <h1 class="display-3 text-white" id="statusName">交易成功</h1>
        </div>
    </div>
</nav>

<div class="container" id="orderDetail-Page">

    <div class="media border pt-3 pb-3 pl-2 pr-2">
        <div style="height: 50px;width: 50px"  class="pr-2 align-self-center"><img class="mr-3 img-responsive center-block img-thumbnail border-0" src="../img/locImg.jpg" alt="Generic placeholder image"></div>
        <div class="media-body">
            <h5 class="mt-0" id="name-and-phone">Name  Phone</h5>
            <span id="adress">adress</span>
        </div>
    </div>

    <ul class="list-unstyled">
        <li class="media p-2 border">
            <img class="mr-3 align-self-center" src="..." alt="商品图片">
            <div class="media-body">
                <h5 class="mt-0 mb-1" >List-based media object</h5>
                <div class="float-right">￥50.00<p/>×1</div>
            </div>
        </li>
        <li class="media p-2 border">
            <img class="mr-3 align-self-center" src="..." alt="商品图片">
            <div class="media-body">
                <h5 class="mt-0 mb-1" >List-based media object</h5>
                <div class="float-right">￥50.00<p/>×1</div>
            </div>
        </li>
        <li class="media p-2 border">
            <img class="mr-3 align-self-center" src="..." alt="商品图片">
            <div class="media-body">
                <h5 class="mt-0 mb-1" >List-based media object</h5>
                <div class="float-right">￥50.00<p/>×1</div>
            </div>
        </li>
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
            <td id="orderId">1234567890</td>
        </tr>
        <tr>
            <th scope="row">订单总价：</th>
            <td id="orderPrice">￥520.00</td>
        </tr>
        <tr>
            <th scope="row">创建时间：</th>
            <td id="orderTime">2019-12-31</td>
        </tr>
        </tbody>
    </table>

    <div class="row float-right pr-3" id="orderHandle"><button type="button" class="btn btn-outline-primary" id="handleButton">付款</button></div>

    <div class="mb-5"></div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/controller/orderDetail.js"></script>
</body>
</html>
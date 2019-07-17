<%@page pageEncoding="UTF-8"%>
<%@ include file="base.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>order</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/resources/js/framework/AWLCore.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/framework/AWLConst.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/framework/AWLHttp.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap-4.3.1-dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

<nav class="navbar navbar-dark bg-primary" style="background-color: #e3f2fd;">
    <a class="navbar-brand " href="#" id="myOrder"><h1>我的订单</h1></a>
    <a class="navbar-brand" href="#" id="backToIndex"><h6>返回首页</h6></a>
</nav>

<div class="container" id="order-page">

    <div class="row" id="status-nav">
        <ul class="nav nav-tabs" role="tablist">
            <li class="nav-item">
                <a class="nav-link active" href="#" role="tab" data-toggle="tab" aria-controls="nav0" aria-selected="true">全部订单</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" role="tab" data-toggle="tab" aria-controls="nav1" aria-selected="false" >报关中</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" role="tab" data-toggle="tab" aria-controls="nav2" aria-selected="false">待付款</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" role="tab" data-toggle="tab"  aria-controls="nav3" aria-selected="false" >即将发货</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" role="tab" data-toggle="tab" aria-controls="nav4" aria-selected="false" >正在发货</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" role="tab" data-toggle="tab" aria-controls="nav5" aria-selected="false" >交易成功</a>
            </li>
        </ul>
    </div>

    <div class="row " style="margin-top: 20px">
        <table class="table text-center " id="orders-table">

            <thead>
            <tr class="thead-light small">
                <th scope="col">商品</th>
                <th scope="col">订单号</th>
                <th scope="col">总价</th>
                <th scope="col">商品状态</th>
                <th scope="col">订单日期</th>
                <th scope="col">交易操作</th>
            </tr>
            </thead>
            <tbody id="orders-list">
            </tbody>
        </table>
    </div>

    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                    <span class="sr-only">上一页</span>
                </a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                    <span class="sr-only">下一页</span>
                </a>
            </li>
        </ul>
    </nav>
</div>

<script src="${pageContext.request.contextPath}/resources/js/controller/order.js"></script>
</body>
</html>
<%@page pageEncoding="UTF-8"%>
<%@ include file="base.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>order</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/base.css">
    <script src="${pageContext.request.contextPath}/resources/js/framework/AWLCore.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/framework/AWLConst.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/framework/AWLHttp.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap-4.3.1-dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>


<div class="container" id="order-page">

    <header class="wrap-all" style="margin-bottom: 20px">
        <div class="head border-top border-bottom container-fluid">
            <!-- 头部左边 -->
            <div class="headLeft">
                <div class="hello">
                    <a href="#">
                        <em></em>
                        <span>澳猫首页</span>
                    </a>
                </div>
            </div>
        </div>
    </header>

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

            <tr id="order-sample">
                <th scope="row"><img class="mr-3" src="..." alt="Generic placeholder image"></th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
                <td><a href="#" class="link">付款</a></td>
            </tr>

            <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
            </tr>

            </tbody>
        </table>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/controller/order.js"></script>
</body>
</html>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>register</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/register2.css">
    <script src="${pageContext.request.contextPath}/resources/js/manager/jquery-3.4.1.js"></script>
</head>
<body>
<div id="register">
    <div class='login-dialog-bg'>
        <div class='login-panel'>
            <div class='login-container'>
                <!--Start-->
                <div class="ourrent-logo">
                    <img src="${pageContext.request.contextPath}/resources/img/logoBig_ourrent.png"/>
                </div>
                <div class="ourrent-slogen">
                    注册澳猫商城，带给你不一样的盛宴！
                </div>
                <div>
                    <form method="post" role="form" name="toRegister" action="/toRegister/addUser" onsubmit="return check()" >
                        <div class="row">
                            <div class="col-12">
                                <input class="form-control login-input" value="" name="userName"
                                       id="userName" placeholder="用户名">
                                <input class="form-control login-input" value="" name="userPhone"
                                       id="userPhone" placeholder="手机号"
                                       pattern="(^(\d{3,4}-)?\d{7,8})$|(1[3|5|7|8]\d{9})">
                                <input class="form-control login-input" value="" name="userAddress"
                                       id="userAddress" placeholder="地址">
                                <input class="form-control login-input" value="" name="userPass"
                                       id="userPass" placeholder="密码">
                                <input class="form-control login-input" value="" name="password-confirm"
                                       id="password-confirm" placeholder="确认密码">
                                <input type="hidden" value="200" name="score">
                            </div>
                        </div>
                        <div>
                            <button type="submit" class="btn btn-info login-button"  onclick="play()">注册</button>
                        </div>
                    </form>
                </div>
                <!--End-->
            </div>
            <div class="go-register">
                <span id="to-register">
                    已有账号？
                    <a href="#"><span class="go-register-btn">登录</span></a>
                </span>
            </div>
        </div>
    </div>
</div>
<script>
    function check() {
        var name = window.document.getElementById("userName").value;
        var password = window.document.getElementById("userPass").value;
        var phone = window.document.getElementById("userPhone").value;
        var address = window.document.getElementById("userAddress").value;
        var password_confirm = window.document.getElementById("password-confirm").value;
        if (name === "" || password === "" || phone === "" || address === "") {
            window.alert("注册信息不能为空");
            return false;
        }
        if (password_confirm !== password) {
            window.alert("请确认密码输入正确！");
            return false;
        }
        return true;
    }
</script>
<script src="resources/js/register.js"></script>
<script type="text/javascript">
    function play()
        {
            alert("注册成功");
        }

</script>

</body>
</html>
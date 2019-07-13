<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/13
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="status" type="java.lang.Integer"--%>
<%@page pageEncoding="UTF-8"%>
<div class="login-dialog" id="login-dialog" style=${status==401?"display:block":"display:none"}>
    <div class="graybox"></div>
    <div class="popbox">
        <div class="poptop">
            <h3>登录</h3>
            <a id="close" class="close">X</a>
        </div>
        <div class="popcon">
            <div>
                <div class="group">
                    <input type="text" id="account" value="请输入帐号" onFocus="if(value=='请输入帐号') {value=''}"
                           onBlur="if(value==''){value='请输入帐号'}">
                    <i class="fa fa-user"></i>
                </div>
                <div class="group">
                    <input type="password" id="password" placeholder="请输入密码">
                    <i class="fa fa-lock"></i>
                </div>
            </div>
            <div class="remember clearfix">
                <div class="remember-con">
                    <input type="checkbox" id="remember" class="inputbox">
                    <label for="remember">记住密码</label>
                </div>
                <div class="remember-con">
                    <a href="#" class="code"><i class="fa fa-question-circle"></i>忘记密码</a>
                </div>
            </div>
        </div>
        <div class="divbtn clearfix">
            <a id="cancel-btn" class="btn" id="cancel">取消</a>
            <a id="login-btn" class="btn ok" href="javascript:void(0)">登录</a>
        </div>
    </div>
</div>

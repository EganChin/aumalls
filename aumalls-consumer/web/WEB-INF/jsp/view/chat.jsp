<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/13
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="status" type="java.lang.Integer"--%>
<%@page pageEncoding="UTF-8" %>
<div class="chat-dialog" id="chat-dialog" style="display:block">
    <div class="gray-screen"></div>
    <div class="chat-box">
        <div class="chat-top">
            <a id="chat-close" class="close">X</a>
        </div>
        <div class="msg-content" id="msg-content">
            <div class="lis_lf"><span class="peo"></span><p class="lis_txt">笑死</p></div>
            <div class="lis_rt"><span class="peo"></span><p class="lis_txt">笑死</p></div>
        </div>
        <div class="msg-box">
            <textarea id="chat-msg" class="chat-msg"></textarea>
        </div>
        <div class="chatbtn chatfix">
            <a id="send-button" class="btn send" href="javascript:void(0)">发送</a>
        </div>
    </div>
</div>

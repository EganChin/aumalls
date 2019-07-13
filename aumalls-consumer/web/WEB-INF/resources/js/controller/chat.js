$(function () {

    var sendMessage = function () {
        var msg = $("#chat-msg").val();
        var content = $("#msg-content");
        if(!msg){
            alert("消息不能为空");
            return;
        }

        content.append( '<div class="lis_lf"><span class="peo"></span><p class="lis_txt">'+msg+'</p></div>');
        $("#chat-msg").val("");
    };


    $("#send-button").click(function () {
        sendMessage();
    });

    $("#chat-close").click(function () {
        $("#chat-dialog").css("display","none");
    });

});
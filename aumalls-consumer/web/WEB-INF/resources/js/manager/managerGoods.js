var managerGoods=(function () {
    $("#list3").click(function () {
        getGoodsE0()
    })
    function getGoodsE0() {
        $.ajax({
            url:"../manager/goodsE0",
            type:"POST",
            dataType : "json",
            data:JSON.stringify({"pn":1,"ps":4}),
            contentType : "application/json; charset=utf-8",
            success: function (data) {
                alert("success!")
                // var GoodsList = JSON.parse(data)
                // for(var i = 0;i<Goods.length;i++){
                //     var good = GoodsList[i]
                //     var annexHtml = "<tr>"
                //         +"<td>"+good.goodsName+"</td>"
                //         +"<td>"+good.goodsPrice+"</td>"
                //         +"<td>"+good.goodsNumber+"</td>"
                //         +"<td>"+good.goodsType+"</td>"
                //         +"<td style='color: #005cbf'>"+"<button id='agreeAdd-"+good.goodsId+"'>同意</button>"
                //         +"<button id='refuseAdd-" + good.goodsId + "'>拒绝</button></td>"
                //         +"</tr>"
                //     $("#goods-apply").append(annexHtml)
                // }
            }
        })
    }

    var inform = $('#chat-inform');
    $('#chat-span').hover(function(e) {
        console.log("hover");
        inform.children().stop().slideToggle();
    })
})();
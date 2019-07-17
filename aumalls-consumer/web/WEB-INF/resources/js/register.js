$(function() {
	$('.PNunber .checkbox').click(function(event) {
		if ($('.PNunber .checkbox').hasClass('checked')) {
			$(this).removeClass('checked');
			$('.chp input').addClass('Cn');
		}else{
			$(this).addClass('checked');
			$('.chp input').removeClass('Cn');
		}
	});
	$('input').focusin(function(event) {
		$(this).css('borderColor', '#0079CC');
	});
	$('input').focusout(function(event) {
		$(this).css('borderColor', '#CACACA');
	});
});

// $('#register').on('submit', function(){
// 	event.preventDefault(); //阻止form表单默认提交
// 	registCheck();
// });
//
// function registCheck(){
// 	var userName = window.document.getElementById("uname").value;
// 	var userPass = window.document.getElementById("password").value;
// 	var userPhone = window.document.getElementById("phone").value;
// 	var userAddress = window.document.getElementById("address").value;
// 	var userRepassword = window.document.getElementById("password-confirm").value;
//
//
// 	if(userName&&userPass&&userRepassword&&userAddress&&userPhone){
// 		let user = { "userName": userName, "userPass": userPass, "userPhone": userPhone ,"userAddress":userAddress};
// 		let jsonData = JSON.stringify(user).toString();
// 		$.ajax({
// 			url: "/user/addUser.shtml",
// 			type: "POST",
// 			data: {
// 				"jsonData":jsonData
// 			},
// 			success: function (mes) {
// 				console.log(mes);
// 				if(mes!=0){
// 					alert("注册成功!");
// 					window.location.href='/user/login.shtml';
// 				}
// 				else{
// 					alert("注册失败!");
// 				}
// 			},
// 			error:function (err) {
// 				console.log(err);
// 				alert("注册失败!");
// 			}
// 		});
// 	}else {
// 		alert("注册失败!,请检查注册信息!");
// 	}
//
// };
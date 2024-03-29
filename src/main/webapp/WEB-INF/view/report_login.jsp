<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Report Login</title>
		<script>
			var i = 0;
			function changeAuthCodeImage() {
				// 在網址列?後面加上一個會常變動的資料 , 強迫瀏覽器去更新網址內容 , 避免 cashe 效應
				//document.getElementById('authcodeimage').src="/JavaWeb_20220705/captcha/authcodeimage2?i=" + (++i);
				document.getElementById('authcodeimage').src="/JavaWeb_20220705/captcha/authcodeimage2?i=" + new Date();
				//console.log("/JavaWeb_20220705/captcha/authcodeimage2?i=" + new Date());
				console.log("/JavaWeb_20220705/captcha/authcodeimage2?i=" + (++i));
			}
		</script>
	</head>
	<body style="padding: 15px">
		<form class="pure-form" method="post" action="">
			<fieldset>
				<legend>Report Login 一次性</legend>
				Username: <input type="text" id="username" name="username" /><p />
				驗證授權碼: <input type="text" id="userAuthCode" name="userAuthCode" >
				<!--  
				<iframe valign="middle" frameborder="0" width="85" height="30" id="authcodeimage"
				 		src="/JavaWeb_20220705/captcha/authcodeimage2" ></iframe>
				-->
				<img valign="middle" src="/JavaWeb_20220705/captcha/authcodeimage2"
					 id="authcodeimage"/> 		
				<button type="button" onclick="changeAuthCodeImage()" class="pure-button pure-button-primary">更新</button><p /> 	 
				<button type="reset" class="pure-button pure-button-primary">重置</button>	 	 
				<button type="submit" class="pure-button pure-button-primary">傳送</button>
			</fieldset>	
		</form>
	</body>
</html>
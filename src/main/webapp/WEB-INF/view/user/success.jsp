<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
${ action }<p />
${ rowcount }
 -->
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
	<meta charset="UTF-8">
	<title>User Success</title>
</head>
<body style="padding: 15px">
	<form class="pure-form" action="${ pageContext.request.contextPath }/users">
		<fieldset>
   			<legend>
   				<img src="${ pageContext.request.contextPath }/images/user.png" width="40" valign="middle">
   				${ action } 成功
   			</legend>
		<button type="submit" class="pure-button pure-button-primary">回首頁</button>
	</form>
</body>
</html>
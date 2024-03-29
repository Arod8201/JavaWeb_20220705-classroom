<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	
<!DOCTYPE html>
<!--  
${ users }
-->
<html>
<head>
	<link rel="stylesheet" href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
	<meta charset="UTF-8">
	<title>User Index</title>
	<script>
		function deleteUserById(id) {
			if (confirm('是否要刪除 id:' + id + '的資料 ?')) {
				window.location.href = '${ pageContext.request.contextPath }/user/delete?id=' + id;
			}
		}
		
		function checkUserForm() {
			var username = window.document.getElementById('username').value;
			var password = window.document.getElementById('password').value;
			if (username == '') {
				alert('使用者名稱不可空白!')
				window.document.getElementById('username').focus();
				return false;
			}
			if (password == '') {
				alert('使用者密碼不可空白!')
				window.document.getElementById('password').focus();
				return false;
			}
			return true;
		}
	</script>
</head>
<body style="padding: 15px">
	<form class="pure-form" method="post" onsubmit="return checkUserForm()" action="${ pageContext.request.contextPath }/user/add">
		<fieldset>
      			<legend>
      				<img src="${ pageContext.request.contextPath }/images/user.png" width="40" valign="middle">
      				User Form
      			</legend>
      			Username: <input type="text" id="username" name="username" placeholder="請輸入使用者名稱" /><p />
      			Password: <input type="password" id="password" name="password" placeholder="請輸入使用者密碼" /><p />
      			 <button type="reset" class="pure-button pure-button-primary">清除</button>
      			 <button type="submit" class="pure-button pure-button-primary">新增</button>
      		</fieldset>	
	</form>
	<form class="pure-form">
		<fieldset>
      		<legend>
      			<img src="${ pageContext.request.contextPath }/images/users.png" width="40" valign="middle">
      			User List
      		</legend>
      		<table class="pure-table pure-table-bordered">
      			<thead>
      				<tr>
      					<th>id</th>
      					<th>username</th>
      					<th>password</th>
      					<th>createtime</th>
      					<th>update</th>
      					<th>delete</th>
      				</tr>
      			</thead>
      			<tbody>
      				<c:forEach var="user" items="${ users }">
 						<tr>
 							<td>${ user.id }</td>
 							<td>${ user.username}</td>
 							<td>${ user.password }</td>
 							<td>${ user.createtime }</td>
 							<td><a href="${ pageContext.request.contextPath }/user/get?id=${ user.id }">修改</a></td>
 							<td><a href="javascript:deleteUserById(${ user.id })">刪除</a></td>
 						</tr>     					
      				</c:forEach>
      			</tbody>
      		</table>	
      	</fieldset>		
	</form>
</body>
</html>
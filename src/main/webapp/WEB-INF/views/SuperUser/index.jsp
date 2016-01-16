<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スーパーユーザー初期画面</title>
</head>
<body>
	<h1>スーパーユーザーログイン画面</h1>
	<form:errors path="superUserLoginForm.*" cssStyle="color:red" />
	<table>
		<form:form action="/superUser/login" modelAttribute="superUserLoginForm">
			<tr>
				<td>メールアドレス</td>
				<td><form:input path="mailaddress" placeholder="E-mail..." required="required"/></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><form:password path="password" placeholder="Password..." required="required"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="ログイン"></td>
			</tr>
		</form:form>
	</table>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スーパーユーザーメニュー画面</title>
</head>
<body>
	<h1>スーパーユーザーメニュー画面</h1>
	ようこそ、<c:out value="${account.userName}"/>さん
</body>
</html>
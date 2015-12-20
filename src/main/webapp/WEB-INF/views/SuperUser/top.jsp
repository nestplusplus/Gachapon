<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../../css/superUser.css" rel="stylesheet">
<link href="/css/jquery-ui-1.9.2.custom.css" rel="stylesheet">
<script src="/js/jquery-1.8.3.js"></script>
<script src="/js/jquery-ui-1.9.2.custom.js"></script>
<script src="/js/jquery.cookie.js"></script>
<script>
	$(function() {
		$('#openCompany').hover(function(){
			$(this).text('企業一覧');
		},function(){
			$(this).text('Company')
		})
		$('#openUser').hover(function(){
			$(this).text('ユーザー一覧');
		},function(){
			$(this).text('User')
		})
		$('#logout').hover(function(){
			$(this).text('ログアウト');
		},function(){
			$(this).text('Logout')
		})
		
		$('#openCompany').click(function() {
			$('#company').slideDown('slow');
			$('#user').slideUp('slow');
		});
		$('#openUser').click(function() {
			$('#user').slideDown('slow');
			$('#company').slideUp('slow');
		});
		$('#logout').click(function(){
			result = confirm("ログアウトします。ログイン中：[<c:out value="${superUserPage.userName}"/>]さん");
			if(result === true){
				document.location.href = "/superUser/logout";
			}
		})
	});
</script>
<title>管理画面</title>
</head>
<body>
	<header>
		<ul id="menu">
			<li class="menuTitle">Gachapon!
			<li id="openCompany" class="menuItem">Company
			<li id="openUser" class="menuItem">User
			<li id="logout" class="menuItem">Logout</li>
		</ul>
	</header>
	<!-- #################　企業一覧　################# -->
	<div id="company" class="contents">
		<h3 class="title">企業一覧</h3>
		<div class="companyItem">
			<p>画像</p>
			<table>
				<tr>
					<th>name</th>
					<td>お店１</td>
				</tr>
				<tr>
					<th>place</th>
					<td>新宿駅</td>
				</tr>
				<tr>
					<th>intro</th>
					<td>新宿の飲食店</td>
				</tr>
			</table>
		</div>
		<div class="companyItem">
			<p>画像</p>
			<table>
				<tr>
					<th>name</th>
					<td>お店２</td>
				</tr>
				<tr>
					<th>place</th>
					<td>渋谷</td>
				</tr>
				<tr>
					<th>intro</th>
					<td>渋谷の飲食店</td>
				</tr>
			</table>
		</div>
		<div class="companyItem">
			<p>画像</p>
			<table>
				<tr>
					<th>name</th>
					<td>お店３</td>
				</tr>
				<tr>
					<th>place</th>
					<td>池袋</td>
				</tr>
				<tr>
					<th>intro</th>
					<td>池袋の飲食店</td>
				</tr>
			</table>
		</div>
		<div class="companyItem">
			<p>画像</p>
			<table>
				<tr>
					<th>name</th>
					<td>お店４</td>
				</tr>
				<tr>
					<th>place</th>
					<td>上野</td>
				</tr>
				<tr>
					<th>intro</th>
					<td>上野の飲食店</td>
				</tr>
			</table>
		</div>
		<div class="companyItem">
			<p>画像</p>
			<table>
				<tr>
					<th>name</th>
					<td>お店５</td>
				</tr>
				<tr>
					<th>place</th>
					<td>秋葉原</td>
				</tr>
				<tr>
					<th>intro</th>
					<td>秋葉原の飲食店</td>
				</tr>
			</table>
		</div>
	</div>
	<!-- #################　ユーザー一覧　################# -->
	<div id="user" class="contents">
		<h3 class="title">ユーザー一覧</h3>
		<table>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>place</th>
				<th>authority</th>
				<th>operation</th>
			</tr>
			<tr>
				<td>1</td>
				<td>Aさん</td>
				<td>六本木</td>
				<td>-</td>
				<td>削除</td>
			</tr>
			<tr>
				<td>2</td>
				<td>Bさん</td>
				<td>代々木</td>
				<td>-</td>
				<td>削除</td>
			</tr>
			<tr>
				<td>3</td>
				<td>Cさん</td>
				<td>日暮里</td>
				<td>○</td>
				<td>削除</td>
			</tr>
		</table>
	</div>
	<footer>
		<p>&copy;nest++</p>
	</footer>
</body>
</html>
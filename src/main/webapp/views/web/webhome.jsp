<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách đất</title>
</head>
<body>
	<div class="container">
		<div>
			<row>
				<a href="/homework/login?action=login">
				<button type="button" class="btn btn-primary" >Đăng nhập</button>
				</a>
			</row>
		</div>
		<c:forEach var="item" items="${lands}"> 	
				<row>Địa chỉ : ${item.address}</row>
				<br>
				<row>Hướng: ${item.direction}</row>
				<br>
				<row><img src="files/${item.image}"  width="150" height="150"></row>
				<br>
				<row>Chiều dài: ${item.length}</row>
				<br>
				<row>Chiều rộng: ${item.width}</row>
				<br>
				<a href="/homework/web-appointment">
				<button type="button" class="btn btn-primary" >Đặt lịch xem</button>
				</a>
				<br>									
		</c:forEach>			
	</div>
</body>
</html>
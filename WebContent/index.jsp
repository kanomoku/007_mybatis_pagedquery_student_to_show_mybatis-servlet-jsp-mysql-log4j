<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a {
	color: green;
	text-decoration: none;
	font-size: 20px;
	font-weight: bold
}
a:hover {
	color: red;
}
</style>
</head>
<body>
	<table border="1">
		<td>编号</td>
		<td>姓名</td>
		<td>年龄</td>
		<th>编号</th>
		<th>姓名</th>
		<th>年龄</th>
		<c:forEach items="${pageInfo.list}" var="pi">
			<tr>
				<td>${pi.id}</td>
				<td>${pi.name}</td>
				<td>${pi.age}</td>
			</tr>
		</c:forEach>
	</table>
	<a
		href="page?pageNum=${pageInfo.pageNum-1}&pageSize=${pageInfo.pageSize}"
		<c:if test="${pageInfo.pageNum<=1}" > onclick="javascript:return false;" </c:if>
		>上一页</a>
	<a
		href="page?pageNum=${pageInfo.pageNum+1}&pageSize=${pageInfo.pageSize}"
		<c:if test="${pageInfo.pageNum>= pageInfo.total}"> onclick="javascript:return false;"</c:if>
		>下一页</a>
</body>
</html>
<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member loginMember = null;
	if(request.getAttribute("loginMember") != null)
	loginMember = (Member)request.getAttribute("loginMember"); 
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인에 성공한 사용자 정보</h1>
	<p>이름 : <%=loginMember.getName() %><br/>주소 : <%=loginMember.getAddr() %></p>
</body>
</html>
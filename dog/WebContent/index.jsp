<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인덱스</title>
</head>
<body>
	<%
		String id = (String)session.getAttribute("id");
		
	//attribute는 오브젝트, parameter는 String.
		if(id == null){
	%>
		<a href="loginForm.html">로그인</a>
		
	<%	
	}else{    
			Member member = (Member)session.getAttribute("member");
	%>
		<a href = "logout">로그아웃</a>
		<table>
			<tr>
				<td>아이디</td>
				<td><%=member.getId()%></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><%=member.getName()%></td>
			</tr>
			<tr>
				<td>국적</td>
				<td><%=member.getNation()%></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><%=member.getAddr()%></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><%=member.getAge()%></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><%=member.getGender()%></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><%=member.getEmail()%></td>
			</tr>
	
		</table>
	<% 	
	}
	%>
</body>
</html>
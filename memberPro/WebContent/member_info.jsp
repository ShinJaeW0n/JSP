<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리시스템 관리자모드(회원정보보기)</title>
<style>
	#memberInfoArea{
		width: 400px;
		margin: auto;
		border: 1px solid gray;
	}
	
	table{
		width: 380px;
		margin: auto;
		text-align: center;
	}
</style>
</head>
<body>
<section id="memberInfoArea">
	<table>
		<tr>
			<td>아이디: </td>
			<td>${member.member_id }</td>
		</tr>
		<tr>
			<td>비밀번호: </td>
			<td>${member.member_pw }</td>
		</tr>		
		<tr>
			<td>이름: </td>
			<td>${member.member_name }</td>
		</tr>		
		<tr>
			<td>나이: </td>
			<td>${member.member_age }</td>
		</tr>		
		<tr>
			<td>성별: </td>
			<td>${member.member_gender }</td>
		</tr>
		<tr>
			<td>이메일주소: </td>
			<td>${member.member_email }</td>
		</tr>
		<tr>
			<td colspan=2>
			<a href="memberListAction.do">리스트로 돌아가기</a>
			</td>
		</tr>
				
	</table>
</section>
</body>
</html>
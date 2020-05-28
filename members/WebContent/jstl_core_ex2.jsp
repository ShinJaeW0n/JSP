<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl core 라이브러리 사용예제 -2</title>
</head>
<body>
<c:forEach var = "test" begin = "1" end = "10" step = "2">
	<b>${test}</b>&nbsp;
</c:forEach>
<br> <!-- ,로 구분짓고  -->
<c:forTokens var = "alphabet" items = "a,b,c,d,e,f,g,h,i,j,k,l,m,n" delims = ",">
	<b>${alphabet}</b>&nbsp;
</c:forTokens>
<br> <!-- set은 변수 설정 -->
<c:set var = "data" value = "홍길동,김길동,고길동"	/>
<c:forTokens var = "varData" items = "${data}" delims = ",">
	<b>${varData}</b>
</c:forTokens>	
</body>
</html>
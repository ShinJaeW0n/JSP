<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!doctype html>
<html lang="ko">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<!-- 단독태그는 /로 닫아줘야함!! -->
<meta name="viewport"content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />

<title>메인페이지</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm navbar-light bg-light">
		<a class="navbar-brand" href="main.jsp">JSP 게시판</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
			<!--collapse - 접히는 것.  -->
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="main.jsp">메인<span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="bbs.jsp">게시판</a></li>
				</ul>
				
				<ul class = "navbar-nav ml-auto">
					<li class = "nav-item dropdown">
					<a class = "nav-link dropdown-toggle" href = "#" id = "navbarDropdown" 
					role = "button" data-toggle = "dropdown" aria-haspopup="true" aria-expanded="false">접속하기</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<%if(session.getAttribute("userID") == null){ %>
						<a class="dropdown-item" href="login.jsp">로그인</a> 
						<% } else{ %>
						<a class="dropdown-item" href="logoutAction.jsp">로그아웃</a>
						<% } %>
						<div class="dropdown-divider"></div> <!-- 한줄 긋기 -->
						<a class="dropdown-item" href="join.jsp">회원가입</a>
					</div></li>
				</ul>
			</div>
	</nav>
	
	<!-- 점보트론 -->
	<div class = "container pt-3 "> <!-- 컨테이너:좌우에 여백 주는 것. 패딩탑 -->
		메인페이지 입니다.
	</div>
	
	

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
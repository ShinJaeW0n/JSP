<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.sql.* , javax.sql.*, javax.naming.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> <!-- h3 태그가 들어가기 때문에 body에 써주는게 맞다.-->
<%
	//이건 외워야함.
	Connection conn = null;
	
	try{
	Context init = new InitialContext();
	DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/members");
	conn = ds.getConnection();
	out.print("<h3>연결</h3>");
	
	}catch(Exception e){
		out.println("<h3>연결실패</h3>");
		e.printStackTrace();
	}finally {
		if(conn != null)conn.close();
		}
%>				

</body>
</html>
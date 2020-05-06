package com.test.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*key �̸��� �� ���*/

@WebServlet("/dog2.do")
public class DogSuvlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}
	
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
//		String hide = request.getParameter("hide"); //�� �±׿��� �Ѿ���� �����ʹ� �Ķ���ͷ� �Ѿ�´�. �̶� name �Ӽ��� key���� �ȴ�.
//		out.println(hide); //���
//		//�Ȱ��� dog �������� �Ѿ���� ������ �迭�� ���� �� �ְ� �ȴ�. �迭�� �Ѿ�ö��� �� �Ķ���� �������� �����´�.
//		//���� Ű�� ���� �����Ͱ� �Ѿ���� �迭�� ���޵ȴ�.
//		String[] dogs = request.getParameterValues("dog");
//		out.println("<html>");
//		
//		
//		out.println("<head>");
//		out.println("<meta charset='UTF-8' />");
//		out.println("<title>������ ����</title>");
//		out.println("</head>");
//		out.println("<body>");
//		for(String url : dogs) {
//			out.println("<img src = '"+ url +"' alt='-' style='width:200px;'>"); 
//		}
//		out.println("</body>");
//		out.println("</html>");
		
		/*key �̸��� �� ���*/
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {//���� �������� �ִٸ� �����ض�. 
			String name = enu.nextElement();
			String[] arr = request.getParameterValues(name);
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8' />");
			out.println("<title>������ ����</title>");
			out.println("</head>");
			out.println("<body>");
			for(String value : arr) {
				if(name.equals("dog")) {
					out.println("<img src = '"+ value +"' alt='-' style='width:200px;'>"); 
				}else {
				out.println("<h3>Ű : " + name + " �� : " + value + "</h3></br>");
				}
			}
			out.println("</body>");
			out.println("</html>");
			
		}
		
	}

}

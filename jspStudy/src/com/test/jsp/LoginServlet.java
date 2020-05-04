package com.test.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}
	
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*�� 2���� ������ �ִ´�.*/
		request.setCharacterEncoding("UTF-8"); //Post�� ��� �ѱ� ó�� �ڵ�
		response.setContentType("text/html;charset=UTF-8"); //������ Ÿ���� html�̰� utf-8 ������� ����ó��
		
		String id = request.getParameter("id"); //�Ķ���ͷ� ���۵� id�� ����
		String passwd = request.getParameter("passwd"); //�Ķ���ͷ� ���۵� passwd�� ����
		PrintWriter out = response.getWriter(); //��� ��Ʈ��
		out.println("���̵�=" + id + "<br />");
		out.println("��й�ȣ=" + passwd + "<br />");
		out.close(); //��Ʈ���� ��� �� �ݵ�� �ݾƾ��Ѵ�.
	}

}

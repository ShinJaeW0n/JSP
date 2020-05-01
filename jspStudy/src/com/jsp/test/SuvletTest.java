package com.jsp.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SuveltStudy
 */		

			/*���ϴ� �̸����� ���氡��*/
@WebServlet("/suvletTest") /*������ ����*/
public class SuvletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	
	/*���࿡ ������ ����� ����� throw�Ѵ�.*/
																					 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
																					
		doProc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doProc(request, response);
	}
	
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Car mycar = new Car("�����ڵ���","���׽ý�");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		Calendar c = Calendar.getInstance(); /*���� �ð� ��������*/
		int hour = c.get(Calendar.HOUR_OF_DAY); /*Į������ �ð��� ��������*/
		int min = c.get(Calendar.MINUTE);
		int sec = c.get(Calendar.SECOND);
		PrintWriter pw = response.getWriter(); /*�ؽ�Ʈ ������ ���⸦ �� �� �ִ� ��ü.*/
		pw.write("<html><head><title>ServletTest</titel></head>");
		pw.write("<body><h1>");
		pw.write("���� �ð���");
		pw.write("Integer.toString(hour)");
		pw.write("�� ");
		pw.write("Integer.toString(min)");
		pw.write("�� ");
		pw.write("Integer.toString(sec)");
		pw.write("�� �Դϴ�.");
		pw.write("</h1>");
		pw.write("<h2>");
		pw.write("����� �ڵ�����" + mycar.getCompany() + "��ǰ�̰�, �𵨸���" + mycar.getModel() + "�Դϴ�.");
		pw.write("</h2>");
		
		pw.write("</body></html>");
		pw.close();
		
	}
	

}

package com.test.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/lifeCycle") // <-������̼�. mapping
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LifeCycle() {
        System.out.println("������ ȣ��");

    }
    

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("���� �޼��� ȣ��");
	}
	
	@Override
	public void destroy() {
		System.out.println("��Ʈ���� ȣ��");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("�ʱ�ȭ ȣ��");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}	

	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost �Ǵ� doGet ȣ��");
	}
	
}

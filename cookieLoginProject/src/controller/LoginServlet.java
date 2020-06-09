package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.LoginService;
import vo.Member;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookieArray = request.getCookies();
		String id = "";
		String passwd = "";

		if (cookieArray != null) {
			for (int i = 0; i < cookieArray.length; i++) {
				if (cookieArray[i].getName().equals("id")) {
					id = cookieArray[i].getValue();
				}
				else if (cookieArray[i].getName().equals("passwd")) {
					passwd = cookieArray[i].getValue();
				}
			}
			
			LoginService loginService = new LoginService();
			Member loginMember = loginService.getLoginMember(id,passwd);
			
			if(loginMember != null) {
				RequestDispatcher rd = request.getRequestDispatcher("loginSuccess.jsp");
				request.setAttribute("loginMember", loginMember);
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("loginForm.html");
				rd.forward(request, response);
			}
		
		}
	}
		
		

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			String useCookie = request.getParameter("useCookie");
			LoginService loginService = new LoginService();
			Member loginMember = loginService.getLoginMember(id, passwd);
			
			if(useCookie != null) {
				Cookie idCookie = new Cookie("id",id);
				idCookie.setMaxAge(60*60*24); //60�� 60�� 24�ð� �Ϸ� ���� ��Ű�� ����ִٴ� ���.
				Cookie passwdCookie = new Cookie("passwd", passwd);
				passwdCookie.setMaxAge(60*60*24); //60�� 60�� 24�ð� �Ϸ� ���� ��Ű�� ����ִٴ� ���.
				response.addCookie(idCookie);
				response.addCookie(passwdCookie);
			
			}
			
			if(loginMember != null) {
				RequestDispatcher rd = request.getRequestDispatcher("loginSuccess.jsp");
				request.setAttribute("loginMember", loginMember);
				rd.forward(request, response);
			}else {
				Cookie[] cookieArray = request.getCookies();
				
				if (cookieArray != null) {
					for (int i = 0; i < cookieArray.length; i++) {
						if (cookieArray[i].getName().equals("id")) {
							cookieArray[i].setMaxAge(0); //�ð� ������ 0���� �ϰ� �Ǹ� ��Ű ����. ��Ű�� invalidate�� ����.
						}
						else if (cookieArray[i].getName().equals("passwd")) {

						}
					}
				}
				
				RequestDispatcher rd = request.getRequestDispatcher("loginFail.jsp");
				rd.forward(request, response);
			}
		}
		
	

}

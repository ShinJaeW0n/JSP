package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.LoginService;
import vo.Member;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}
	
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		LoginService loginService = new LoginService();
		Member loginMember = loginService.getLoginMember(id, passwd);
		//�α����� �����Ǹ� Member ��ü�� �Ѿ���� �����ϸ� null�� �Ѿ��.
		
		
		if(loginMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("member", loginMember);
			response.sendRedirect("index.jsp");
		//�Է��� �α���, ��й�ȣ�� Ʋ���� ��
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('�α��ν���')");
			out.println("history.back();");
			out.println("</script>");
		}
		
	}

}
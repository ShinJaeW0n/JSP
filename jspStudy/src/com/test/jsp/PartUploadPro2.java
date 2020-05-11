package com.test.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;




@WebServlet("/partUploadPro2")
@MultipartConfig(
		fileSizeThreshold = 0,
		location = "C:\\apache-tomcat-9.0.34\\wtpwebapps\\jspStudy\\upload"
		)
public class PartUploadPro2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProc(request, response);
	}
	
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String writer = request.getParameter("writer");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String uploadFileNamelist = "";
		
		for(Part part:request.getParts()) {
			
			String contentDisposition = part.getHeader("content-disposition");
			String uploadFileName = getUploadFileName(contentDisposition);
			part.write(uploadFileName);
			uploadFileNamelist += " " + uploadFileName;
		}
		out.println("�ۼ���" + writer + "����" + uploadFileNamelist + "������ ���ε� �Ͽ����ϴ�.");
		
	}

//	//��� �������� IE�� ���
//	private String getUploadFileName(String contentDisposition) {
//		String uploadFileName = null;
//		String[] contentSplitStr = contentDisposition.split(";");
//		int lastPathSeparatorIndex = contentSplitStr[2].lastIndexOf("\\");
//		int lastQutosIndex = contentSplitStr[2].substring(lastPathSeparatorIndex + 1, lastQutosIndex);
//		return uploadFileName;
//	}
	
	
	
	//��� �������� ũ���� ���
		private String getUploadFileName(String contentDisposition) {
			String uploadFileName = null;
			String[] contentSplitStr = contentDisposition.split(";");
			int firstQutosIndex = contentSplitStr[2].indexOf("\""); /*�� ����ǥ 1���� ����.*/
			int lastQutosIndex = contentSplitStr[2].lastIndexOf("\"");
			uploadFileName = contentSplitStr[2].substring(firstQutosIndex + 1, lastQutosIndex);
			return uploadFileName;
		}


}

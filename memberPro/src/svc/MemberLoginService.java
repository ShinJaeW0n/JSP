package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;

//�α��� ��û�� ó��
public class MemberLoginService {

	public boolean login(MemberBean member) {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		boolean loginResult = false;
		String loginId = memberDAO.selectLoginId(member);
		
		if(loginId != null) {
			loginResult = true;
		}
		close(con);
		return loginResult;
	}

}

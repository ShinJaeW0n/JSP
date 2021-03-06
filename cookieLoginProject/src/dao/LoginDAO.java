package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Member;

public class LoginDAO {
	
	//언제나 쓸 수 있도록 static 으로 올린다.
	private static LoginDAO loginDAO;
	private Connection con;

	public static LoginDAO getInstance() {
		if(loginDAO == null) {
			loginDAO = new LoginDAO();
		}
			return loginDAO;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
		
	}


	public Member selectLoginMember(String id, String passwd) {
		Member loginMember = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM users WHERE id = ? AND passwd = ?");
			//입력한 아이디 비밀번호가 맞다면!
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			if(rs.next()) { //여기에 아이디, 비밀번호를 넣어준다.
				loginMember = new Member();
				loginMember.setId(rs.getString("id"));
				loginMember.setPasswd(rs.getString("passwd"));
				loginMember.setAddr(rs.getString("addr"));
				loginMember.setAge(rs.getInt("age"));
				loginMember.setEmail(rs.getString("email"));
				loginMember.setGender(rs.getString("gender"));
				loginMember.setName(rs.getString("name"));
				loginMember.setNation(rs.getString("nation"));
				
			}

//CREATE TABLE users(
//    id VARCHAR2(12)PRIMARY KEY,
//    passwd VARCHAR2(12),
//    addr VARCHAR2(50),
//    age NUMBER,
//    email VARCHAR2(30),
//    genger CHAR(1),
//    name VARCHAR2(12),
//    nation VARCHAR2(16)
//);		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { //con은 1개의 객체를 가지고 계속 사용하기 때문에 여기서 닫아주지 않는다. 닫으면 못 씀.
				if(rs != null) close(rs);
				if(pstmt != null) close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return loginMember;
	}

	
	
	
}

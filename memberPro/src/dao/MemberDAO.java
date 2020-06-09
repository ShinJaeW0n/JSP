package dao;

import static db.JdbcUtil.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.MemberBean;

public class MemberDAO {
	private static MemberDAO memberDAO;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	private MemberDAO() {
		
	}
	
	//memberDAO를 리턴하는 getInstance
	public static MemberDAO getInstance() {
		if(memberDAO == null) {
			memberDAO = new MemberDAO();
		}
		return memberDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}
	
	

	public int insertMember(MemberBean member) {
		String sql = "INSERT INTO MEMBERS VALUES (?,?,?,?,?,?)";
		int insertCount = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMember_id());
			pstmt.setString(2, member.getMember_pw());
			pstmt.setString(3, member.getMember_name());
			pstmt.setInt(4, member.getMember_age());
			pstmt.setString(5, member.getMember_gender());
			pstmt.setString(6, member.getMember_email());
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		} 
		
		return insertCount;
	}

	public String selectLoginId(MemberBean member) {
		String loginId = null;
		String sql = "SELECT MEMBER_ID FROM MEMBERS WHERE MEMBER_ID=? AND MEMBER_PW=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getMember_id());
			pstmt.setString(2, member.getMember_pw());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginId = rs.getString("member_id");
			}
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
			return loginId;
	}

	public ArrayList<MemberBean> selectMemberList() {
		String sql = "SELECT * FROM members";
		ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();
		MemberBean bean = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					bean = new MemberBean();
					bean.setMember_id(rs.getString("member_id"));
					bean.setMember_pw(rs.getString("member_pw"));
					bean.setMember_name(rs.getString("member_name"));
					bean.setMember_age(rs.getInt("member_age"));
					bean.setMember_gender(rs.getString("member_gender"));
					bean.setMember_email(rs.getString("member_email"));
					memberList.add(bean);
				}while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return memberList;
	}

	public MemberBean selectMember(String viewId) {
		String sql = "SELECT * FROM members WHERE member_id=?";
		MemberBean bean = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, viewId);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				bean=new MemberBean();
				bean.setMember_id(rs.getString("member_id"));
				bean.setMember_pw(rs.getString("member_pw"));
				bean.setMember_name(rs.getString("member_name"));
				bean.setMember_age(rs.getInt("member_age"));
				bean.setMember_gender(rs.getString("member_gender"));
				bean.setMember_email(rs.getString("member_email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return bean;
	}

	public int deleteMember(String deleteId) {
		String sql = "DELETE members WHERE MEMBER_ID=?";
		int deleteCount = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, deleteId);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return deleteCount;
	}
}

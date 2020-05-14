package com.test.model1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.test.model1.vo.User;

//sql�� ����Ʈ ���ֱ�.
public class UserDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public UserDAO() {
		try {
			Context init =  new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/bbs");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void udClose() {
		try {
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public int login (String userId, String userPassword) {
		String sql = "select userPassword from user where userId = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId); //�Է¹��� ���� ���̵�
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					return 1;
				}else {
					return 0; //��й�ȣ�� Ʋ���ٴ� ��.
				}
			}
			return -1; //-1�� ��ٸ� ���̵� �����̶�� ������ ������.
		}catch(Exception e) {
			
		}
		return -2; //������ ���̽� ���� �ڵ�
	}

	public int join(User user) {
		String sql = "insert into user values (?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserID()); //�Է¹��� ���� ���̵�
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
			pstmt.executeUpdate();
			return 0;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}

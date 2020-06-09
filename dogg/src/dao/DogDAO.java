package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.Dog;

public class DogDAO {
	DataSource ds;
	Connection con;
	
	private static DogDAO dogDAO;

	private DogDAO() {
		
	}
	
	public void setConnection(Connection con) {
		this.con = con;
		
	}
	
	public static DogDAO getInstance() {
		if(dogDAO == null) {
			dogDAO = new DogDAO();
		}
		return dogDAO;
	}

	public ArrayList<Dog> selectDogList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Dog> dogList = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM dog");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dogList = new ArrayList<Dog>();
				
				do {
					Dog dog = new Dog(
							rs.getInt("id"), 
							rs.getString("kind"), 
							rs.getInt("price"), 
							rs.getString("image"), 
							rs.getString("country"), 
							rs.getInt("height"), 
							rs.getInt("weight"), 
							rs.getString("content"), 
							rs.getInt("readcount"));
					
					dogList.add(dog);
				}while(rs.next());
			}
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return dogList;
	}
	
	public Dog selectDog(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dog dog = null;
		
		try {
			pstmt = con.prepareStatement("SELECT*FROM dog WHERE id =?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dog = new Dog(
						rs.getInt("id"), 
						rs.getString("kind"), 
						rs.getInt("price"), 
						rs.getString("image"), 
						rs.getString("country"), 
						rs.getInt("height"), 
						rs.getInt("weight"), 
						rs.getString("content"), 
						rs.getInt("readcount"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(con);
		}
		return dog;
	}
	
	public int updateReadCount(int id) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "";
		
		try {
			sql = "UPDATE dog SET readcount = readcount + 1 WHERE id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			updateCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			}
		return updateCount;
	}
	
	public int insertDog(Dog dog) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		
		try {					//seq는 nextValue를 하면 다음 순서로 넘어가는 거다. 오토 인크루먼트랑 똑같음.
			pstmt = con.prepareStatement("INSERT INTO dog VALUES(dog_seq.nextval, ?,?,?,?,?,?,?,?)");
			pstmt.setString(1, dog.getKind());
			pstmt.setInt(2, dog.getPrice());
			pstmt.setString(3, dog.getImage());
			pstmt.setString(4, dog.getCountry());
			pstmt.setInt(5, dog.getHeight());
			pstmt.setInt(6, dog.getWeight());
			pstmt.setString(7, dog.getContent());
			pstmt.setInt(8, dog.getReadcount());
			insertCount = pstmt.executeUpdate();		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return insertCount;
	}
	
	
	
	
	


}

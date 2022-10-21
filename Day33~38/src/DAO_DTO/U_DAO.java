package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class U_DAO {
	private Connection conn = null;

	public U_DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean connect() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@humanDB_high?TNS_ADMIN = C:/Users/human/Desktop/Wallet_humanDB", "admin",
					"Jb21499549954.");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public void insertUser(U_DTO udto) {
		if (connect()) {
			String sql = "insert into user1 values(?,?,?,?,?)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, udto.getUid());
				psmt.setString(2, udto.getUname());
				psmt.setString(3, udto.getUpart());
				psmt.setString(4, udto.getUpwd());
				psmt.setString(5, udto.getUgrade());
				psmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("catch??");
			}
		} else {
			System.out.println("연결실패");
		}
	}

	public void deleteUser(String uid) {
		if (connect()) {
			String sql = "delete from user1 where u_id="+"'"+uid+"'";
			try {
				Statement stmt = conn.createStatement();
				stmt.executeQuery(sql);
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
	}

	public void modyUser(U_DTO udto) {
		if (connect()) {
			String sql = "update user1 set u_name=?, u_part=?, u_pwd=?, u_grade = ? where u_id=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, udto.getUname());
				psmt.setString(2, udto.getUpart());
				psmt.setString(3, udto.getUpwd());
				psmt.setString(4, udto.getUgrade());
				psmt.setString(5, udto.getUid());
				psmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
	}

	public ArrayList<U_DTO> allSelect() {
		ResultSet rs;
		if (connect()) {
			String sql = "select * from user1";
			ArrayList<U_DTO> uList = new ArrayList<>();
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					U_DTO tempU = new U_DTO();
					tempU.setUid(rs.getString("u_id"));
					tempU.setUname(rs.getString("u_name"));
					tempU.setUpart(rs.getString("u_part"));
					tempU.setUpwd(rs.getString("u_pwd"));
					tempU.setUgrade(rs.getString("u_grade"));
					uList.add(tempU);
				}
				conn.close();
				return uList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
		return null;
	}

	public U_DTO SelectOne(String uid) {
		ResultSet rs;
		U_DTO tempU = null;
		if (connect()) {
			String sql = "select * from user1 where u_id = ?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, uid);
				rs = psmt.executeQuery();
				if (rs.next()) {
					tempU = new U_DTO();
					tempU.setUid(rs.getString("u_id"));
					tempU.setUname(rs.getString("u_name"));
					tempU.setUpart(rs.getString("u_part"));
					tempU.setUpwd(rs.getString("u_pwd"));
					tempU.setUgrade(rs.getString("u_grade"));
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
		return tempU;
	}

	public boolean chkUser(String uid) {
		ResultSet rs;
		if (connect()) {
			String sql = "select * from user1 where u_id =" + "'" + uid + "'";
			try {

				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);

				while (rs.next()) {//아이디가 있으면 false
				}
				conn.close();
				return false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
		return true;
	}
	
	public U_DTO chkLogin(U_DTO udto) {
		ResultSet rs;
		U_DTO tempU = null;
		if (connect()) {
			String sql = "select * from user1 where u_id =? and u_pwd = ?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, udto.getUid());
				psmt.setString(2, udto.getUpwd());
				rs = psmt.executeQuery();
				if (rs.next()) {
					tempU = new U_DTO();
					tempU.setUid(rs.getString("u_id"));
					tempU.setUname(rs.getString("u_name"));
					tempU.setUpart(rs.getString("u_part"));
					tempU.setUpwd(rs.getString("u_pwd"));
					tempU.setUgrade(rs.getString("u_grade"));
				}
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
		return tempU;
	}
	
	public ArrayList<U_DTO> search(String word) {
		ResultSet rs;
		if (connect()) {
			String sql = "select * from user1 where u_id like "+"'%"+word+"%'"+"or u_name like '%"+word+"%'";
			ArrayList<U_DTO> uList = new ArrayList<>();
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					U_DTO tempU = new U_DTO();
					tempU.setUid(rs.getString("u_id"));
					tempU.setUname(rs.getString("u_name"));
					tempU.setUpart(rs.getString("u_part"));
					tempU.setUpwd(rs.getString("u_pwd"));
					tempU.setUgrade(rs.getString("u_grade"));
					uList.add(tempU);
				}
				conn.close();
				return uList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
		
		return null;
	}

}

package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Pat_DAO {
	private Connection conn = null;

	public Pat_DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("연결실패");
		}
	}

//C:\Users\human\Desktop\Wallet_humanDB.zip
	public boolean connect() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@humanDB_high?TNS_ADMIN = C:/Users/human/Desktop/Wallet_humanDB", "admin",
					"Jb21499549954.");
//			System.out.println("연결성공");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void insertWord(Pat_DTO pdto) {
		if (connect()) {
			String sql = "insert into patient values(?,?,?,?)";
			String sql2 = "insert into record values(?,?,?,?,default,?,?)";
			try {
				if (pdto.getAge() != 0) {
					PreparedStatement psmt = conn.prepareStatement(sql);
					psmt.setString(1, pdto.getNo());
					psmt.setString(2, pdto.getName());
					psmt.setInt(3, pdto.getAge());
					psmt.setString(4, pdto.getSex());
					psmt.executeUpdate();
				}

				PreparedStatement psmt2 = conn.prepareStatement(sql2);
				psmt2.setString(1, pdto.getNo());
				psmt2.setString(2, pdto.getDepart());
				psmt2.setString(3, pdto.getDisease());
				psmt2.setString(4, pdto.getIndate());
				psmt2.setString(5, pdto.getMemo());
				psmt2.setString(6, pdto.getRoom());
				psmt2.executeUpdate();

//				System.out.println("연결성공");
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("catch??");
			}
		} else {
			System.out.println("연결실패");
		}
	}

	public void deletePat(Object no) {
		String no1 = (String) no;
		if (connect()) {
			String sql = "delete from patient where no=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, no1);
				psmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
	}

//
	public void modyWord(Pat_DTO pdto, Pat_DTO mod) {
		if (connect()) {
			String sql = "update patient set no=?,name=?,age=?,sex=? where no=?";
			String sql2 = "update record set depart=?,disease=?,indate= ?,memo=?,room=? where no=? and outdate is null";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, pdto.getNo());
				psmt.setString(2, pdto.getName());
				psmt.setInt(3, pdto.getAge());
				psmt.setString(4, pdto.getSex());
				psmt.setString(5, mod.getNo());
				psmt.executeUpdate();

				PreparedStatement psmt2 = conn.prepareStatement(sql2);
				psmt2.setString(1, pdto.getDepart());
				psmt2.setString(2, pdto.getDisease());
				psmt2.setString(3, pdto.getIndate());
				psmt2.setString(4, pdto.getMemo());
				psmt2.setString(5, pdto.getRoom());
				psmt2.setString(6, mod.getNo());
				psmt2.executeUpdate();

//				System.out.println("연결성공");
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("catch??");
			}
		} else {
			System.out.println("연결실패");
		}
	}

	public void outPat(Object no) {
		String no1 = (String) no;
		if (connect()) {
			String sql = "update record set outdate= sysdate where outdate is null and no=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, no1);
				psmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
	}

	// no, name, sex, age, depart, disease, memo, indate, outdate
	public ArrayList<Pat_DTO> allSelect(ArrayList<String> selList) {

		ResultSet rs;
		if (connect()) {
			String sql = "select * from view_pat where 1=1";
			if (selList.get(0) != null) {
				sql += " and depart= " + "'" + selList.get(0) + "'";
			}
			if (selList.get(1) != null) {
				if (selList.get(1).equals("재원")) {
					sql += " and outdate is null";
				}
				if (selList.get(1).equals("퇴원")) {
					sql += " and outdate is not null";
				}
			}
			if (selList.get(4).equals("입원일")) {
				if (!selList.get(2).equals("")) {
					sql += " and indate >= " + "'" + selList.get(2) + "'";
				}
				if (!selList.get(3).equals("")) {
					sql += " and indate <= " + "'" + selList.get(3) + "'";
				}
			}
			if (selList.get(4).equals("퇴원일")) {
				if (!selList.get(2).equals("")) {
					sql += " and outdate >= " + "'" + selList.get(2) + "'";
				}
				if (!selList.get(3).equals("")) {
					sql += " and outdate-1 <= " + "'" + selList.get(3) + "'";
				}
			}
			System.out.println(sql);
			ArrayList<Pat_DTO> pList = new ArrayList<>();
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Pat_DTO tempP = new Pat_DTO();
					tempP.setNo(rs.getString("no"));
					tempP.setRoom(rs.getString("room"));
					tempP.setName(rs.getString("name"));
					tempP.setSex(rs.getString("sex"));
					tempP.setAge(rs.getInt("age"));
					tempP.setDepart(rs.getString("depart"));
					tempP.setDisease(rs.getString("disease"));
					tempP.setMemo(rs.getString("memo"));
					tempP.setIndate(rs.getString("indate"));
					tempP.setOutdate(rs.getString("outdate"));
					pList.add(tempP);
				}
				conn.close();
				return pList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
		return null;
	}

	public ArrayList<Pat_DTO> optionSel(String col, String option) {
		ResultSet rs;
		if (connect()) {
			String sql = "select * from view_pat where " + col + "=?";
			ArrayList<Pat_DTO> pList = new ArrayList<>();
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, option);
				rs = psmt.executeQuery();
				while (rs.next()) {
					Pat_DTO tempP = new Pat_DTO();
					tempP.setNo(rs.getString("no"));
					tempP.setRoom(rs.getString("room"));
					tempP.setName(rs.getString("name"));
					tempP.setSex(rs.getString("sex"));
					tempP.setAge(rs.getInt("age"));
					tempP.setDepart(rs.getString("depart"));
					tempP.setDisease(rs.getString("disease"));
					tempP.setMemo(rs.getString("memo"));
					tempP.setIndate(rs.getString("indate"));
					tempP.setOutdate(rs.getString("outdate"));
					pList.add(tempP);
				}
				conn.close();
				return pList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
		return null;
	}

//
	public Pat_DTO SelectOne(Object no) {
		String no1 = (String) no;
		ResultSet rs;
		Pat_DTO tempP = null;
		if (connect()) {
			String sql = "select * from view_pat where no = ?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, no1);
				rs = psmt.executeQuery();
				if (rs.next()) {
					tempP = new Pat_DTO();
					tempP.setNo(rs.getString("no"));
					tempP.setRoom(rs.getString("room"));
					tempP.setName(rs.getString("name"));
					tempP.setSex(rs.getString("sex"));
					tempP.setAge(rs.getInt("age"));
					tempP.setDepart(rs.getString("depart"));
					tempP.setDisease(rs.getString("disease"));
					tempP.setMemo(rs.getString("memo"));
					tempP.setIndate(rs.getString("indate"));
					tempP.setOutdate(rs.getString("outdate"));
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
		return tempP;
	}

//
	public boolean chkNo(String no) {
		ResultSet rs;
		if (connect()) {
			String sql = "select * from patient where no = ? ";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, no);
				rs = psmt.executeQuery();

				while (rs.next()) {// 중복이 있으면 faulse
					return false;
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
		return true;
	}

	public boolean chkOut(String no) {
		ResultSet rs;
		if (connect()) {
			String sql = "select * from record where no = ? and outdate is null";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, no);
				rs = psmt.executeQuery();

				while (rs.next()) {// 데이터가 있으면 faulse
					return false;
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
		return true;
	}
}
package dao_dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import memberMGR.Member;

public class M_DAO {
	private Connection conn = null;

	public M_DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean connect() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void insertMem(M_DTO mdto) {
		if (connect()) {
			String sql = "insert into member2 values(?,?,?,?,default)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, mdto.getId());
				psmt.setString(2, mdto.getName());
				psmt.setString(3, mdto.getPass());
				psmt.setString(4, mdto.getAddr());
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

	public void deleteWord(M_DTO mdto) {
		if (connect()) {
			String sql = "delete from member2 where id=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, mdto.getId());
				psmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
	}

	public void modyMem(M_DTO mdto) {
		if (connect()) {
			String sql = "update member2 set name =?, pass=?, addr=? where id=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, mdto.getName());
				psmt.setString(2, mdto.getPass());
				psmt.setString(3, mdto.getAddr());
				psmt.setString(4, mdto.getId());
				psmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
	}

	public ArrayList<Member> allSelect() {
		ResultSet rs;
		if (connect()) {
			String sql = "select * from member2";
			ArrayList<Member> mList = new ArrayList<>();
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Member tempM = new Member();
					tempM.setId(rs.getString("id"));
					tempM.setName(rs.getString("name"));
					tempM.setPass(rs.getString("pass"));
					tempM.setAddr(rs.getString("addr"));
					tempM.setPoint(rs.getInt("point"));

					mList.add(tempM);
				}
				conn.close();
				return mList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
		return null;
	}

	public boolean chkMem(M_DTO mdto) {
		ResultSet rs;
		boolean flag = true;
		if (connect()) {
			String sql = "select * from member2 where id =" + "'" + mdto.getId() + "'";
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					flag = false;
				}
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
		return flag;
	}

	public ArrayList<Member> schMem(String search) {
		ResultSet rs;
		if (connect()) {
			String sql = "select * from member2 where id like " + "'%" + search + "%' or name like " + "'%" + search
					+ "%'";
			ArrayList<Member> mList = new ArrayList<>();
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Member tempM = new Member();
					tempM.setId(rs.getString("id"));
					tempM.setName(rs.getString("name"));
					tempM.setPass(rs.getString("pass"));
					tempM.setAddr(rs.getString("addr"));
					tempM.setPoint(rs.getInt("point"));
					
					mList.add(tempM);
				}
				conn.close();
				return mList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
		return null;
	}

}

package dao_dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import goodsMRG.Goods;

public class G_DAO {
	private Connection conn = null;

	public G_DAO() {
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

	public void insertG(G_DTO gdto) {
		if (connect()) {
			String sql = "insert into goods values(?,?,?,?,?,default)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, gdto.getGid());
				psmt.setString(2, gdto.getGname());
				psmt.setInt(3, gdto.getGprice());
				psmt.setInt(4, gdto.getGcnt());
				psmt.setString(5, gdto.getSelName());
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

	public void deleteG(String delId) {
		if (connect()) {
			String sql = "delete from goods where gid=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, delId);
				psmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
	}

	public void modyG(G_DTO gdto) {
		if (connect()) {
			String sql = "update goods set gname =?, gprice=?, gcnt=? , selname=? where gid=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, gdto.getGname());
				psmt.setInt(2, gdto.getGprice());
				psmt.setInt(3, gdto.getGcnt());
				psmt.setString(4, gdto.getSelName());
				psmt.setString(5, gdto.getGid());
				psmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
	}

	public ArrayList<Goods> cntCheck() {
		ResultSet rs;
		if (connect()) {
			String sql = "select * from goods where gcnt>(select avg(gcnt) from goods)";
			ArrayList<Goods> gList = new ArrayList<>();
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Goods tempG = new Goods();
					tempG.setGid(rs.getString("gid"));
					tempG.setGname(rs.getString("gname"));
					tempG.setGprice(rs.getInt("gprice"));
					tempG.setGcnt(rs.getInt("gcnt"));
					tempG.setSelName(rs.getString("selName"));
					tempG.setGdate(rs.getDate("gdate"));

					gList.add(tempG);
				}
				conn.close();
				return gList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
		return null;
	}

	public boolean chkG(String search) {
		ResultSet rs;
		boolean flag = true;
		if (connect()) {
			String sql = "select * from goods where gid =?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, search);
				rs = psmt.executeQuery();
				while (rs.next()) {
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

	public ArrayList<Goods> schG(String search) {
		ResultSet rs;
		if (connect()) {
			String sql = "select * from goods where gid like " + "'%" + search + "%' or gname like " + "'%" + search
					+ "%'";
			ArrayList<Goods> gList = new ArrayList<>();
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Goods tempG = new Goods();
					tempG.setGid(rs.getString("gid"));
					tempG.setGname(rs.getString("gname"));
					tempG.setGprice(rs.getInt("gprice"));
					tempG.setGcnt(rs.getInt("gcnt"));
					tempG.setSelName(rs.getString("selName"));
					tempG.setGdate(rs.getDate("gdate"));
					gList.add(tempG);
				}
				conn.close();
				return gList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
		return null;
	}

	public ArrayList<Goods> allSelect() {
		ResultSet rs;
		if (connect()) {
			String sql = "select * from goods";
			ArrayList<Goods> gList = new ArrayList<>();
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Goods tempG = new Goods();
					tempG.setGid(rs.getString("gid"));
					tempG.setGname(rs.getString("gname"));
					tempG.setGprice(rs.getInt("gprice"));
					tempG.setGcnt(rs.getInt("gcnt"));
					tempG.setSelName(rs.getString("selName"));
					tempG.setGdate(rs.getDate("gdate"));
					gList.add(tempG);
				}
				conn.close();
				return gList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
		return null;
	}

}

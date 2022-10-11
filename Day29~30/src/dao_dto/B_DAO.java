package dao_dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shopping.Basket;

public class B_DAO {
	private Connection conn = null;

	public B_DAO() {
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

	public void insertB(B_DTO bdto) {
		if (connect()) {
			String sql = "insert into gbasket values(no.nextval,?,?,default,?)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, bdto.getId());
				psmt.setString(2, bdto.getGid());
				psmt.setInt(3, bdto.getBuyCnt());
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

	public ArrayList<Basket> showB(String search) {
		ResultSet rs;
		if (connect()) {
			String sql = "select * from goodsBasket where id =" + "'" + search + "'";
			ArrayList<Basket> bList = new ArrayList<>();
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Basket tempB = new Basket();
					tempB.setGid(rs.getString("gid"));
					tempB.setGname(rs.getString("gname"));
					tempB.setGprice(rs.getInt("gprice"));
					tempB.setBuyCnt(rs.getInt("buyCnt"));
					tempB.setSelName(rs.getString("selName"));
					tempB.setBuyDate(rs.getDate("buyDate"));
					tempB.setId(rs.getString("id"));
					tempB.setAddr(rs.getString("addr"));
					bList.add(tempB);
				}
				conn.close();
				return bList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
		return null;
	}

}

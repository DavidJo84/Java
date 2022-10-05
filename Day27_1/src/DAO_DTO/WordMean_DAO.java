package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WordMean_DAO {
	private Connection conn = null;
	
	public WordMean_DAO(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean connect() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void insertWord(WordMean_DTO wdto) {
		if(connect()) {
			String sql = "insert into word1 values(?,?,?,?,default)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, wdto.getEng());
				psmt.setString(2, wdto.getMean());
				psmt.setString(3, wdto.getImp());
				psmt.setString(4, wdto.getComment());
				psmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("연결실패");
		}
	}
	
	public void deleteWord(WordMean_DTO wdto) {
		if(connect()) {
			String sql = "delete from word1 where eng=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, wdto.getEng());
				psmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("연결실패");
		}
	}
	
	public void modyWord(WordMean_DTO wdto) {
		if(connect()) {
			String sql = "update word1 set kor=?, imp=?, comm=? where eng=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, wdto.getMean());
				psmt.setString(2, wdto.getImp());
				psmt.setString(3, wdto.getComment());
				psmt.setString(4, wdto.getEng());
				psmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("연결실패");
		}
	}
	
	public void allDeleteWord() {
		if(connect()) {
			String sql = "truncate table word1";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("연결실패");
		}
	}

}

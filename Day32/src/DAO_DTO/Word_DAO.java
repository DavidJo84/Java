package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Word_DAO {
	private Connection conn = null;

	public Word_DAO() {
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

	public void insertWord(Word_DTO wdto) {
		if (connect()) {
			String sql = "insert into word2 values(?,?,?,?)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, wdto.getWord());
				psmt.setString(2, wdto.getMean());
				psmt.setString(3, wdto.getImp());
				psmt.setString(4, wdto.getMemo());
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

	public void deleteWord(Word_DTO wdto) {
		if (connect()) {
			String sql = "delete from word2 where word=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, wdto.getWord());
				psmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
	}

	public void modyWord(Word_DTO wdto) {
		if (connect()) {
			String sql = "update word2 set mean=?, imp=?, memo=? where word=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, wdto.getMean());
				psmt.setString(2, wdto.getImp());
				psmt.setString(3, wdto.getMemo());
				psmt.setString(4, wdto.getWord());
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

	public void allDeleteWord() {
		if (connect()) {
			String sql = "truncate table word2";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
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

	public ArrayList<Word_DTO> allSelect() {
		ResultSet rs;
		if (connect()) {
			String sql = "select * from word2";
			ArrayList<Word_DTO> wList = new ArrayList<>();
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Word_DTO tempW = new Word_DTO();
					tempW.setWord(rs.getString("word"));
					tempW.setMean(rs.getString("mean"));
					tempW.setImp(rs.getString("imp"));
					tempW.setMemo(rs.getString("memo"));
					wList.add(tempW);
				}
				conn.close();
				return wList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
		return null;
	}

	public Word_DTO SelectOne(String word) {
		ResultSet rs;
		Word_DTO tempW = null;
		if (connect()) {
			String sql = "select * from word2 where word = ?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, word);
				rs = psmt.executeQuery();
				if (rs.next()) {
					tempW = new Word_DTO();
					tempW.setWord(rs.getString("word"));
					tempW.setMean(rs.getString("mean"));
					tempW.setImp(rs.getString("imp"));
					tempW.setMemo(rs.getString("memo"));
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
		return tempW;
	}

	public boolean chkWord(Word_DTO wdto) {
		ResultSet rs;
		if (connect()) {
			String sql = "select * from word2 where word =" + "'" + wdto.getWord() + "'";
			try {

				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
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
	
	public ArrayList<Word_DTO> search(String word) {
		ResultSet rs;
		if (connect()) {
			String sql = "select * from word2 where word like "+"'%"+word+"%'";
			ArrayList<Word_DTO> wList = new ArrayList<>();
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Word_DTO tempW = new Word_DTO();
					tempW.setWord(rs.getString("word"));
					tempW.setMean(rs.getString("mean"));
					tempW.setImp(rs.getString("imp"));
					tempW.setMemo(rs.getString("memo"));
					wList.add(tempW);
				}
				conn.close();
				return wList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
		return null;
	}

}

package TestCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//DAO(Data Access Object) :데이터베이스에 접속하여 쿼리를 실행
//쿼리 실행 후 리턴값을 받는 작업을 수행하는 객체를 의미적으로 DAO라고 한다.
//이 객체는 드라이버로딩, 연결요청, 쿼리전송, 결과값을 받는다.
//자원을 반납하는 코드가 포함된다.
public class WordDAO {
	// 데이터베이스 연결을 위한 자원(객체)의 주소를 저장할 참조변수 선언
	private Connection conn = null;

	WordDAO() {
		// 예외처리
		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로드성공");
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("로드실패");
		}
	}

	// 필요할때마다 커넥션을 얻어오는 메서드
	public boolean connect() {
		// 커넥션을 시도하고 그 결과를 얻어오는 코드
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			System.out.println("연결성공");
			return true;
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("연결성공");
			return false;
		}
	}

	// 데이터 삽입
	public void insertWord(WordInfoDTO w) {
		// 1.연결요청
		if (connect()) {
			String sql = "insert into word1 values(?,?,?,?,default)";
			try {
				// 2. 쿼리전송
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, w.getEngName());// mapping
				psmt.setString(2, w.getKorName());// mapping
				psmt.setString(3, w.getImporFlag());// mapping
				psmt.setString(4, w.getComment());// mapping
				// 3. 전송결과를 받고
				int r = psmt.executeUpdate();
				System.out.println(r + "건이 입력되었습니다.");
				// 4. 연결자원을 반납
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("연결실패");
		}
	}
}

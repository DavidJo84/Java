package TestCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//DAO(Data Access Object) :�����ͺ��̽��� �����Ͽ� ������ ����
//���� ���� �� ���ϰ��� �޴� �۾��� �����ϴ� ��ü�� �ǹ������� DAO��� �Ѵ�.
//�� ��ü�� ����̹��ε�, �����û, ��������, ������� �޴´�.
//�ڿ��� �ݳ��ϴ� �ڵ尡 ���Եȴ�.
public class WordDAO {
	// �����ͺ��̽� ������ ���� �ڿ�(��ü)�� �ּҸ� ������ �������� ����
	private Connection conn = null;

	WordDAO() {
		// ����ó��
		try {
			// ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("�ε强��");
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("�ε����");
		}
	}

	// �ʿ��Ҷ����� Ŀ�ؼ��� ������ �޼���
	public boolean connect() {
		// Ŀ�ؼ��� �õ��ϰ� �� ����� ������ �ڵ�
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			System.out.println("���Ἲ��");
			return true;
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("���Ἲ��");
			return false;
		}
	}

	// ������ ����
	public void insertWord(WordInfoDTO w) {
		// 1.�����û
		if (connect()) {
			String sql = "insert into word1 values(?,?,?,?,default)";
			try {
				// 2. ��������
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, w.getEngName());// mapping
				psmt.setString(2, w.getKorName());// mapping
				psmt.setString(3, w.getImporFlag());// mapping
				psmt.setString(4, w.getComment());// mapping
				// 3. ���۰���� �ް�
				int r = psmt.executeUpdate();
				System.out.println(r + "���� �ԷµǾ����ϴ�.");
				// 4. �����ڿ��� �ݳ�
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("�������");
		}
	}
}

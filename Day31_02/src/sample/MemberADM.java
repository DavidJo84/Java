package sample;

import java.util.Scanner;

import dao.DAO_INF;
import dao.MariaDAO;
import dao.MongoDAO;
import dao.MysqlDAO;
import dao.OracleDAO;
import dto.MemberDTO;

public class MemberADM {
	Scanner in = new Scanner(System.in);
	DAO_INF nowDao;
	public MemberADM() {
		System.out.println("고객의 자료를 저장하겠습니다.");
		System.out.println("저장항 DB를 선택하세요.");
		System.out.println("1. 오라클");
		System.out.println("2. MySQL");
		System.out.println("3. MariaDB");
		System.out.println("4. MongoDB");

		int sel = in.nextInt();
		in.nextLine();

		if (sel == 1) {
			nowDao = new OracleDAO();
		} else if (sel == 2) {
			nowDao = new MysqlDAO();
		} else if (sel == 3) {
			nowDao = new MariaDAO();
		} else if (sel == 3) {
			nowDao = new MongoDAO();
		}
	}

	public void running() {
		while (true) {
			menu();
			int sel = in.nextInt();
			in.nextLine();
			if (sel == 1) {
				addMember();
			} else if (sel == 2) {
				delMember();
			}
		}
	}

	private void delMember() {
		
		
	}

	private void addMember() {
		MemberDTO m = new MemberDTO();
		nowDao.insert(m);
		
	}

	public void menu() {
		System.out.println("1. 회원등록");
		System.out.println("2. 회원삭제");
		System.out.println("선택하세요>>>");
	}
}

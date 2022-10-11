package shopping;

import java.util.Scanner;

import dao_dto.M_DAO;
import dao_dto.M_DTO;

public class Login {
	Scanner in = new Scanner(System.in);

	public Login() {
		M_DAO mdao = new M_DAO();
		M_DTO mdto = new M_DTO();

		System.out.println("회원 아이디를 입력하세요");
		String id = in.nextLine();
		mdto.setId(id);
		if (!mdao.chkMem(mdto)) {
			System.out.println("비밀번호를 입력하세요");
			String pass = in.nextLine();
			mdto.setPass(pass);
			if (!mdao.chkLogin(mdto)) {
				new ShoppingManager(id);
			} else {
				System.out.println("비밀번호를 확인하세요");
			}
		} else {
			System.out.println("등록된 아이디가 없습니다.");
		}
	}
}

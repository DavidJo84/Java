package shopping;

import java.util.Scanner;

import dao_dto.M_DAO;
import dao_dto.M_DTO;

public class Login {
	Scanner in = new Scanner(System.in);

	public Login() {
		M_DAO mdao = new M_DAO();
		M_DTO mdto = new M_DTO();

		System.out.println("ȸ�� ���̵� �Է��ϼ���");
		String id = in.nextLine();
		mdto.setId(id);
		if (!mdao.chkMem(mdto)) {
			System.out.println("��й�ȣ�� �Է��ϼ���");
			String pass = in.nextLine();
			mdto.setPass(pass);
			if (!mdao.chkLogin(mdto)) {
				new ShoppingManager(id);
			} else {
				System.out.println("��й�ȣ�� Ȯ���ϼ���");
			}
		} else {
			System.out.println("��ϵ� ���̵� �����ϴ�.");
		}
	}
}

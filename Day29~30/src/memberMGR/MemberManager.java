package memberMGR;

import java.util.ArrayList;
import java.util.Scanner;

import dao_dto.M_DAO;
import dao_dto.M_DTO;

public class MemberManager {
	M_DAO mdao = new M_DAO();
	Scanner in = new Scanner(System.in);

	public MemberManager() {

		for (;;) {
			menu();
			System.out.println("�޴��� �������ּ��� ");
			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				addMem();
			} else if (selMenu.equals("2")) {
				showMem();
			} else if (selMenu.equals("3")) {
				modMem();
			} else if (selMenu.equals("4")) {
				searchMem();
			} else if (selMenu.equals("5")) {
				delMem();
			} else if (selMenu.equals("6")) {
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}

	}

	private void modMem() {
		M_DTO mdto = new M_DTO();
		System.out.println("������ ID�� �Է����ּ���. ");
		String modId = in.nextLine();
		mdto.setId(modId);
		if (!mdao.chkMem(mdto)) {
			System.out.println("������ �Է����ּ���. ");
			String modName = in.nextLine();
			System.out.println("��й�ȣ�� �Է��ϼ���. ");
			String modPass = in.nextLine();
			System.out.println("�ּҸ� �Է��ϼ���. ");
			String modAddr = in.nextLine();
			mdto.setName(modName);
			mdto.setPass(modPass);
			mdto.setAddr(modAddr);

			mdao.modyMem(mdto);
			System.out.println(modId + "(��/��) �����Ǿ����ϴ�. ");
		} else {
			System.out.println(modId + "(��/��) �����ϴ�.");
		}
	}

	private void showMem() {
		ArrayList<Member> mList = mdao.allSelect();
		System.out.println("��ϵ� ���� " + mList.size() + "�� �Դϴ�.");
		for (Member i : mList) {
			i.prt();
		}
	}

	private void searchMem() {
		M_DTO mdto = new M_DTO();
		System.out.println("�˻�� �Է����ּ��� ");
		String search = in.nextLine();
		mdto.setId(search);
		if (mdao.chkMem(mdto)) {
			ArrayList<Member> mList = mdao.schMem(search);
			for (Member i : mList) {
				i.prt();
			}
		} else {
			System.out.println(search + "(��/��) �����ϴ�.");
		}
	}

	private void delMem() {
		M_DTO mdto = new M_DTO();
		System.out.println("������ ID�� �Է��ϼ���. ");
		String delId = in.nextLine();
		if (mdao.chkMem(mdto)) {
			mdto.setId(delId);
			mdao.deleteWord(mdto);
			System.out.println(delId + "(��/��) �����Ǿ����ϴ�. ");
		} else {
			System.out.println(delId + "(��/��) �����ϴ�.");
		}
	}

	private void addMem() {
		M_DTO mdto = new M_DTO();
		System.out.println("���̵� �Է��ϻ��� ");
		String newId = in.nextLine();
		mdto.setId(newId);
		if (mdao.chkMem(mdto)) {
			System.out.println("������ �Է��ϼ���. ");
			String newName = in.nextLine();
			System.out.println("��й�ȣ�� �Է��ϼ���. ");
			String newPass = in.nextLine();
			System.out.println("�ּҸ� �Է��ϼ���. ");
			String newAddr = in.nextLine();
			mdto.setName(newName);
			mdto.setPass(newPass);
			mdto.setAddr(newAddr);

			mdao.insertMem(mdto);

			System.out.println(newId + "(��/��) �߰��Ǿ����ϴ�.");
		} else {
			System.out.println("�̹� ��ϵ� ���̵� �Դϴ�.");
		}

	}

	private void menu() {
		System.out.println("--------- ");
		System.out.println("1. ����� ");
		System.out.println("2. ����� ");
		System.out.println("3. ������ ");
		System.out.println("4. ���˻� ");
		System.out.println("5. ������ ");
		System.out.println("6. �����޴� ");
	}
}

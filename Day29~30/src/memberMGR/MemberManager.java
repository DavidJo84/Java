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
			System.out.println("메뉴를 선택해주세요 ");
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
				System.out.println("잘못된 입력입니다.");
			}
		}

	}

	private void modMem() {
		M_DTO mdto = new M_DTO();
		System.out.println("수정할 ID를 입력해주세요. ");
		String modId = in.nextLine();
		mdto.setId(modId);
		if (!mdao.chkMem(mdto)) {
			System.out.println("고객명을 입력해주세요. ");
			String modName = in.nextLine();
			System.out.println("비밀번호를 입력하세요. ");
			String modPass = in.nextLine();
			System.out.println("주소를 입력하세요. ");
			String modAddr = in.nextLine();
			mdto.setName(modName);
			mdto.setPass(modPass);
			mdto.setAddr(modAddr);

			mdao.modyMem(mdto);
			System.out.println(modId + "(이/가) 수정되었습니다. ");
		} else {
			System.out.println(modId + "(이/가) 없습니다.");
		}
	}

	private void showMem() {
		ArrayList<Member> mList = mdao.allSelect();
		System.out.println("등록된 고객은 " + mList.size() + "명 입니다.");
		for (Member i : mList) {
			i.prt();
		}
	}

	private void searchMem() {
		M_DTO mdto = new M_DTO();
		System.out.println("검색어를 입력해주세요 ");
		String search = in.nextLine();
		mdto.setId(search);
		if (mdao.chkMem(mdto)) {
			ArrayList<Member> mList = mdao.schMem(search);
			for (Member i : mList) {
				i.prt();
			}
		} else {
			System.out.println(search + "(이/가) 없습니다.");
		}
	}

	private void delMem() {
		M_DTO mdto = new M_DTO();
		System.out.println("삭제할 ID를 입력하세요. ");
		String delId = in.nextLine();
		if (mdao.chkMem(mdto)) {
			mdto.setId(delId);
			mdao.deleteWord(mdto);
			System.out.println(delId + "(이/가) 삭제되었습니다. ");
		} else {
			System.out.println(delId + "(이/가) 없습니다.");
		}
	}

	private void addMem() {
		M_DTO mdto = new M_DTO();
		System.out.println("아이디를 입력하새요 ");
		String newId = in.nextLine();
		mdto.setId(newId);
		if (mdao.chkMem(mdto)) {
			System.out.println("고객명을 입력하세요. ");
			String newName = in.nextLine();
			System.out.println("비밀번호를 입력하세요. ");
			String newPass = in.nextLine();
			System.out.println("주소를 입력하세요. ");
			String newAddr = in.nextLine();
			mdto.setName(newName);
			mdto.setPass(newPass);
			mdto.setAddr(newAddr);

			mdao.insertMem(mdto);

			System.out.println(newId + "(이/가) 추가되었습니다.");
		} else {
			System.out.println("이미 등록된 아이디 입니다.");
		}

	}

	private void menu() {
		System.out.println("--------- ");
		System.out.println("1. 고객등록 ");
		System.out.println("2. 고객목록 ");
		System.out.println("3. 고객수정 ");
		System.out.println("4. 고객검색 ");
		System.out.println("5. 고객삭제 ");
		System.out.println("6. 이전메뉴 ");
	}
}

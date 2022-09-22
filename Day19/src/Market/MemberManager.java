package Market;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManager {

	ArrayList<Member> mem = new ArrayList<>();
	Scanner in = new Scanner(System.in);
	int memberIdx;
	GoodsManager b = null;

	public MemberManager(GoodsManager a) {
		b = a;
	}

	public void menu() {
		for (;;) {
			System.out.println("------------");
			System.out.println("1. 회원 가입");
			System.out.println("2. 로그인");
			System.out.println("3. 이전메뉴");
			System.out.println("------------");
			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				memberJoin();
			} else if (selMenu.equals("2")) {
				if (mem.size() != 0) {
					chkMember();
				} else {
					System.out.println("회원이 없습니다. 회원가입부터 해주세요.");
				}

			} else if (selMenu.equals("3")) {
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	private void chkMember() {
		System.out.println("ID를 입력하세요");
		String memberId = in.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String memberPwd = in.nextLine();
		for (int i = 0; i < mem.size(); i++) {
			if (mem.get(i).memberId.equals(memberId) && mem.get(i).memberPwd.equals(memberPwd)) {
				System.out.println(memberId + "님 환영합니다.");
				memberIdx = i;
				joinMenu();
			} else {
				System.out.println("회원정보를 확인하세요");
			}
		}
	}

	private void joinMenu() {
		for (;;) {
			System.out.println("------------");
			System.out.println("1. 회원 관리");
			System.out.println("2. 쇼핑하기");
			System.out.println("3. 장바구니보기");
			System.out.println("4. 이전메뉴");
			System.out.println("------------");
			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				System.out.println("------------");
				System.out.println("1. 내정보");
				System.out.println("2. 회원 수정");
				System.out.println("3. 회원 탈퇴");
				System.out.println("------------");
				String selMenu2 = in.nextLine();
				if (selMenu2.equals("1")) {
					mem.get(memberIdx).memberPrt();
				} else if (selMenu2.equals("2")) {
					System.out.println("------------");
					System.out.println("새로운 이름을 입력하세요");
					String memberName = in.nextLine();
					System.out.println("새로운 비밀번호를 입력하세요");
					String memberPwd = in.nextLine();
					System.out.println("비밀번호 확인");
					String memberChkPwd = in.nextLine();

					if (memberPwd.equals(memberChkPwd)) {
						mem.get(memberIdx).memberName = memberName;
						mem.get(memberIdx).memberPwd = memberPwd;
					} else {
						System.out.println("비밀번호를 확인하세요.");
					}
				} else if (selMenu2.equals("3")) {
					System.out.println("정말로 탈퇴하시겠습니까?(Y/N)");
					String b = in.nextLine();
					b.toLowerCase();
					if (b.equals("y")) {
						mem.remove(memberIdx);
						System.out.println("탈퇴완료");
						break;
					} else {
						System.out.println("메뉴로 돌아갑니다.");
					}
				} else {
					System.out.println("잘못된 입력입니다.");
				}
			} else if (selMenu.equals("2")) {
				mem.get(memberIdx).shopping(b);

			} else if (selMenu.equals("3")) {
				System.out.println("장바구니 정보-------");
				mem.get(memberIdx).viewBasket();
				System.out.println("------------");

			} else if (selMenu.equals("4")) {
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	private void memberJoin() {
		Member save = new Member();
		// TODO Auto-generated method stub
		System.out.println("이름을 입력하세요");
		String memberName = in.nextLine();
		System.out.println("ID를 입력하세요");
		String memberId = in.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String memberPwd = in.nextLine();
		System.out.println("비밀번호 확인");
		String memberChkPwd = in.nextLine();

		if (mem.size() != 0) {
			for (int i = 0; i < mem.size(); i++) {
				if (mem.get(i).memberId.equals(memberId)) {
					System.out.println("이미 사용중인 ID입니다.");
				} else if (memberPwd.equals(memberChkPwd)) {
					save.inputMember(memberName, memberId, memberPwd);
					mem.add(save);
					System.out.println("회원가입 되었습니다.");
				} else {
					System.out.println("비밀번호를 확인하세요.");
				}
			}

		} else {
			if (memberPwd.equals(memberChkPwd)) {
				save.inputMember(memberName, memberId, memberPwd);
				mem.add(save);
				System.out.println("회원가입 되었습니다.");
			} else {
				System.out.println("비밀번호를 확인하세요.");
			}
		}
	}
}

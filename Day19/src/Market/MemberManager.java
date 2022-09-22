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
			System.out.println("1. ȸ�� ����");
			System.out.println("2. �α���");
			System.out.println("3. �����޴�");
			System.out.println("------------");
			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				memberJoin();
			} else if (selMenu.equals("2")) {
				if (mem.size() != 0) {
					chkMember();
				} else {
					System.out.println("ȸ���� �����ϴ�. ȸ�����Ժ��� ���ּ���.");
				}

			} else if (selMenu.equals("3")) {
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}

	private void chkMember() {
		System.out.println("ID�� �Է��ϼ���");
		String memberId = in.nextLine();
		System.out.println("��й�ȣ�� �Է��ϼ���");
		String memberPwd = in.nextLine();
		for (int i = 0; i < mem.size(); i++) {
			if (mem.get(i).memberId.equals(memberId) && mem.get(i).memberPwd.equals(memberPwd)) {
				System.out.println(memberId + "�� ȯ���մϴ�.");
				memberIdx = i;
				joinMenu();
			} else {
				System.out.println("ȸ�������� Ȯ���ϼ���");
			}
		}
	}

	private void joinMenu() {
		for (;;) {
			System.out.println("------------");
			System.out.println("1. ȸ�� ����");
			System.out.println("2. �����ϱ�");
			System.out.println("3. ��ٱ��Ϻ���");
			System.out.println("4. �����޴�");
			System.out.println("------------");
			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				System.out.println("------------");
				System.out.println("1. ������");
				System.out.println("2. ȸ�� ����");
				System.out.println("3. ȸ�� Ż��");
				System.out.println("------------");
				String selMenu2 = in.nextLine();
				if (selMenu2.equals("1")) {
					mem.get(memberIdx).memberPrt();
				} else if (selMenu2.equals("2")) {
					System.out.println("------------");
					System.out.println("���ο� �̸��� �Է��ϼ���");
					String memberName = in.nextLine();
					System.out.println("���ο� ��й�ȣ�� �Է��ϼ���");
					String memberPwd = in.nextLine();
					System.out.println("��й�ȣ Ȯ��");
					String memberChkPwd = in.nextLine();

					if (memberPwd.equals(memberChkPwd)) {
						mem.get(memberIdx).memberName = memberName;
						mem.get(memberIdx).memberPwd = memberPwd;
					} else {
						System.out.println("��й�ȣ�� Ȯ���ϼ���.");
					}
				} else if (selMenu2.equals("3")) {
					System.out.println("������ Ż���Ͻðڽ��ϱ�?(Y/N)");
					String b = in.nextLine();
					b.toLowerCase();
					if (b.equals("y")) {
						mem.remove(memberIdx);
						System.out.println("Ż��Ϸ�");
						break;
					} else {
						System.out.println("�޴��� ���ư��ϴ�.");
					}
				} else {
					System.out.println("�߸��� �Է��Դϴ�.");
				}
			} else if (selMenu.equals("2")) {
				mem.get(memberIdx).shopping(b);

			} else if (selMenu.equals("3")) {
				System.out.println("��ٱ��� ����-------");
				mem.get(memberIdx).viewBasket();
				System.out.println("------------");

			} else if (selMenu.equals("4")) {
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}

	private void memberJoin() {
		Member save = new Member();
		// TODO Auto-generated method stub
		System.out.println("�̸��� �Է��ϼ���");
		String memberName = in.nextLine();
		System.out.println("ID�� �Է��ϼ���");
		String memberId = in.nextLine();
		System.out.println("��й�ȣ�� �Է��ϼ���");
		String memberPwd = in.nextLine();
		System.out.println("��й�ȣ Ȯ��");
		String memberChkPwd = in.nextLine();

		if (mem.size() != 0) {
			for (int i = 0; i < mem.size(); i++) {
				if (mem.get(i).memberId.equals(memberId)) {
					System.out.println("�̹� ������� ID�Դϴ�.");
				} else if (memberPwd.equals(memberChkPwd)) {
					save.inputMember(memberName, memberId, memberPwd);
					mem.add(save);
					System.out.println("ȸ������ �Ǿ����ϴ�.");
				} else {
					System.out.println("��й�ȣ�� Ȯ���ϼ���.");
				}
			}

		} else {
			if (memberPwd.equals(memberChkPwd)) {
				save.inputMember(memberName, memberId, memberPwd);
				mem.add(save);
				System.out.println("ȸ������ �Ǿ����ϴ�.");
			} else {
				System.out.println("��й�ȣ�� Ȯ���ϼ���.");
			}
		}
	}
}

package Market;

import java.util.Scanner;

public class Menu {
	Scanner in = new Scanner(System.in);
	GoodsManager a = new GoodsManager();
	MemberManager b = new MemberManager(a);

	Menu() {
		for (;;) {
			menu();
			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				a.runGoods();
			} else if (selMenu.equals("2")) {
				b.menu();
			} else if (selMenu.equals("3")) {
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}

	private void menu() {
		System.out.println("-----------");
		System.out.println("1. ��ǰ����");
		System.out.println("2. ���θ�");
		System.out.println("3. ���α׷�����");
		System.out.println("-----------");
	}
}

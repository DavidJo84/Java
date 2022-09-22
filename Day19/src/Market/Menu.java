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
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	private void menu() {
		System.out.println("-----------");
		System.out.println("1. 상품관리");
		System.out.println("2. 쇼핑몰");
		System.out.println("3. 프로그램종료");
		System.out.println("-----------");
	}
}

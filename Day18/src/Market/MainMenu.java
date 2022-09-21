package Market;

import java.util.Scanner;

public class MainMenu {
	Scanner in = new Scanner(System.in);
	GoodsManeger a = new GoodsManeger();
	Member b = new Member(a);

	MainMenu() {
		for (;;) {
			menu();
			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				a.runGoods();
			} else if (selMenu.equals("2")) {
				b.goShopping();
			} else if (selMenu.equals("3")) {
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	private void menu() {
		System.out.println("-----------");
		System.out.println("1. 물건관리");
		System.out.println("2. 쇼핑하기");
		System.out.println("3. 종료");
		System.out.println("-----------");

	}

}

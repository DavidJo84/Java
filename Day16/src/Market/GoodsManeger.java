package Market;

import java.util.Scanner;

public class GoodsManeger {
	Goods[] gList = new Goods[10];
	Scanner in = new Scanner(System.in);

	GoodsManeger() {
		for (;;) {
			menu();
			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				addGoods();
			} else if (selMenu.equals("3")) {
				listGoods();
			}
		}
	}

	private void addGoods() {
		Goods newGoods = new Goods();
		System.out.println("이름 입력");
		String name = in.nextLine();
		System.out.println("아이디 입력");
		String id = in.nextLine();
		System.out.println("수량 입력");
		int cnt = in.nextInt();
		in.nextLine();
		System.out.println("단가 입력");
		int price = in.nextInt();
		in.nextLine();

		newGoods.setting(name, id, cnt, price);

		for (int i = 0; i < gList.length; i++) {
			if (gList[i] == null) {
				gList[i] = newGoods;
				break;
			}
		}
	}

	private void listGoods() {
		for (int i = 0; i < gList.length; i++) {
			if (gList[i] != null) {
				System.out.println(i + "번 정보-------");
				gList[i].prt();
				System.out.println("------------");
			}
		}

	}

	private void menu() {
		// TODO Auto-generated method stub
		System.out.println("1. 물건등록");
		System.out.println("2. 물건수정");
		System.out.println("3. 전체보기");
		System.out.println("4. 물건삭제");
	}
}

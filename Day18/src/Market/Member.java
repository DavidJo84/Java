package Market;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {
	
	String name = "guest";
	ArrayList<GoodsBasket> basket = new ArrayList<>();
	Scanner in = new Scanner(System.in);
	GoodsManeger aa = null;

	public Member(GoodsManeger aa) {
		this.aa = aa;
	}

	public void goShopping() {
		for (;;) {
			menu();
			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				shopping();
			} else if (selMenu.equals("2")) {
				System.out.println("장바구니 정보-------");
				viewBasket();
				System.out.println("------------");
			} else if (selMenu.equals("3")) {
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}

	}

	private void viewBasket() {
		for (int i = 0; i < basket.size(); i++) {
			System.out.println("------------");
			basket.get(i).prt();
		}
	}

	public void shopping() {
		GoodsBasket c = new GoodsBasket();
		aa.listGoods();
		System.out.println("구매할 물건의 번호를 입력하세요");
		String a = in.nextLine();
		int b = Integer.parseInt(a);
		if (b < aa.gList.size()) {
			System.out.println("구매할 수량을 입력하세요");
			String a1 = in.nextLine();
			int b1 = Integer.parseInt(a1);
			c.name = aa.gList.get(b).name;
			c.plusCnt(b1);
			if(aa.gList.get(b).cnt-b1<0) {
				System.out.println("수량이 부족합니다.");
			}else {
				aa.gList.get(b).reCnt(b1);
				c.sumPrice(aa.gList.get(b).price);
				basket.add(c);
				System.out.println(aa.gList.get(b).name + b1 + "개 구매 완료");
			}
		} else {
			System.out.println("잘못된 입력입니다.");
		}
	}

	private void menu() {
		System.out.println("-----------");
		System.out.println("1. 구매하기");
		System.out.println("2. 장바구니");
		System.out.println("3. 이전메뉴");
		System.out.println("-----------");

	}

}

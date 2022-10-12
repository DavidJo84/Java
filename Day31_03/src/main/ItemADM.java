package main;

import java.util.ArrayList;
import java.util.Scanner;

import item.Dduck;
import item.Item_DTO;
import item.Item_INF;
import item.Kimbab;
import item.Ramen;

public class ItemADM {
	Scanner in = new Scanner(System.in);
	Item_INF nowItem;
	Item_DTO m = new Item_DTO();
	ArrayList<Item_INF> iList = new ArrayList<>();

	public ItemADM() {
		for (;;) {
			System.out.println("오늘의 메뉴----");
			System.out.println("1. 라면");
			System.out.println("2. 떡볶이");
			System.out.println("3. 김밥");
			System.out.println("4. 프로그램종료");
			System.out.println("메뉴 선택>>>>");

			int sel = in.nextInt();
			in.nextLine();

			if (sel == 1) {
				nowItem = new Ramen();
				running(sel);
			} else if (sel == 2) {
				nowItem = new Dduck();
				running(sel);
			} else if (sel == 3) {
				nowItem = new Kimbab();
				running(sel);
			}else if (sel == 4) {
				break;
			}
		}
	}

	public void running(int sel) {
		while (true) {
			menu();
			int sel2 = in.nextInt();
			in.nextLine();
			if (sel2 == 1) {
				showInfo();
			} else if (sel2 == 2) {
				addItem(sel);
			} else if (sel2 == 3) {
				payItem();
			} else if (sel2 == 4) {
				showBasket();
			} else if (sel2 == 5) {
				break;
			}
		}
	}

	private void showBasket() {
		for (Item_INF i : iList) {
			i.showInfo();
		}

	}

	private void payItem() {
		nowItem.pay();

	}

	private void addItem(int sel) {
		if (sel == 1) {
			System.out.println("------------");
			System.out.println("라면 종류는 두가지 입니다.");
			System.out.println("주문할 라면을 입력하세요(쉰라면,진라면)");
			String name = in.nextLine();
			System.out.println("주문할 수량을 입력하세요");
			int cnt = in.nextInt();
			in.nextLine();
			m.setCnt(cnt);
			m.setName(name);
			if (name.equals("쉰라면")) {
				m.setPrice(1500);
			} else {
				m.setPrice(2000);
			}
			nowItem.insert(m);
			iList.add(nowItem);

		} else if (sel == 2) {
			System.out.println("------------");
			System.out.println("떡 종류를 입력하세요(밀떡,쌀떡)");
			String Dduck = in.nextLine();
			System.out.println("맵기를 입력하세요(강/중간/보통)");
			String hot = in.nextLine();
			String name = Dduck + " / " + hot;
			System.out.println("주문할 수량을 입력하세요");
			int cnt = in.nextInt();
			in.nextLine();
			m.setCnt(cnt);
			m.setName(name);
			m.setPrice(2000);
			nowItem.insert(m);
			iList.add(nowItem);

		} else if (sel == 3) {
			System.out.println("------------");
			System.out.println("김밥 종류는 세가지 입니다.");
			System.out.println("주문할 김밥을 입력하세요(참치/일반/돈까스)");
			String name = in.nextLine();
			System.out.println("주문할 수량을 입력하세요");
			int cnt = in.nextInt();
			in.nextLine();
			m.setCnt(cnt);
			m.setName(name);
			if (name.equals("일반")) {
				m.setPrice(2000);
			} else {
				m.setPrice(3000);
			}

			nowItem.insert(m);
			iList.add(nowItem);

		}

	}

	private void showInfo() {
		nowItem.showcomment();

	}

	public void menu() {
		System.out.println("------------");
		System.out.println("1. 정보보기");
		System.out.println("2. 장바구니담기");
		System.out.println("3. 계산하기");
		System.out.println("4. 주문내역");
		System.out.println("5. 이전메뉴");
		System.out.println("선택하세요>>>");
	}
}

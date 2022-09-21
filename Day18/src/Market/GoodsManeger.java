package Market;

import java.util.ArrayList;
import java.util.Scanner;

public class GoodsManeger {
	ArrayList<Goods> gList = new ArrayList<>();
	Scanner in = new Scanner(System.in);

	public void runGoods() {
		for (;;) {
			menu();
			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				addGoods();
			} else if (selMenu.equals("3")) {
				listGoods();
			} else if (selMenu.equals("2")) {
				modGoods();
			} else if (selMenu.equals("4")) {
				delGoods();
			} else if (selMenu.equals("5")) {
				searchGoods();
			} else if (selMenu.equals("6")) {
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	private void searchGoods() {
		System.out.println("검색할 이름을 입력하세요");
		String b = in.nextLine();
		boolean flag = false;
		for (int i = 0; i < gList.size(); i++) {
			if (gList.get(i).name.equals(b)) {
				System.out.println(b + "와 같은 이름");
				gList.get(i).prt();
				flag = true;
				System.out.println("--------------");
			} else if (gList.get(i).name.indexOf(b) != -1) {
				System.out.println(b + "를 포함하는 이름");
				gList.get(i).prt();
				flag = true;
				System.out.println("--------------");
			}

		}
		if (flag == false) {
			System.out.println("이름이 없습니다.");
		}
	}

	private void delGoods() {
		System.out.println("삭제할 이름을 입력하세요");
		String b = in.nextLine();
		boolean flag = true;
		for (int i = 0; i < gList.size(); i++) {
			if (gList.get(i).name.equals(b)) {
				gList.remove(i);
				System.out.println(b + "삭제 완료");
				flag = false;
			}
		}
		if (flag) {
			System.out.println("이름이 없습니다.");
		}
	}

	private void modGoods() {
		System.out.println("수정할 이름을 입력하세요");
		String b = in.nextLine();
		boolean flag = true;
		for (int i = 0; i < gList.size(); i++) {
			if (gList.get(i).name.equals(b)) {
				System.out.println("수량을 입력하세요");
				int newInt = in.nextInt();
				in.nextLine();
				gList.get(i).cnt = newInt;

				System.out.println("가격을 입력하세요");
				newInt = in.nextInt();
				in.nextLine();
				gList.get(i).price = newInt;
				flag = false;
			}
		}
		if (flag) {
			System.out.println("이름이 없습니다.");
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

		gList.add(newGoods);
	}

	public void listGoods() {
		for (int i = 0; i < gList.size(); i++) {
			System.out.println(i + "번 정보-------");
			gList.get(i).prt();
			System.out.println("------------");
		}
	}

	private void menu() {
		System.out.println("-----------");
		System.out.println("1. 물건등록");
		System.out.println("2. 물건수정");
		System.out.println("3. 전체보기");
		System.out.println("4. 물건삭제");
		System.out.println("5. 물건검색");
		System.out.println("6. 이전메뉴");
		System.out.println("-----------");
	}
}
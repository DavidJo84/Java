package Market;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {
	String memberName = null;
	String memberId = null;
	String memberPwd = null;

	public void inputMember(String memberName, String memberId, String memberPwd) {
		this.memberName = memberName;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
	}

	public void memberPrt() {
		System.out.println("이름: " + memberName);
		System.out.println("ID: " + memberId);
		System.out.println("Pwd: " + memberPwd);
	}

	ArrayList<GoodsBasket> basket = new ArrayList<>();

	public void viewBasket() {
		for (int i = 0; i < basket.size(); i++) {
			System.out.println("------------");
			basket.get(i).basketPrt();
		}
	}

	Scanner in = new Scanner(System.in);

	public void shopping(GoodsManager c) {
		c.listGoods();
		System.out.println("구매할 물건의 번호를 입력하세요");
		System.out.println("이전메뉴로 가려면 100을 입력하세요");
		String a = in.nextLine();
		int b = Integer.parseInt(a);
		if (b < c.gList.size()) {
			Goods g = c.gList.get(b);
			System.out.println("구매할 수량을 입력하세요");
			String a1 = in.nextLine();
			int b1 = Integer.parseInt(a1);
			if (g.cnt - b1 < 0) {
				System.out.println("수량이 부족합니다.");
			} else {
				GoodsBasket gb = new GoodsBasket();
				gb.name = g.name;
				g.reCnt(b1);
				gb.plusCnt(b1);
				gb.sumPrice(g.price);
				basket.add(gb);
				System.out.println(g.name + " " + b1 + "개 구매 완료");
			}
		} else if (b == 100) {
			System.out.println("이전메뉴로 갑니다.");
		} else {
			System.out.println("잘못된 입력입니다.");
		}
	}
}

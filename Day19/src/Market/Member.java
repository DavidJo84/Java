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
		System.out.println("�̸�: " + memberName);
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
		System.out.println("������ ������ ��ȣ�� �Է��ϼ���");
		System.out.println("�����޴��� ������ 100�� �Է��ϼ���");
		String a = in.nextLine();
		int b = Integer.parseInt(a);
		if (b < c.gList.size()) {
			Goods g = c.gList.get(b);
			System.out.println("������ ������ �Է��ϼ���");
			String a1 = in.nextLine();
			int b1 = Integer.parseInt(a1);
			if (g.cnt - b1 < 0) {
				System.out.println("������ �����մϴ�.");
			} else {
				GoodsBasket gb = new GoodsBasket();
				gb.name = g.name;
				g.reCnt(b1);
				gb.plusCnt(b1);
				gb.sumPrice(g.price);
				basket.add(gb);
				System.out.println(g.name + " " + b1 + "�� ���� �Ϸ�");
			}
		} else if (b == 100) {
			System.out.println("�����޴��� ���ϴ�.");
		} else {
			System.out.println("�߸��� �Է��Դϴ�.");
		}
	}
}

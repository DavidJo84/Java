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
		System.out.println("�̸� �Է�");
		String name = in.nextLine();
		System.out.println("���̵� �Է�");
		String id = in.nextLine();
		System.out.println("���� �Է�");
		int cnt = in.nextInt();
		in.nextLine();
		System.out.println("�ܰ� �Է�");
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
				System.out.println(i + "�� ����-------");
				gList[i].prt();
				System.out.println("------------");
			}
		}

	}

	private void menu() {
		// TODO Auto-generated method stub
		System.out.println("1. ���ǵ��");
		System.out.println("2. ���Ǽ���");
		System.out.println("3. ��ü����");
		System.out.println("4. ���ǻ���");
	}
}

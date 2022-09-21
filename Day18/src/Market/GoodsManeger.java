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
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}
	private void searchGoods() {
		System.out.println("�˻��� �̸��� �Է��ϼ���");
		String b = in.nextLine();
		boolean flag = false;
		for (int i = 0; i < gList.size(); i++) {
			if (gList.get(i).name.equals(b)) {
				System.out.println(b + "�� ���� �̸�");
				gList.get(i).prt();
				flag = true;
				System.out.println("--------------");
			} else if (gList.get(i).name.indexOf(b) != -1) {
				System.out.println(b + "�� �����ϴ� �̸�");
				gList.get(i).prt();
				flag = true;
				System.out.println("--------------");
			}

		}
		if (flag == false) {
			System.out.println("�̸��� �����ϴ�.");
		}
	}

	private void delGoods() {
		System.out.println("������ �̸��� �Է��ϼ���");
		String b = in.nextLine();
		boolean flag = true;
		for (int i = 0; i < gList.size(); i++) {
			if (gList.get(i).name.equals(b)) {
				gList.remove(i);
				System.out.println(b + "���� �Ϸ�");
				flag = false;
			}
		}
		if (flag) {
			System.out.println("�̸��� �����ϴ�.");
		}
	}

	private void modGoods() {
		System.out.println("������ �̸��� �Է��ϼ���");
		String b = in.nextLine();
		boolean flag = true;
		for (int i = 0; i < gList.size(); i++) {
			if (gList.get(i).name.equals(b)) {
				System.out.println("������ �Է��ϼ���");
				int newInt = in.nextInt();
				in.nextLine();
				gList.get(i).cnt = newInt;

				System.out.println("������ �Է��ϼ���");
				newInt = in.nextInt();
				in.nextLine();
				gList.get(i).price = newInt;
				flag = false;
			}
		}
		if (flag) {
			System.out.println("�̸��� �����ϴ�.");
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

		gList.add(newGoods);
	}

	public void listGoods() {
		for (int i = 0; i < gList.size(); i++) {
			System.out.println(i + "�� ����-------");
			gList.get(i).prt();
			System.out.println("------------");
		}
	}

	private void menu() {
		System.out.println("-----------");
		System.out.println("1. ���ǵ��");
		System.out.println("2. ���Ǽ���");
		System.out.println("3. ��ü����");
		System.out.println("4. ���ǻ���");
		System.out.println("5. ���ǰ˻�");
		System.out.println("6. �����޴�");
		System.out.println("-----------");
	}
}
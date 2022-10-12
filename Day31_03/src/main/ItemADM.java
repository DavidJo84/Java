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
			System.out.println("������ �޴�----");
			System.out.println("1. ���");
			System.out.println("2. ������");
			System.out.println("3. ���");
			System.out.println("4. ���α׷�����");
			System.out.println("�޴� ����>>>>");

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
			System.out.println("��� ������ �ΰ��� �Դϴ�.");
			System.out.println("�ֹ��� ����� �Է��ϼ���(�����,�����)");
			String name = in.nextLine();
			System.out.println("�ֹ��� ������ �Է��ϼ���");
			int cnt = in.nextInt();
			in.nextLine();
			m.setCnt(cnt);
			m.setName(name);
			if (name.equals("�����")) {
				m.setPrice(1500);
			} else {
				m.setPrice(2000);
			}
			nowItem.insert(m);
			iList.add(nowItem);

		} else if (sel == 2) {
			System.out.println("------------");
			System.out.println("�� ������ �Է��ϼ���(�ж�,�Ҷ�)");
			String Dduck = in.nextLine();
			System.out.println("�ʱ⸦ �Է��ϼ���(��/�߰�/����)");
			String hot = in.nextLine();
			String name = Dduck + " / " + hot;
			System.out.println("�ֹ��� ������ �Է��ϼ���");
			int cnt = in.nextInt();
			in.nextLine();
			m.setCnt(cnt);
			m.setName(name);
			m.setPrice(2000);
			nowItem.insert(m);
			iList.add(nowItem);

		} else if (sel == 3) {
			System.out.println("------------");
			System.out.println("��� ������ ������ �Դϴ�.");
			System.out.println("�ֹ��� ����� �Է��ϼ���(��ġ/�Ϲ�/���)");
			String name = in.nextLine();
			System.out.println("�ֹ��� ������ �Է��ϼ���");
			int cnt = in.nextInt();
			in.nextLine();
			m.setCnt(cnt);
			m.setName(name);
			if (name.equals("�Ϲ�")) {
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
		System.out.println("1. ��������");
		System.out.println("2. ��ٱ��ϴ��");
		System.out.println("3. ����ϱ�");
		System.out.println("4. �ֹ�����");
		System.out.println("5. �����޴�");
		System.out.println("�����ϼ���>>>");
	}
}

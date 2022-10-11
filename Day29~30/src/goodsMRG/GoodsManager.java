package goodsMRG;

import java.util.ArrayList;
import java.util.Scanner;

import dao_dto.G_DAO;
import dao_dto.G_DTO;

public class GoodsManager {
	G_DTO gdto = new G_DTO();
	G_DAO gdao = new G_DAO();
	Scanner in = new Scanner(System.in);

	public GoodsManager() {

		for (;;) {
			menu();
			System.out.println("�޴��� �������ּ��� ");
			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				addGoods();
			} else if (selMenu.equals("2")) {
				cntChk();
			} else if (selMenu.equals("3")) {
				modGoods();
			} else if (selMenu.equals("4")) {
				searchGoods();
			} else if (selMenu.equals("5")) {
				delGoods();
			} else if (selMenu.equals("6")) {
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}

	}

	private void modGoods() {

		System.out.println("������ ID�� �Է����ּ���. ");
		String modId = in.nextLine();
		if (!gdao.chkG(modId)) {
			gdto.setGid(modId);
			System.out.println("��ǰ���� �Է����ּ���. ");
			String modName = in.nextLine();
			System.out.println("������ �Է��ϼ���. ");
			int modPrice = in.nextInt();
			in.nextLine();
			System.out.println("������ �Է��ϼ���. ");
			int modCnt = in.nextInt();
			in.nextLine();
			System.out.println("�Ǹ��ڸ��� �Է����ּ���. ");
			String modSelName = in.nextLine();
			gdto.setGname(modName);
			gdto.setGprice(modPrice);
			gdto.setGcnt(modCnt);
			gdto.setSelName(modSelName);

			gdao.modyG(gdto);
			System.out.println(modId + "(��/��) �����Ǿ����ϴ�. ");
		} else {
			System.out.println(modId + "(��/��) �����ϴ�.");
		}
	}

	private void cntChk() {
		ArrayList<Goods> gList = gdao.cntCheck();
		System.out.println("��� ��� ���� ���� ��ǰ�� " + gList.size() + "�� �Դϴ�.");
		for (Goods i : gList) {
			i.prt();
		}
	}

	private void searchGoods() {
		System.out.println("�˻�� �Է����ּ���(ID,��ǰ��)");
		String search = in.nextLine();
		if (gdao.chkG(search)) {
			ArrayList<Goods> gList = gdao.schG(search);
			for (Goods i : gList) {
				i.prt();
			}
		} else {
			System.out.println(search + "(��/��) �����ϴ�.");
		}
	}

	private void delGoods() {
		System.out.println("������ ID�� �Է��ϼ���. ");
		String delId = in.nextLine();
		if (!gdao.chkG(delId)) {
			gdao.deleteG(delId);
			System.out.println(delId + "(��/��) �����Ǿ����ϴ�. ");
		} else {
			System.out.println(delId + "(��/��) �����ϴ�.");
		}
	}

	private void addGoods() {
		System.out.println("��ǰ�� ���̵� �Է��ϻ��� ");
		String newId = in.nextLine();
		if (gdao.chkG(newId)) {
			gdto.setGid(newId);
			System.out.println("��ǰ�� �̸��� �Է��ϼ���. ");
			String newName = in.nextLine();
			System.out.println("��ǰ�� ������ �Է��ϼ���. ");
			int newPrice = in.nextInt();
			in.nextLine();
			System.out.println("��ǰ�� ������ �Է��ϼ���. ");
			int newCnt = in.nextInt();
			in.nextLine();
			System.out.println("�Ǹ����� �̸��� �Է��ϼ���. ");
			String newSell = in.nextLine();
			gdto.setGname(newName);
			gdto.setGprice(newPrice);
			gdto.setGcnt(newCnt);
			gdto.setSelName(newSell);

			gdao.insertG(gdto);

			System.out.println(newId + "(��/��) �߰��Ǿ����ϴ�.");
		} else {
			System.out.println("�̹� ��ϵ� ���̵� �Դϴ�.");
		}

	}

	private void menu() {
		System.out.println("--------- ");
		System.out.println("1. ��ǰ��� ");
		System.out.println("2. ����м� ");
		System.out.println("3. ��ǰ���� ");
		System.out.println("4. ��ǰ�˻� ");
		System.out.println("5. ��ǰ���� ");
		System.out.println("6. �����޴� ");
	}
}

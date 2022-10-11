package shopping;

import java.util.ArrayList;
import java.util.Scanner;

import dao_dto.B_DAO;
import dao_dto.B_DTO;
import dao_dto.G_DAO;
import goodsMRG.Goods;

public class ShoppingManager {
	Scanner in = new Scanner(System.in);
	G_DAO gdao = new G_DAO();
	B_DAO bdao = new B_DAO();
	B_DTO bdto = new B_DTO();
	String id;

	ShoppingManager(String id) {
		this.id = id;
		for (;;) {
			menu();
			System.out.println("메뉴를 선택해주세요 ");
			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				shoppig();
			} else if (selMenu.equals("2")) {
				showBasket();
			} else if (selMenu.equals("3")) {
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	private void showBasket() {
		ArrayList<Basket> bList = bdao.showB(id);
		for (Basket i : bList) {
			i.prt();
		}

	}

	private void shoppig() {
		ArrayList<Goods> gList = gdao.allSelect();
		for (Goods i : gList) {
			i.prt();
		}
		System.out.println("구매할 상품의 ID를 입력하세요.");
		String selId = in.nextLine();
		System.out.println("구매할 상품의 수량을 입력하세요.");
		int selCnt = in.nextInt();
		in.nextLine();
		bdto.setId(id);
		bdto.setGid(selId);
		bdto.setBuyCnt(selCnt);

		bdao.insertB(bdto);

	}

	private void menu() {
		System.out.println("--------- ");
		System.out.println("1. 쇼핑하기 ");
		System.out.println("2. 장바구니 보기 ");
		System.out.println("3. 이전메뉴 ");
	}
}

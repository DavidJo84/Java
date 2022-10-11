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
			System.out.println("메뉴를 선택해주세요 ");
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
				System.out.println("잘못된 입력입니다.");
			}
		}

	}

	private void modGoods() {

		System.out.println("수정할 ID를 입력해주세요. ");
		String modId = in.nextLine();
		if (!gdao.chkG(modId)) {
			gdto.setGid(modId);
			System.out.println("상품명을 입력해주세요. ");
			String modName = in.nextLine();
			System.out.println("가격을 입력하세요. ");
			int modPrice = in.nextInt();
			in.nextLine();
			System.out.println("수량을 입력하세요. ");
			int modCnt = in.nextInt();
			in.nextLine();
			System.out.println("판매자명을 입력해주세요. ");
			String modSelName = in.nextLine();
			gdto.setGname(modName);
			gdto.setGprice(modPrice);
			gdto.setGcnt(modCnt);
			gdto.setSelName(modSelName);

			gdao.modyG(gdto);
			System.out.println(modId + "(이/가) 수정되었습니다. ");
		} else {
			System.out.println(modId + "(이/가) 없습니다.");
		}
	}

	private void cntChk() {
		ArrayList<Goods> gList = gdao.cntCheck();
		System.out.println("평균 재고량 보다 많은 상품은 " + gList.size() + "개 입니다.");
		for (Goods i : gList) {
			i.prt();
		}
	}

	private void searchGoods() {
		System.out.println("검색어를 입력해주세요(ID,상품명)");
		String search = in.nextLine();
		if (gdao.chkG(search)) {
			ArrayList<Goods> gList = gdao.schG(search);
			for (Goods i : gList) {
				i.prt();
			}
		} else {
			System.out.println(search + "(이/가) 없습니다.");
		}
	}

	private void delGoods() {
		System.out.println("삭제할 ID를 입력하세요. ");
		String delId = in.nextLine();
		if (!gdao.chkG(delId)) {
			gdao.deleteG(delId);
			System.out.println(delId + "(이/가) 삭제되었습니다. ");
		} else {
			System.out.println(delId + "(이/가) 없습니다.");
		}
	}

	private void addGoods() {
		System.out.println("상품의 아이디를 입력하새요 ");
		String newId = in.nextLine();
		if (gdao.chkG(newId)) {
			gdto.setGid(newId);
			System.out.println("상품의 이름을 입력하세요. ");
			String newName = in.nextLine();
			System.out.println("상품의 가격을 입력하세요. ");
			int newPrice = in.nextInt();
			in.nextLine();
			System.out.println("상품의 수량을 입력하세요. ");
			int newCnt = in.nextInt();
			in.nextLine();
			System.out.println("판매자의 이름을 입력하세요. ");
			String newSell = in.nextLine();
			gdto.setGname(newName);
			gdto.setGprice(newPrice);
			gdto.setGcnt(newCnt);
			gdto.setSelName(newSell);

			gdao.insertG(gdto);

			System.out.println(newId + "(이/가) 추가되었습니다.");
		} else {
			System.out.println("이미 등록된 아이디 입니다.");
		}

	}

	private void menu() {
		System.out.println("--------- ");
		System.out.println("1. 상품등록 ");
		System.out.println("2. 재고량분석 ");
		System.out.println("3. 상품수정 ");
		System.out.println("4. 상품검색 ");
		System.out.println("5. 상품삭제 ");
		System.out.println("6. 이전메뉴 ");
	}
}

package main;

import java.util.Scanner;

import goodsMRG.GoodsManager;
import memberMGR.MemberManager;
import shopping.Login;

public class MainMenu {
	Scanner in = new Scanner(System.in);
	
	MainMenu(){
		
		for(;;) {
			menu();
			System.out.println("메뉴를 선택해주세요 ");
			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				new MemberManager();
			} else if (selMenu.equals("2")) {
				new GoodsManager();
			} else if (selMenu.equals("3")) {
				new Login();
			} else if (selMenu.equals("4")) {
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	private void menu() {
		System.out.println("--------- ");
		System.out.println("1. 고객관리 ");
		System.out.println("2. 상품관리 ");
		System.out.println("3. 쇼핑하기 ");
		System.out.println("4. 프로그램종료 ");
	}
}

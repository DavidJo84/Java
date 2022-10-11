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
			System.out.println("�޴��� �������ּ��� ");
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
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}
	
	private void menu() {
		System.out.println("--------- ");
		System.out.println("1. ������ ");
		System.out.println("2. ��ǰ���� ");
		System.out.println("3. �����ϱ� ");
		System.out.println("4. ���α׷����� ");
	}
}

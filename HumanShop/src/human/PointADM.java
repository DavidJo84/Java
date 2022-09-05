package human;

import java.util.Scanner;

public class PointADM {// 클래스는 전역변수와 메서드로 정의
	String[] temp = new String[10];// 전역변수 선언

	PointADM() {// 메서드 생성자
		menu();
//		tempInput(); 
//		prt(); // prt 메서드 호출
	}

	public void menu() {
		for (;;) {
			System.out.println("1. 입력 ");
			System.out.println("2. 전체출력 ");
			System.out.println("3. 프로그램 종료 ");
			Scanner in = new Scanner(System.in);
			System.out.println("메뉴 선택");
			int a = in.nextInt();
			in.nextLine();
			if (a == 1) {
				tempInput();
			} else if (a == 2) {
				prt();
			} else if (a == 3) {
				System.out.println("프로그램 종료 ");
				break;
			}
		}
	}

	public void prt() {// 출력하는 기능을 수행하는 메서드. 호출이 없으면 메서드는 실행되지 않음.
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}
	}

	public void tempInput() {
		Scanner in = new Scanner(System.in);// ctrl + shift + o
		System.out.println("단어를 입력하세요.");
		String newWord = in.nextLine();
		//int a = in.nextInt();
		in.nextLine();

		for (int i = 0; i < temp.length; i++) {
			if(temp[i]==null) {
				temp[i] = newWord;
				break;
			}
		}
	}
}

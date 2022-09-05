package loveZoo;

import java.util.Scanner;

public class ZooADM {
	String[] temp = new String[10];// 전역변수 선언

	ZooADM() {// 메서드 생성자
		menu();
//		tempInput(); 
//		prt(); // prt 메서드 호출
	}

	public void menu() {
		for (;;) {
			System.out.println("----메뉴----");
			System.out.println("1. 입력 ");
			System.out.println("2. 출력 ");
			System.out.println("3. 삭제 ");
			System.out.println("4. 수정 ");
			System.out.println("5. 이름검색 ");
			System.out.println("6. 종료 ");
			System.out.println("1~6번까지 원하는 메뉴의 숫자를 입력하세요. ");
			Scanner in = new Scanner(System.in);
			int a = in.nextInt();
			in.nextLine();
			if (a == 1) {
				tempInput();
			} else if (a == 2) {
				prt();
			} else if (a == 3) {
				del();
			} else if (a == 4) {
				update();
			} else if (a == 5) {
				search();
			} else if (a == 6) {
				break;
			}
		}
	}

	public void prt() {// 출력하는 기능을 수행하는 메서드. 호출이 없으면 메서드는 실행되지 않음.
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null) {
				System.out.println(i + ":" + temp[i]);
			}
		}
	}

	public void tempInput() {
		Scanner in = new Scanner(System.in);// ctrl + shift + o
		System.out.println("동물이름을 입력하세요.");
		String newAni = in.nextLine();
		// int a = in.nextInt();

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == null) {
				temp[i] = newAni;
				break;
			}
		}
	}

	public void del() {
		Scanner in = new Scanner(System.in);
		System.out.println("삭제할 동물의 번호를 입력하세요.");
		int a = in.nextInt();
		in.nextLine();
		temp[a] = null;
	}

	public void update() {
		Scanner in = new Scanner(System.in);
		System.out.println("수정할 동물의 번호를 입력하세요.");
		int a = in.nextInt();
		in.nextLine();
		System.out.println("새로운 동물이름을 입력하세요.");
		String updateAni = in.nextLine();
		temp[a] = updateAni;
	}

	public void search() {

		Scanner in = new Scanner(System.in);
		System.out.println("검색할 동물이름을 입력하세요.");
		String searchAni = in.nextLine();
		int cnt=0;
		for (int i = 0; i < temp.length; i++) {
			if (searchAni.equals(temp[i])) {
				System.out.println(i + ":" + searchAni);
				cnt++;
				break;
			}
		}
		if(cnt==0) {
			System.out.println(searchAni+"(이/가) 없습니다.");
		}
	}
}

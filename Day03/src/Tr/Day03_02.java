package Tr;

import java.util.Scanner;

public class Day03_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 문제4. 오늘의 미세먼지 값이 67이다. 미세먼지 값이 0~30이면 좋음, 31~80이면 보통
		// 81~150이면 나쁨 151이상은 매우나쁨이라고 나타내는 프로그램을 만드세요
		int dust = 67;

		if (dust <= 30) {
			System.out.println("좋음");
		} else if (dust <= 80) {
			System.out.println("보통");
		} else if (dust <= 150) {
			System.out.println("나쁨");
		} else {
			System.out.println("매우나쁨");
		}

		// 메뉴를 입력받아 1번은 콜라,2번은 사이다,3번은 커피,4번은 쥬스를 출력
		// 콜라는 다시 종류를 입력받아 1번은 코크, 2번은 펩사 출력
		Scanner in = new Scanner(System.in); // ctrl+shift+o = 자동 import
		
		System.out.println("메뉴를 선택하세요");

		int menu = in.nextInt();

		System.out.println(menu + "번 입력했습니다.");

		if (menu == 1) {
			System.out.println("콜라의 종류를 선택하세요");

			int colaKind = in.nextInt();

			if (colaKind == 1) {
				System.out.println("코크");
			} else if (colaKind == 2) {
				System.out.println("펩사");
			}

		} else if (menu == 2) {
			System.out.println("사이다");
		} else if (menu == 3) {
			System.out.println("커피");
		} else if (menu == 4) {
			System.out.println("쥬스");
		}

		// 두 수 중 큰 수를 출력하세요

		int a = 30;
		int b = 40;

		if (a > b) {
			System.out.println(a);
		} else if (b > a) {
			System.out.println(b);
		}
		in.close();
	}

}

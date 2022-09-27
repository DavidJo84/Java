package Tr;

import java.util.Scanner;

public class Day21_02 {

	public static void main(String[] args) {
		System.out.println("압축할 문자열을 입력하세요 ");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String a = input.toUpperCase();
		in.close();
		String newA = "";
		int cnt = 0;

		for (int i = 0; i < a.length(); i++) {
			cnt = 0;
			for (int j = i; j < a.length(); j++) {
				if (a.charAt(i) != a.charAt(j)) {
					break;
				} else {
					cnt++;
				}
			}
			if (cnt > 1) {
				newA = newA + a.charAt(i) + cnt;
				i = i + cnt - 1;
			} else {
				newA = newA + a.charAt(i);
			}
		}
		System.out.println(newA);
	}
}

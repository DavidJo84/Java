package Tr;

import java.util.Scanner;

public class Day21_01 {

	public static void main(String[] args) {
		System.out.println("압축할 문자열을 입력하세요 ");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String a = input.toUpperCase();
		in.close();
		int cnt = 1;
		// 한 문자열 안에 연속적으로 중복되는 문자를 찾는 문제.
		// 기본적으로 문자열이 바로 이어지는 문자와 같을때마다
		// cnt값을 하나씩 더해주는 방향으로 생각하고 문제를 접근.
		for (int i = 0; i < a.length() - 1; i++) {
			// 마지막 문자열은 뒤의 문자가 없으므로 문자열의 길이 -1을 해
			if (a.charAt(i) == a.charAt(i + 1)) {
				// charAt을 사용하여 이어지는 문자열의 같고 다름을 비교
				// 앞 뒤의 문자가 같다면 cnt++을 해줌.
				cnt++;
			} else {// 앞 뒤의 문자가 다른 순간 중복된 문자가 끝났으므로
					// 그 시점의 cnt 값과 그 문자를 출력
					// 반복되지 않은 문자인 경우 반복된 횟수를 나타내면 안되므로
					// 조건문을 만들어 반복된 횟수가 1인 경우는 미출력
				if (cnt > 1) {
					System.out.print(a.charAt(i));
					System.out.print(cnt);
					cnt = 1;
				} else {
					System.out.print(a.charAt(i));
				}
			}
		}
		// for문을 돌고 난 후의 마지막 중복된 문자열과 그 횟수를 출력
		if (cnt > 1) {
			System.out.print(a.charAt(a.length() - 1));
			System.out.print(cnt);
		} else {
			System.out.print(a.charAt(a.length() - 1));
		}
	}
}

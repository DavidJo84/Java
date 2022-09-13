package Tr;

public class Day04_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[5];
		int[] b = { 44, 54, 23, 12, 45, 76 };
		// 문제1. a배열 모든 값에 숫자 10을 저장.

		for (int i = 0; i < a.length; i++) {
			a[i] = 10;
		}

		// 문제2. b배열의 모든 값을 1씩 증가.
		for (int i = 0; i < b.length; i++) {
			b[i]++;

		}

		// 문제3. b배열의 모든 값을 현재값에서 10을 더한 후 출력(단 배열의 값은 변경되지 않음)
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i] + 10);
		}

		// 문제4. b배열의 모든 값을 현재 값에서 20을 더한 후 출력(배열은 갱신된 값을 저장)
		for (int i = 0; i < b.length; i++) {
			b[i] += 20;
			System.out.println(b[i]);
		}

		// 문제5. b배열의 모든 값을 출력하되, 짝수면 짝수, 홀수면 홀수라고 출력
		for (int i = 0; i < b.length; i++) {
			if (b[i] % 2 == 0) {
				System.out.println(b[i] + " 짝수");
			} else {
				System.out.println(b[i] + " 홀수");
			}
		}

	}

}

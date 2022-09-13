package Tr;

public class Day03_03 {

	public static void main(String[] args) {
		// 다음 결과값을 예측하라.
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			i++;
		} // 1,3,5,7,9

		for (int i = 1; i <= 10; i++) {
			++i;
			System.out.println(i);
		} // 2,4,6,8,10

		// 다음 배열을 출력하는 for문

		String[] word = { "가", "나", "다", "라" };

		for (int i = 0; i <= 3; i++) {
			System.out.println(word[i]);
		}

		// 다음 결과를 예측하시오
		for (int i = 0; i <= 3; i++) {
			System.out.println(word[i++]);
		} // 가,다

		// 모든 포인트를 출력하세요, 출력형식은 23/45/22/34/67/
		int[] point = { 23, 45, 22, 34, 67 };

		for (int i = 0; i <= 4; i++) {
			System.out.print(point[i] + "/");
		}
		System.out.println();

		// 배열의 값이 짝수인것만 출력
		for (int i = 0; i <= 4; i++) {
			if (point[i] % 2 == 0) {
				System.out.print(point[i] + ",");
			}
		}
		System.out.println();
		
	}

}

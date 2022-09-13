package Tr;

public class Day03_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 문제1. 점수가 90이상인 사람은 축하, 90미만은 감사라고 출력
		int score = 76;

		if (score >= 90) {
			System.out.println("축하");
		} else {
			System.out.println("감사");
		}
		// 문제2. 점수가 60이상 80이하인 사람은 잘했어요라고 출력

		if (60 <= score && score <= 80) {
			System.out.println("잘했어요");
		}

		// 문제2-1. 점수가 60이상 80이하인 사람은 잘했어요라고 출력(&&연산자 쓰지 않고)
		if (60 <= score) {
			if (score <= 80) {
				System.out.println("잘했어요");
			}

		}
		// 문제3. 현재 점수의 30을 더한 값이 100을 넘으면 그 점수를 100으로 저장하고
		// 그렇지 않으면 현 점수에 30을 더하여 저장한다.

		if (score + 30 > 100) {
			score = 100;
		} else {
			score += 30;
		}

	}

}

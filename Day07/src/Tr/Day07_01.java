package Tr;

public class Day07_01 {

	public static void main(String[] args) {

		System.out.println("------1------");
//		1
//		가장 높은 점수를 획득한 사람의 점수와 이름을 출력하시오
		int[] point = { 20, 32, 12, 34, 24, 23 };
		String[] name = { "kim", "lee", "part", "chol", "choo", "ryu" };
		int max = 0;
		int nameIdx = 0;
		for (int i = 0; i < point.length; i++) {
			if (point[i] > max) {
				max = point[i];
				nameIdx = i;
			}
		}
		System.out.println(name[nameIdx] + ":" + max + "점");

//
		System.out.println("------2------");
//		2
//		위 문제에서
//		점수가 높으면 1등이다
//		1등부터 3등까지의 점수와 이름을 출력하시오.
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < point.length; i++) {
				if (point[i] > max) {
					max = point[i];
					nameIdx = i;
				}
			}
			System.out.println(j + 1 + "등-" + name[nameIdx] + ":" + max + "점");
			point[nameIdx] = -1;
			max = 0;
		}
//		
		System.out.println("------3------");
//		3
		int[] a = { 10, 0, 0, 30, 45, 0, 0, 60, 0, 0, 0, 0, 56, 0, 0, 0, 45 };
//		배열에서 0은 빈 땅이다. 이곳에 건물을 지으려고 한다.
//		0이 연속된 만큼을 땅의 크기라고 가정하자.
//		예를 들어 0이 3개 연속이라면 땅 크기는 3이다
//		땅의 크기가 3이상인 곳의 배열의 시작 인덱스를 출력하시오.
		for (int i = 0; i < a.length; i++) {
			int cnt = 0;// 연속적인 0의 갯수를 카운트할 변수 선언
			if (a[i] == 0) {
				cnt++;// 0을 만나면 바로 하나 증가
				for (int j = i + 1; j < a.length; j++) {
					if (a[j] == 0) {
						cnt++;// 0뒤에 0이 연속으로 나올때마다 하나씩 더 카운트
					} else {
						break;
					}
				}
				if (cnt >= 3) {
					System.out.print(i + "번 ");
				}
				i = i + cnt - 1;
			}
		}
		System.out.println();
//
		System.out.println("------4------");
//		4
//		0은 빈땅이다. 가장큰 빈땅의 크기와 시작인덱스를 출력하시오.

		int max1 = 0;
		int idx = 0;
		for (int i = 0; i < a.length; i++) {
			int cnt = 0;// 연속적인 0의 갯수를 카운트할 변수 선언
			if (a[i] == 0) {
				cnt++;// 0을 만나면 바로 하나 증가
				for (int j = i + 1; j < a.length; j++) {
					if (a[j] == 0) {
						cnt++;// 0뒤에 0이 연속으로 나올때마다 하나씩 더 카운트
					} else {
						break;
					}
				}
				if (cnt > max1) {
					max1 = cnt;
					idx = i;
				}
				i = i + cnt-1;
			}
		}
		System.out.println("가장 큰 땅 크기: " + max1);
		System.out.println("시작 인덱스: " + idx);
//
		System.out.println("------5------");
//		5
		int[] a1 = { 10, 10, 0, 30, 45, 0, 0, 60, 60, 0, 0, 0, 56, 56, 56, 0, 45 };
//		숫자는 건물의 번호이고, 0은 빈땅이다.
//		건물의 번호가 같은 것은 건물의 크기가 1보다 크다는 것이다.
//		만약 10이 연속 2개 있다면 건물의 크기가 2라는 의미이다.
//		사이즈가 2이상인 건물의 번호와 크기를 모두 출력하시오

		int bSize = 1;
		for (int i = 0; i < a1.length; i++) {
			int cnt2 = 0;// 연속적인 숫자의 갯수를 카운트
			if (a1[i] != 0) {
				cnt2++;// 0이 아닌수를 만나면 바로 하나 증가
				for (int j = i + 1; j < a1.length; j++) {
					if (a1[j] == a1[i]) {
						cnt2++;// 앞의 수 뒤에 같은수가 연속으로 나올때마다 하나씩 더 카운트
					} else {
						break;
					}
				}
				if (cnt2 >= bSize) {
					System.out.println("건물번호:" + a1[i] + ", 건물크기:" + cnt2);
				}
				i = i + cnt2 - 1;// 중복되는 수만큼 건너뛰기
			}
		}
	}
}

package Test;

public class Day04_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//	   1.배열의 모든 값에 10을 입력하세요.
		int[] a = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = 10;
		}

//
//	   2. 배열의 모든 값을 출력하시오.
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("--------------------------");
//	   3. 배열의 값에 0 1 2 3 4 5 6 7 8 9 를 입력하고 출력하시오.
//	   (단 for문 2개로 해결하시고, for문 2개는 다음과 같습니다)
//		입력하는 for, 출력하는 for
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("--------------------------");
//	   4. 배열의 값에 9 8 7 6 5 4 3 2 1 0 을 입력하고 출력하시오 . for문 2개
		for (int i = 0; i < a.length; i++) {
			a[i] = (a.length - 1) - i;
		}

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("--------------------------");

//	   5. 값이 짝수인 경우 값을 출력하시오.
		int[] b = { 23, 45, 23, 56, 75, 56 };
		for (int i = 0; i < b.length; i++) {
			if (b[i] % 2 == 0) {
				System.out.println(b[i]);
			}
		}
		System.out.println("--------------------------");
//	   6. 값이 짝수인 경우 짝수 값은 갖는 인덱스를 출력하시오.
		for (int i = 0; i < b.length; i++) {
			if (b[i] % 2 == 0) {
				System.out.println(i);
			}
		}
//	   
		System.out.println("--------------------------");
//	   7. 최고 값을 갖고 있는 인덱스 번호를 출력하시오.
		int max = 0;
		int idxNo = 0;
		for (int i = 0; i < b.length; i++) {
			if (max < b[i]) {
				max = b[i];
				idxNo = i;
			}
		}
		System.out.println(idxNo);
		System.out.println("--------------------------");
//
//	   8. 모든 값을 1씩 증가시키시오.
		for (int i = 0; i < b.length; i++) {
			b[i]++;
		}

//	   9. 빈칸을 0이라고 가정한다. 빈칸의 값을 가진 인덱스 번호를 출력하세요.
		int[] b2 = { 23, 45, 0, 58, 75, 0 };
		for (int i = 0; i < b2.length; i++) {
			if (b2[i] == 0) {
				System.out.println(i);
			}
		}
		System.out.println("--------------------------");
//
//	   10. 다음조건에 따라 오름차순으로 저장되게 정렬하시오.
//		   1. 가장큰 값을 찾아서 맨뒤 값에 저장한다.
//		   2. 두번째로 큰 값을 찾아서 맨뒤에서 두번째 자리에 저장한다.
//		   정렬이 될때 까지 반복한다.
		int[] b3 = { 93, 45, 23, 58, 75, 56 };
		int min1 = 0;
		int max1 = 0;
		for (int i = 0; i < b3.length; i++) {
			for (int k = 0, j = 1; j < b3.length; j++, k++) {
				if (b3[k] > b3[j]) {
					max1 = b3[k];
					min1 = b3[j];
					b3[k] = min1;
					b3[j] = max1;
				}
			}

		}
		for (int i = 0; i < b3.length; i++) {
			System.out.println(b3[i]);
		}
		System.out.println("--------------------------");
		int k = 0;
		for (int j = 1; j < b3.length; j++) {

			if (b3[k] > b3[j]) {
				max1 = b3[k];
				min1 = b3[j];
				b3[k] = min1;
				b3[j] = max1;

			}
			k++;
		}
		int k1 = 0;
		for (int j = 1; j < b3.length; j++) {

			if (b3[k1] > b3[j]) {
				max1 = b3[k1];
				min1 = b3[j];
				b3[k1] = min1;
				b3[j] = max1;

			}
			k1++;
		}
		int k2 = 0;
		for (int j = 1; j < b3.length; j++) {

			if (b3[k2] > b3[j]) {
				max1 = b3[k2];
				min1 = b3[j];
				b3[k2] = min1;
				b3[j] = max1;

			}
			k2++;
		}
		int k3 = 0;
		for (int j = 1; j < b3.length; j++) {

			if (b3[k3] > b3[j]) {
				max1 = b3[k3];
				min1 = b3[j];
				b3[k3] = min1;
				b3[j] = max1;

			}
			k3++;
		}
		int k4 = 0;
		for (int j = 1; j < b3.length; j++) {

			if (b3[k4] > b3[j]) {
				max1 = b3[k4];
				min1 = b3[j];
				b3[k4] = min1;
				b3[j] = max1;

			}
			k4++;
		}
		int k5 = 0;
		for (int j = 1; j < b3.length; j++) {

			if (b3[k5] > b3[j]) {
				max1 = b3[k5];
				min1 = b3[j];
				b3[k5] = min1;
				b3[j] = max1;

			}
			k5++;
		}

		for (int i = 0; i < b3.length; i++) {
			System.out.println(b3[i]);
		}
		System.out.println("--------------------------");
//
//	   11. carnum배열의 인덱스가 0부터 주차장에 들어온다.
//	      parking의 인덱스 번호가 주차번호이다. 
//	      자동차 번호의 마지막 번호는 해당 차량이 주차할 주차번호이다.
//	      만약 주차번호에 다른 차량이 주차되어 있으면 다음 주차번호에 주차를 한다.9번 다음은 0
//	      (이때, 다음 주차번호에도 차량이 있으면 주차불가이다. 예제는 이와 같은 상황이 안 나오므로 고려하지
//	      않아도됨)
//
//	      주차가 끝난 후 주차번호와 주차항 차량 번호를 출력하시오.
		int[] carnum = { 1232, 1221, 1235, 1252, 1234, 4536, 3457, 3238, 3229, 2599 };
		int[] parking = new int[10];
		for (int i = 0; i < carnum.length; i++) {
			if (parking[carnum[i] % 10] == 0) {
				parking[carnum[i] % 10] = carnum[i];

			} else {
				parking[(carnum[i] % 10 + 1) % 10] = carnum[i];

			}

		}
		System.out.println("--------------------------");
		for (int i = 0; i < parking.length; i++) {
			System.out.println(i + ":" + parking[i]);

		}

	}

}

package Test;

public class Day04_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//	   1.�迭�� ��� ���� 10�� �Է��ϼ���.
		int[] a = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = 10;
		}

//
//	   2. �迭�� ��� ���� ����Ͻÿ�.
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("--------------------------");
//	   3. �迭�� ���� 0 1 2 3 4 5 6 7 8 9 �� �Է��ϰ� ����Ͻÿ�.
//	   (�� for�� 2���� �ذ��Ͻð�, for�� 2���� ������ �����ϴ�)
//		�Է��ϴ� for, ����ϴ� for
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("--------------------------");
//	   4. �迭�� ���� 9 8 7 6 5 4 3 2 1 0 �� �Է��ϰ� ����Ͻÿ� . for�� 2��
		for (int i = 0; i < a.length; i++) {
			a[i] = (a.length - 1) - i;
		}

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("--------------------------");

//	   5. ���� ¦���� ��� ���� ����Ͻÿ�.
		int[] b = { 23, 45, 23, 56, 75, 56 };
		for (int i = 0; i < b.length; i++) {
			if (b[i] % 2 == 0) {
				System.out.println(b[i]);
			}
		}
		System.out.println("--------------------------");
//	   6. ���� ¦���� ��� ¦�� ���� ���� �ε����� ����Ͻÿ�.
		for (int i = 0; i < b.length; i++) {
			if (b[i] % 2 == 0) {
				System.out.println(i);
			}
		}
//	   
		System.out.println("--------------------------");
//	   7. �ְ� ���� ���� �ִ� �ε��� ��ȣ�� ����Ͻÿ�.
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
//	   8. ��� ���� 1�� ������Ű�ÿ�.
		for (int i = 0; i < b.length; i++) {
			b[i]++;
		}

//	   9. ��ĭ�� 0�̶�� �����Ѵ�. ��ĭ�� ���� ���� �ε��� ��ȣ�� ����ϼ���.
		int[] b2 = { 23, 45, 0, 58, 75, 0 };
		for (int i = 0; i < b2.length; i++) {
			if (b2[i] == 0) {
				System.out.println(i);
			}
		}
		System.out.println("--------------------------");
//
//	   10. �������ǿ� ���� ������������ ����ǰ� �����Ͻÿ�.
//		   1. ����ū ���� ã�Ƽ� �ǵ� ���� �����Ѵ�.
//		   2. �ι�°�� ū ���� ã�Ƽ� �ǵڿ��� �ι�° �ڸ��� �����Ѵ�.
//		   ������ �ɶ� ���� �ݺ��Ѵ�.
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
//	   11. carnum�迭�� �ε����� 0���� �����忡 ���´�.
//	      parking�� �ε��� ��ȣ�� ������ȣ�̴�. 
//	      �ڵ��� ��ȣ�� ������ ��ȣ�� �ش� ������ ������ ������ȣ�̴�.
//	      ���� ������ȣ�� �ٸ� ������ �����Ǿ� ������ ���� ������ȣ�� ������ �Ѵ�.9�� ������ 0
//	      (�̶�, ���� ������ȣ���� ������ ������ �����Ұ��̴�. ������ �̿� ���� ��Ȳ�� �� �����Ƿ� �������
//	      �ʾƵ���)
//
//	      ������ ���� �� ������ȣ�� ������ ���� ��ȣ�� ����Ͻÿ�.
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

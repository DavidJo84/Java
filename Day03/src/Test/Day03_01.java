package Test;

public class Day03_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		���� �ǽ�
//
//		���糪, �ʱ�� ã�Ƶ� �˴ϴ�
//		�˻��� ���� �����!!!
//
//		1. �����ڵ��� ��°��� ���ڵ��Ͻÿ�
//		int a=40;
//		if(a > 50 || a >100){
//		   sysout("ok");
//		}//��°� ����
//
//		2. �����ڵ��� ��°��� ���ڵ��Ͻÿ�
//		int a=40;
//		if(a%2==0){
//		   sysout("¦��");
//		}else{
//		   sysout("Ȧ��");
//		}//¦��
//
//		3. �����ڵ��� ��°��� ���ڵ��Ͻÿ�
//		for(int i=2;i<6;i++) {  
//		   System.out.println(i);
//		}// 2,3,4,5
//
//		4.�����ڵ��� ��°��� ���ڵ��Ͻÿ�
//		int sum=0;
//		for(int i=0;i<4;i++) {  
//		   sum += i;
//		}
//		sysout(sum);//6
//
//		5. �����ڵ��� ��°��� ���ڵ��Ͻÿ�
//		for(int i=0; i<10; i++){
//		   System.out.print(i+"/");
//		}0/1/2/3/4/5/6/7/8/9/
//
//		6. �����ڵ��� ��°��� ���ڵ��Ͻÿ�
//		int[] point = {23,45,22,34,67};
//		for(int i=0; i<5; i++){
//		   System.out.prinln(point[4-i]);
//		}67,34,22,45,23
//
//		7.�����ڵ��� ��°��� ���ڵ��Ͻÿ�
//		int[] point = {23,45,22,34,67};
//		int sum=0;
//		for(int i=0; i<5; i++){
//		   if(point[i]>10){
//		      sum+=point[i];
//		   }
//		}
//		sysout(sum);//191
//
//		----------------------  ����  ------------------------------
//		8.��� �迭�� ���� ���� ���� ����Ͻÿ�.
		int[] point = { 23, 45, 22, 34, 67, 38 };
		int sum = 0;
		for (int i = 0; i <= 5; i++) {
			sum += point[i];
		}
		System.out.println(sum);
//
//		9. �迭�� ���� Ȧ���� ��츸 ���� ���� ����Ͻÿ�.
		int sum1 = 0;
		for (int i = 0; i <= 5; i++) {
			if (point[i] % 2 == 1) {
				sum1 += point[i];
			}

		}
		System.out.println(sum1);
//		
//		10.�迭���� ���� ū ���� ã������. 
		int max = 0;
		for (int i = 0; i <= 5; i++) {
			if (max < point[i]) {
				max = point[i];
			}
		}
		System.out.println("�ִ밪�� "+max);
//		
//		11. �迭����  30���� ū ���� ��� ��ΰ���?
//		int[] point = {23,45,22,34,67,38};
		int count = 0;
		for (int i = 0; i <= 5; i++) {
			if (point[i] > 30) {
				count++;
			}
		}
		System.out.println(count + "��");
//
//		12. ������ ���� ����Ͻÿ�.
//		1+2+3+4+5+6+7+8+9+10=���Ѱ����
		int sum2 = 0;
		for (int i = 1; i <= 10; i++) {
			if (i <= 9) {
				sum2 += i;
				System.out.print(i + "+");
			} else {
				System.out.print(i + "=");
				sum2 += i;
			}
		}
		System.out.println(sum2);
//
//		13. 1���� 100������ Ȧ���� Ȧ������, ¦���� ¦������ �� �� ���� ��������Ͻÿ�.
		int evenSum = 0;
		int oddSum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				evenSum += i;
			} else {
				oddSum += i;
			}
		}
		System.out.println("¦���� ��: " + evenSum);
		System.out.println("Ȧ���� ��: " + oddSum);

//		14. ����ã��
//		���ڴ� 0���� 100���� �ϳ��� �����ϸ� �� ���ڴ� ���Ͽ� �����Ѵ�.
//		���� ���� 70�� �Ѿ�� �ϴ� ���ڰ� �ٷ� �����̴�. ���� ���ڸ� ����Ͻÿ�.
//		�������,  ���� ���� 64�϶� 10�� ���ϸ� 74�� �ȴ�. �̶� 10�̹��� ���ڰ� �ȴ�.
//		��, �츮�� ��� �����θ� �ذ��մϴ�.
		int sum3 = 0;
		for (int i = 0; i <= 100; i++) {
			sum3 += i;
			if (sum3 > 70) {
				System.out.println("������ "+i);
				i += 100;
			}
		}

//		15. �Ǻ���ġ ������ ���� ���Ͻÿ�. 
//		   �Ǻ���ġ ���� 20 ���ϱ��� ���Ͻø� �˴ϴ�.
//		   �Ǻ���ġ ������ ��Ģ�� 0�� 1�� �������� �ΰ��� ���� ���� ���� ���� �˴ϴ�. 
//		   0+1+1+2+3+5+8+13 = ����

		// �迭���
		int[] pibo = new int[8];

		for (int i = 0; i <= pibo.length - 1; i++) {
			if (i <= 1) {
				pibo[i] = i;
				System.out.print(pibo[i] + "+");
			} else {
				if (i < pibo.length - 1) {
					pibo[i] = pibo[i - 2] + pibo[i - 1];
					System.out.print(pibo[i] + "+");
				} else {
					pibo[i] = pibo[i - 2] + pibo[i - 1];
					System.out.print(pibo[i] + "=");
				}

			}
		}
		int sum4 = 0;
		for (int i = 0; i <= pibo.length - 1; i++) {
			sum4 += pibo[i];
		}

		System.out.println(sum4);

		// �迭������� �ʰ�
		int c = 1;// 2 3
		int d = 0; // 2 3
		int sum5 = 0;
		System.out.print(0 + "+");
		System.out.print(1 + "+");

		for (int b = 0; b + c <= 20;) {
			d = b + c;
			b = c;
			c = d;
			sum5 += d;
			if (b + c <= 20) {
				System.out.print(d + "+");
			} else {
				System.out.print(d + "=");
			}

		}

		System.out.println(0 + 1 + sum5);

	}

}

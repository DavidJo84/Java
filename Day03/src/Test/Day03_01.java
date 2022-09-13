package Test;

public class Day03_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		오후 실습
//
//		교재나, 필기는 찾아도 됩니다
//		검색은 절대 노노노노!!!
//
//		1. 다음코드의 출력값을 손코딩하시오
//		int a=40;
//		if(a > 50 || a >100){
//		   sysout("ok");
//		}//출력값 없음
//
//		2. 다음코드의 출력값을 손코딩하시오
//		int a=40;
//		if(a%2==0){
//		   sysout("짝수");
//		}else{
//		   sysout("홀수");
//		}//짝수
//
//		3. 다음코드의 출력값을 손코딩하시오
//		for(int i=2;i<6;i++) {  
//		   System.out.println(i);
//		}// 2,3,4,5
//
//		4.다음코드의 출력값을 손코딩하시오
//		int sum=0;
//		for(int i=0;i<4;i++) {  
//		   sum += i;
//		}
//		sysout(sum);//6
//
//		5. 다음코드의 출력값을 손코딩하시오
//		for(int i=0; i<10; i++){
//		   System.out.print(i+"/");
//		}0/1/2/3/4/5/6/7/8/9/
//
//		6. 다음코드의 출력값을 손코딩하시오
//		int[] point = {23,45,22,34,67};
//		for(int i=0; i<5; i++){
//		   System.out.prinln(point[4-i]);
//		}67,34,22,45,23
//
//		7.다음코드의 출력값을 손코딩하시오
//		int[] point = {23,45,22,34,67};
//		int sum=0;
//		for(int i=0; i<5; i++){
//		   if(point[i]>10){
//		      sum+=point[i];
//		   }
//		}
//		sysout(sum);//191
//
//		----------------------  업글  ------------------------------
//		8.모든 배열의 값을 합한 값을 출력하시오.
		int[] point = { 23, 45, 22, 34, 67, 38 };
		int sum = 0;
		for (int i = 0; i <= 5; i++) {
			sum += point[i];
		}
		System.out.println(sum);
//
//		9. 배열의 값이 홀수인 경우만 합한 값을 출력하시오.
		int sum1 = 0;
		for (int i = 0; i <= 5; i++) {
			if (point[i] % 2 == 1) {
				sum1 += point[i];
			}

		}
		System.out.println(sum1);
//		
//		10.배열에서 가장 큰 값을 찾으세요. 
		int max = 0;
		for (int i = 0; i <= 5; i++) {
			if (max < point[i]) {
				max = point[i];
			}
		}
		System.out.println("최대값은 "+max);
//		
//		11. 배열에서  30보다 큰 값은 모두 몇개인가요?
//		int[] point = {23,45,22,34,67,38};
		int count = 0;
		for (int i = 0; i <= 5; i++) {
			if (point[i] > 30) {
				count++;
			}
		}
		System.out.println(count + "개");
//
//		12. 다음과 같이 출력하시오.
//		1+2+3+4+5+6+7+8+9+10=합한결과값
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
//		13. 1부터 100숫자중 홀수는 홀수끼리, 짝수는 짝수끼리 더 한 값을 각각출력하시오.
		int evenSum = 0;
		int oddSum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				evenSum += i;
			} else {
				oddSum += i;
			}
		}
		System.out.println("짝수의 합: " + evenSum);
		System.out.println("홀수의 합: " + oddSum);

//		14. 범인찾기
//		숫자는 0부터 100까지 하나씩 증가하며 그 숫자는 더하여 저장한다.
//		합한 값이 70을 넘어가게 하는 숫자가 바로 범인이다. 범인 숫자를 출력하시오.
//		예를들어,  합한 값이 64일때 10을 더하면 74가 된다. 이때 10이범인 숫자가 된다.
//		단, 우리가 배운 것으로만 해결합니다.
		int sum3 = 0;
		for (int i = 0; i <= 100; i++) {
			sum3 += i;
			if (sum3 > 70) {
				System.out.println("범인은 "+i);
				i += 100;
			}
		}

//		15. 피보나치 수열의 합을 구하시오. 
//		   피보나치 수는 20 이하까지 합하시면 됩니다.
//		   피보나치 수열의 규칙은 0과 1을 시작으로 두개씩 더한 값이 다음 값이 됩니다. 
//		   0+1+1+2+3+5+8+13 = 총합

		// 배열사용
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

		// 배열사용하지 않고
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

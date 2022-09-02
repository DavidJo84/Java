package Test;

public class Day06_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		1. 다음과 같이 출력하세요
//		0000*
//		000**
//		00***
//		0****
		System.out.println("--------1--------");
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 5 - i; j++) {
				System.out.print("0");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

//
//		2. 다음과 같이 출력하세요
//		*
//		**
//		***
//		****
		System.out.println("--------2--------");
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
//
//		3. 홀수의 합을 구하시오
		System.out.println("--------3--------");
		int[] a = { 10, 23, 23, 25, 10, 4 };

		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 1) {
				sum += a[i];
			}
		}
		System.out.println(sum);
//
//		4. 짝수는 모두 몇개인가?
		System.out.println("--------4--------");
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				cnt++;
			}
		}
		System.out.println(cnt);

// 		5. 랜덤숫자 1-15까지 뽑아서 짝수인 숫자만 저장하세요
		System.out.println("--------5--------");
		int[] b = new int[5];
		for (int i = 0; i < b.length; i++) {
			int even = (int) (Math.random() * 15 + 1);// 1~15까지
			if (even % 2 == 0) {

				b[i] = even;

			} else {
				i--;
			}
		}
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();

//
//
//		6.로또번호를 저장하세요. 중복가능
//		출력형태는 23/44/21/25/23/1+78
		System.out.println("--------6--------");
		int[] rotto = new int[7];
		for (int i = 0; i < rotto.length; i++) {
			rotto[i] = (int) (Math.random() * 45 + 1);// 1~45까지
		}
		for (int i = 0; i < rotto.length; i++) {
			if (i < rotto.length - 2) {
				System.out.print(rotto[i] + "/");

			} else if (i == rotto.length - 2) {
				System.out.print(rotto[i] + "+");

			} else {
				System.out.print(rotto[i]);

			}
		}
		System.out.println();
//
//		7.로또 번호를 저장하세요. 중복 불가능
//		출력행태는 23/44/21/25/23/1+78 

		System.out.println("--------7--------");
		int[] rotto1 = new int[7];
		for (int i = 0; i < rotto1.length; i++) {
			rotto1[i] = (int) (Math.random() * 45 + 1);// 1~45까지
			for (int j = 0; j < i; j++) {
				if (rotto1[j] == rotto1[i]) {
					i--;
				}
			}
		}
		for (int i = 0; i < rotto1.length; i++) {
			if (i < rotto1.length - 2) {
				System.out.print(rotto1[i] + "/");

			} else if (i == rotto.length - 2) {
				System.out.print(rotto1[i] + "+");

			} else {
				System.out.print(rotto1[i]);

			}
		}
		System.out.println();
//
//		8. 1번부터 45번 숫자를 랜덤으로 1000번 뽑는다.
//		가장 많이 나온 숫자 7개를 출력한다. 
//		<가장 많이 나온숫자가 여러번일경우는 작은 숫자가 우선한다>
		System.out.println("--------8--------");
		int[] c = new int[46];
		for (int i = 0; i < 1000; i++) {

			c[(int) (Math.random() * 45 + 1)] += 1;

		}
//		for (int i = 1; i < c.length; i++) { //확인용 출력 
//			System.out.println(i + ": " + c[i]);
//		}
		for (int j = 0; j < 7; j++) {
			int maxIndex = 0;
			for (int i = 1; i < c.length; i++) {
				if (c[i] > c[maxIndex]) {
					maxIndex = i;
				}
			}
			System.out.println("로또번호: " + maxIndex + ", 횟수: " + c[maxIndex]);
			c[maxIndex] = -1;
		}

//
//		9.무작위로 비밀번호 4자리를 만드려고 한다.
// 		passInt 배열에서 랜던한 값 4개를 뽑아서 mypass를 완성한다.
		System.out.println("--------9--------");
		int[] passInt = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		String mypass = "";
		for (int i = 1; i <= 4; i++) {
			mypass += passInt[(int) (Math.random() * passInt.length)]; // int가 String으로 자동 형변환됨
		}
		System.out.println(mypass);
//

//
//
//		[10번, 11번]______________________________________
		System.out.println("--------10--------");
		int[] a1 = { 10, 20, 0, 30, 45, 0, 0, 60, 0, 0, 0, 56 };
//		위 배열은 토지 위에 건물을 나타낸 것이다. 숫자는 층(높이)이다
//		값이 0 인 경우는 빈자리이며 건물을 지을 수 있다
//		인덱스는 0부터 시작된다. 위 배열의 값은 바뀔 수 있다.
//
//		10. [배열] 빈자리는 모두 몇 개인가?  
		int cnt1 = 0;
		for (int i = 0; i < a1.length; i++) {
			if (a1[i] == 0) {
				cnt1++;
			}
		}
		System.out.println(cnt1);

//		11. 배열의 값 중 0이 하나 있으면 사이즈1, 0이 연속 2개 있으면 사이즈 2이다.   
//		사이즈2짜리 건물을 세우려고 한다. 사이즈는 연속된 빈자리의 최대 범위이다.(사이즈가 2 이상은 건물 지을 수 있)
//		건물을 세울 수 있는 공간은 몇 개인가? 
//       사이즈는 배열의 크기를 벗어 나지 않은 범위에서 어떤 숫자를 넣어도
//       건물을 세울 수 있는 공간이 나와야 한다.
		System.out.println("--------11--------");
		int bSize =2;
		int bPoint=0;
		for(int i=0;i<a1.length;i++) {
			int cnt2=0;//연속적인 0의 갯수를 카운트 
			if(a1[i]==0) {
				cnt2++;//0을 만나면 바로 하나 증가 
				for(int j=i+1; j< a1.length; j++) {
					if(a1[j]==0) {
						cnt2++;//0뒤에 0이 연속으로 나올때마다 하나씩 더 카운트 
					}else {
						break;
					}
				}
				System.out.println(cnt2);
				if(cnt2>=bSize) {

					//건물 사이즈와 0의 연속 갯수에 따라 건물 지을 수 있는 곳 판별 
					//bPoint=bPoint+(cnt2/bSize);

					//0의 연속 갯수와는 상관없이 건물 사이즈를 지을 수 있는 곳만 찾음.
					bPoint++;
				}
				i=i+cnt2-1;
			}
		}
		System.out.println("건물을 지을 수 있는 곳은 "+bPoint+"곳 입니다");

//
//	
//		12.for문을 사용하여 배열의 값을 한칸씩 뒤로 이동시키시오 맨 끝자리를 처음 자리로 이동

		System.out.println("--------12--------");
		int[] a3 = { 10, 23, 23, 25, 10, 4 };
		int tamp = 0;
		for (int i = a3.length - 1; i >= 0; i--) {
			if (i == a3.length - 1) {
				tamp = a3[i];
			} else {
				a3[i + 1] = a3[i];
			}
		}
		a3[a3.length - a3.length] = tamp;
		for (int i = 0; i < a3.length; i++) {
			System.out.println(a3[i]);
		}
	}

}

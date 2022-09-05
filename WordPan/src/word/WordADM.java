package word;

public class WordADM {
	// 점수를 저장하는 배열. 인덱스 차례대로 java,mysql,oracl,html 점수를 저장.
	int[] point = new int[4];// 전역변수 : 클래스 영역에서 모두 접근 가능

	WordADM() {
		// 시나리오
		// 1. java,mysql,oracle,html 점수를 입력
		// 2. 모두출력한다.
		// 3. mysql 점수를 10점 더한다.
		// 4. 모두 출력한다.
		point[0] = 80;
		point[1] = 90;
		point[2] = 78;
		point[3] = 100;
		prt();

		point[1] += 10;
		prt();

	}

//	함수 생성방법 
//	public void 함수명(매개변수정의) {
//		구현 
//	}
	public void prt() {//함수정의 
		for (int i = 0; i < point.length; i++) {
			System.out.println(point[i]);
		}
	}
}

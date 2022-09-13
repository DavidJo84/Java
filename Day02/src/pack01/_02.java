package pack01;

public class _02 {

	public static void main(String[] args) {
		// 배열
		// 인덱스와 벨류
		// index 는 0부터 시작

		int[] point = new int[5]; // new는 암기, 앞에 int[]: int를 저장하는 자료형을 선언
									// point 는 변수명
									// 뒤에 int[5]: 5개의 int를 저장할 수 있는 공간(배열의 크기)
									// index 는 0~4까지 생성
		point[0] = 80; // point 배열 (index) 0번 value에 80을 저장
		point[1] = 90; // point 배열 (index) 1번 value에 90을 저장
		point[2] = 92;
		point[3] = 88;
		point[4] = 98;

		String[] partName = { "java", "mysql", "oracle", "html", "css" };

		System.out.println(partName[0] + ":" + point[0]);
		System.out.println(partName[1] + ":" + point[1]);
		System.out.println(partName[2] + ":" + point[2]);
		System.out.println(partName[3] + ":" + point[3]);
		System.out.println(partName[4] + ":" + point[4]);

		String[] fruit = new String[4];

		fruit[0] = "복숭아";
		fruit[3] = "수박";

		System.out.println(fruit[0]); // 복숭아
		System.out.println(fruit[1]); // NULL String의 초기값은 NULL, int의 초기값은 0
		System.out.println(fruit[2]); // NULL
		System.out.println(fruit[3]); // 수박

	}

}

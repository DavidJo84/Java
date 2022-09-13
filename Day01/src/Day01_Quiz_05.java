
public class Day01_Quiz_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1000;  // a의 거리
		int b = 400; // b의거리
		int gaptime = 0; // a의 현재 위치에  b가 걸어 가려고 할 때 필요한 시간, b는 1분에 100m를 간다.// 
		                 //예를들어  gaptime이 2이면 2분이고, 걸어간 길이는 200m이다.//
		gaptime = (a-b)/100;  //조건: 수식은 a과 b의 값이 변할때마다 결과값도 바뀌어야 한다. //
		System.out.println(gaptime +"분 필요합니다");
	}

}


public class Day01_Quiz_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int a = 10000;     // 손님이 낸 금액 < 손코딩한 후  실제코드로 피드백하세요>
		 int pay = 4500;   // 물건 가격
		 int jandon = a - pay;  // 거스름돈
		 
		 System.out.println("천원짜리 "+ jandon/1000 + "개, "+
				 "백원짜리 " +((jandon%1000)/100)+"개, "+
				 "십원짜리 "+(((jandon%1000)%100)/10)+"개, "+
				 "일원짜리 "+(((jandon%1000)%100)%10)+"개");
	}

}

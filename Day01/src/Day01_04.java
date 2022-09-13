
public class Day01_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int eng=84;
		int math=92;
		int java=89;
		int orcl=81;
		int mysql=95;
		int sum=0;
		double avg=0;
		
		sum= eng+math+java+orcl+mysql;
		avg= (double)sum/5;
		
		System.out.println("영어: "+eng+"점, "+"수학: "+math+"점, "
				+"자바: "+java+"점, "+ "오라클: "+orcl+"점, "
				+"Mysql: "+mysql+"점");
		System.out.println("점수 총합: "+sum+"점");
		System.out.println("평균: "+avg+"점");
	
	}

}

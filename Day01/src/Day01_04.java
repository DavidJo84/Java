
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
		
		System.out.println("����: "+eng+"��, "+"����: "+math+"��, "
				+"�ڹ�: "+java+"��, "+ "����Ŭ: "+orcl+"��, "
				+"Mysql: "+mysql+"��");
		System.out.println("���� ����: "+sum+"��");
		System.out.println("���: "+avg+"��");
	
	}

}

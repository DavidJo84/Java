
public class Day01_Quiz_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int a = 10000;     // �մ��� �� �ݾ� < ���ڵ��� ��  �����ڵ�� �ǵ���ϼ���>
		 int pay = 4500;   // ���� ����
		 int jandon = a - pay;  // �Ž�����
		 
		 System.out.println("õ��¥�� "+ jandon/1000 + "��, "+
				 "���¥�� " +((jandon%1000)/100)+"��, "+
				 "�ʿ�¥�� "+(((jandon%1000)%100)/10)+"��, "+
				 "�Ͽ�¥�� "+(((jandon%1000)%100)%10)+"��");
	}

}


public class Day01_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="�޸�";
		int point = 100;
		
		name = name+"����";
		point = 300;
		
		System.out.println(name);
		System.out.println(point);
		
		int a=18;
		int b=4;
		int result=0;
		int result1=0;
		int result2=0;
		int result3=0;

		result = a-b;
		result1 = a*b;
		result2 = a/b;
		result3 = a%b;

		System.out.println("�����1 : "+ result);
		System.out.println("�����2 : "+ result1);
		System.out.println("�����3 : "+ result2);
		System.out.println("�����4 : "+ result3);
		System.out.println("�����5 : "+ (a-b));
	}

}

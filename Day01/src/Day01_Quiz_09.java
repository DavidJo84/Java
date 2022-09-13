
public class Day01_Quiz_09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10;
	      a = a +'a'+'b'; 
	      System.out.println(a);

	//->a는 int형이기 때문에 문자 a,b가 들어갈 수 없을것 같지만 문자를 유니코드 값으로 변경하여 
	//값이 205로 출력 a=97, b=98, 즉 10+97+98=205
	//문자열은 안되며 문자만 가능
		 char b=97;
	     System.out.println(b);
	}

}

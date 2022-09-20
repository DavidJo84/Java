package Tr;

public class Day16_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String aa="/삼송 5000/엘쥐 9000/휴먼 3000/실버양행 6000/이제네트워크 200";
		String[] bb= aa.split("/");
		System.out.print("회사명 가격");
		for(int i=0; i<bb.length;i++) {
			System.out.println(bb[i]);
		}
	}
}

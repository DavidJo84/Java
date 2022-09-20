package Test;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
	//1.선언
		//배열
		Member[] mlist1= new Member[10];
		
		//리스트
		ArrayList<Member> mlist2= new ArrayList<>();
		
	//2.입력
		Member m1= new Member("kim",23);
		Member m2= new Member("lee",23);
		//배열
		for(int i=0; i<mlist1.length;i++) {
			if(mlist1[i]==null) {
				mlist1[i]= m1;
				break;
				
			}
		}
		
		//리스트
		mlist2.add(m1);
		mlist2.add(m2);
		
	//3.값 가져오기
		//배열
		for(int i=0; i<mlist1.length;i++) {
			if(mlist1[i]!=null) {
				mlist1[i].prt();
			}
		}
		
		//리스트
		for(int i=0; i<mlist2.size();i++) {
			mlist2.get(i).prt();
		}
		System.out.println("--------------");
		//실습문제
		
		//1. lee이름을 park으로 변경하는 코드를 한줄로 작성
		mlist2.get(1).name="park";
//		for(int i=0; i<mlist2.size();i++) {
//			if(mlist2.get(i).name=="lee") {
//				mlist2.get(i).name="park";
//			}
//		}
		//2. 리스트의 모든값을 출력
		for(int i=0; i<mlist2.size();i++) {
			mlist2.get(i).prt();
		}
		System.out.println("--------------");
		//3. 이름이 choi,나이가 33인 객체를 새로만들고 추가
		Member m3= new Member("choi",33);
		mlist2.add(m3);
		//4. 리스트의 모든값을 출력
		for(int i=0; i<mlist2.size();i++) {
			mlist2.get(i).prt();
		}
		System.out.println("--------------");
		//5. 리스트의 0번 인덱스를 삭제
		mlist2.remove(0);
		//6. 리스트의 모든 값 출력
		for(int i=0; i<mlist2.size();i++) {
			mlist2.get(i).prt();
		}
		System.out.println("--------------");
		//7. 리스트의 모든값중 이름만 출력
		for(int i=0; i<mlist2.size();i++) {
			System.out.println(i+"번 인덱스: "+mlist2.get(i).name);
		}
	}
}

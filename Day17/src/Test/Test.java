package Test;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
	//1.����
		//�迭
		Member[] mlist1= new Member[10];
		
		//����Ʈ
		ArrayList<Member> mlist2= new ArrayList<>();
		
	//2.�Է�
		Member m1= new Member("kim",23);
		Member m2= new Member("lee",23);
		//�迭
		for(int i=0; i<mlist1.length;i++) {
			if(mlist1[i]==null) {
				mlist1[i]= m1;
				break;
				
			}
		}
		
		//����Ʈ
		mlist2.add(m1);
		mlist2.add(m2);
		
	//3.�� ��������
		//�迭
		for(int i=0; i<mlist1.length;i++) {
			if(mlist1[i]!=null) {
				mlist1[i].prt();
			}
		}
		
		//����Ʈ
		for(int i=0; i<mlist2.size();i++) {
			mlist2.get(i).prt();
		}
		System.out.println("--------------");
		//�ǽ�����
		
		//1. lee�̸��� park���� �����ϴ� �ڵ带 ���ٷ� �ۼ�
		mlist2.get(1).name="park";
//		for(int i=0; i<mlist2.size();i++) {
//			if(mlist2.get(i).name=="lee") {
//				mlist2.get(i).name="park";
//			}
//		}
		//2. ����Ʈ�� ��簪�� ���
		for(int i=0; i<mlist2.size();i++) {
			mlist2.get(i).prt();
		}
		System.out.println("--------------");
		//3. �̸��� choi,���̰� 33�� ��ü�� ���θ���� �߰�
		Member m3= new Member("choi",33);
		mlist2.add(m3);
		//4. ����Ʈ�� ��簪�� ���
		for(int i=0; i<mlist2.size();i++) {
			mlist2.get(i).prt();
		}
		System.out.println("--------------");
		//5. ����Ʈ�� 0�� �ε����� ����
		mlist2.remove(0);
		//6. ����Ʈ�� ��� �� ���
		for(int i=0; i<mlist2.size();i++) {
			mlist2.get(i).prt();
		}
		System.out.println("--------------");
		//7. ����Ʈ�� ��簪�� �̸��� ���
		for(int i=0; i<mlist2.size();i++) {
			System.out.println(i+"�� �ε���: "+mlist2.get(i).name);
		}
	}
}

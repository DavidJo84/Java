package extends_ex1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Child_M> cmList = new ArrayList<>();
		ArrayList<Child_W> cwList = new ArrayList<>();
		
		
		// 남자2, 여자 2명을 만든다
		Child_M cm1 = new Child_M();
		cm1.setName("David");
		cm1.setAge(39);
		cmList.add(cm1);
				
		Child_M cm2 = new Child_M();
		cm2.setName("Jhon");
		cm2.setAge(23);
		cmList.add(cm2);
				
		Child_W cw1 = new Child_W();
		cw1.setName("Elsa");
		cw1.setAge(26);
		cwList.add(cw1);
				
		Child_W cw2 = new Child_W();
		cw2.setName("Maria");
		cw2.setAge(36);
		cwList.add(cw2);
		
		for(int i =0; i < cmList.size(); i++) {
			System.out.println(cmList.get(i).getName());
			System.out.println(cmList.get(i).getAge());
		}
		
		for(int i =0; i < cwList.size(); i++) {
			System.out.println(cwList.get(i).getName());
			System.out.println(cwList.get(i).getAge());
		}
	}
}

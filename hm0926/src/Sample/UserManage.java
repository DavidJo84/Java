package Sample;

import User.User;

public class UserManage {

	UserManage() {
		User newUser = new User();
		newUser.setName("johayoung");
		newUser.setAge(39);
		newUser.prt();
		newUser.plusAge();
		newUser.prt();

		System.out.println("이름: " + newUser.getName());
		System.out.println("나이: " + newUser.getAge());
	}
}

package User;

public class User {
	private String name = null;
	private int age = 0;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}

	public void plusAge() {
		age++;
	}

	public void prt() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}
}

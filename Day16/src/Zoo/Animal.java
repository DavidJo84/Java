package Zoo;

public class Animal {
	String kind =  null;
	String name = null;
	String food = null;
	int age = 0;
	String sick= null;
	
	public void setAnimal(String kind,String name,String food,int age,String sick) {
		this.kind=kind;
		this.name=name;
		this.food=food;
		this.age=age;
		this.sick=sick;
		
	}
	
	public void prt() {
		System.out.println("������: " + this.kind);
		System.out.println("�����̸�: " + this.name);
		System.out.println("��������: " + this.food);
		System.out.println("��������: " + this.age);
		System.out.println("��������: " + this.sick);
	}
}

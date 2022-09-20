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
		System.out.println("동물명: " + this.kind);
		System.out.println("동물이름: " + this.name);
		System.out.println("동물먹이: " + this.food);
		System.out.println("동물나이: " + this.age);
		System.out.println("동물질병: " + this.sick);
	}
}

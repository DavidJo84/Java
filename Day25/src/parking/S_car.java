package parking;

public class S_car extends CarInfo {
	
	@Override
	public void plusDis() {
		if(family>=3) {
			price = (int) (price*0.9);
			dPrice = (int) (dPrice * 0.9);
		}
		
	}
}

package parking;

public class M_car extends CarInfo {

	@Override
	public void plusDis() {
		if (family >= 4) {
			price = (int) (price * 0.9);
			dPrice = (int) (dPrice * 0.9);
		}

	}
}

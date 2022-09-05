package human;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		int a = in.nextInt();
		in.nextLine();
		System.out.println("입력한 숫자는:" + a);
		System.out.println("단어를 입력하세요.");
		String word = in.nextLine();
		System.out.println("입력한 단어는?" + word);
		in.close();
	}
}

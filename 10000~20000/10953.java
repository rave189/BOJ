import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		input.nextLine();
		for (int i = 0; i < number; i++) {
			String[] s = input.nextLine().split("");
			System.out.println(Integer.parseInt(s[0]) + Integer.parseInt(s[2]));
		}
	}
}

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		long[] array = new long[number];
		if (number >= 2) {
			array[0] = 1;
			array[1] = 3;
			for (int i = 2; i < number; i++)
				array[i] = (array[i - 1] + 2*array[i - 2]) % 10007;
			System.out.println(array[number - 1]);
		}
		else
			System.out.println(1);
	}
}

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int[] array = new int[number + 1];
		for (int i = 1; i <= number; i++)
			array[i] = input.nextInt();
		int[] result = new int[number + 1];
		result[1] = array[1];
		if (number != 1)
			result[2] = array[1] + array[2];
		for (int i = 3; i <= number; i++) {
			result[i] = Integer.max(Integer.max(result[i - 1], result[i - 2] + array[i]),
					result[i - 3] + array[i - 1] + array[i]);
		}
		System.out.println(result[number]);
	}
}

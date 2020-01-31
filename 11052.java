import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int[] card = new int[number + 1];
		for (int i = 1; i <= number; i++)
			card[i] = input.nextInt();
		int[] result = new int[number + 1];
		for (int i = 1; i <= number; i++)
			for (int j = 1; j <= i; j++)
				result[i] = Integer.max(result[i], result[i - j] + card[j]);
		System.out.println(result[number]);
	}
}

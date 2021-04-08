import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		int sum = 1;
		if (k == 0)
			System.out.println(1);
		else {
			for (int i = n; i > n - k; i--)
				sum *= i;
			for (int i = k; i > 0; i--)
				sum /= i;
			System.out.println(sum);
		}
	}
}

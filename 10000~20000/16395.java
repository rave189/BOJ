import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt() - 1;
		int k = input.nextInt() - 1;
		int count = 1;
		for (int j = n, t = 1; j > k; j--, t++) {
			count *= j;
			count /= t;
		}
		System.out.println(count);
	}
}

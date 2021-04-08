import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		for (int i = 0; i < num; i++) {
			int n = input.nextInt();
			int m = input.nextInt();
			int count = 1;
			for (int j = m, t = 1; j > n; j--, t++) {
				count *= j;
				count /= t;
			}
			System.out.println(count);
		}
	}
}

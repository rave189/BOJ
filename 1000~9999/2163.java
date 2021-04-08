import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		System.out.println(Cut(n, m));
	}

	public static int Cut(int n, int m) {
		if (n == 1 && m == 1)
			return 0;
		else {
			if (n > m)
				return Cut(n / 2, m) + Cut(n - n / 2, m) + 1;
			else
				return Cut(n, m / 2) + Cut(n, m - m / 2) + 1;
		}
	}
}

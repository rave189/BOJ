import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		boolean[] check = new boolean[n + 1];
		Back(n, 0, m, "", check);
	}

	public static void Back(int n, int length, int m, String ans, boolean[] check) {
		if (length <= m) {
			for (int i = 1; i <= n; i++) {
				if (!check[i]) {
					check[i] = true;
					Back(n, length + 1, m, ans + i + " ", check);
					check[i] = false;
				}
			}
		}
		if (ans.length() == m * 2)
			System.out.println(ans);
	}
}

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		Back(n, 0, m, "", 1);
	}

	public static void Back(int n, int length, int m, String ans, int num) {
		if (length <= m)
			for (int i = 1; i <= n; i++)
				if (i >= num)
					Back(n, length + 1, m, ans + i + " ", i);
		if (ans.length() == m * 2)
			System.out.println(ans);
	}
}

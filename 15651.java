import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		Back(n, 0, m, "");
		System.out.println(sb);
	}

	public static void Back(int n, int length, int m, String ans) {
		if (length <= m)
			for (int i = 1; i <= n; i++)
				Back(n, length + 1, m, ans + i + " ");
		if (ans.length() == m * 2)
			sb.append(ans+"\n");
	}
}

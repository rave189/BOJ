import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder answer = new StringBuilder();
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		check = new boolean[n + 1];
		Search(n, "");
		System.out.println(answer);
	}

	public static void Search(int n, String result) {
		if (result.length() == 2 * n) {
			answer.append(result + "\n");
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (check[i])
				continue;
			check[i] = true;
			Search(n, result + i + " ");
			check[i] = false;
		}
	}
}

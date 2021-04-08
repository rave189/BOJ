import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] children = new int[n];
		for (int i = 0; i < n; i++)
			children[i] = Integer.parseInt(br.readLine());
		int[] dp = new int[n];
		int max = 1;
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++)
				if (children[j] < children[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
					max = Math.max(max, dp[i]);
				}
		}
		System.out.println(n - max);
	}
}

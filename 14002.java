import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		String[] route = new String[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			route[i] = arr[i] + " ";
			for (int j = 0; j < i; j++)
				if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
					route[i] = route[j] + arr[i] + " ";
				}
		}
		int maxIdx = 0;
		for (int i = 0; i < n; i++)
			if (dp[i] > dp[maxIdx])
				maxIdx = i;
		System.out.println(dp[maxIdx]);
		System.out.println(route[maxIdx]);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cost = new int[n + 1];
		int[] answer = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			cost[i] = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; i++) {
			answer[i] = cost[i];
			for (int j = 1; j <= i; j++)
				answer[i] = Math.min(answer[i - j] + cost[j], answer[i]);
		}
		System.out.println(answer[n]);
	}
}

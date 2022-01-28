package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 앱이 있다.
 * 이 앱 중에서 몇 개를 꺼 M 바이트 이상의 메모리를 확보하려고 한다.
 * 각 앱이 사용하고 있는 바이트와 앱을 종료하는데 드는 비용이 주어질 때
 * M 바이트의 메모리를 확보하는데 드는 최소 비용을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 냅색 문제다.
	 * 끄는데 드는 총 비용을 최대 크기로 두고 앱을 끄는데 드는 비용을 계산해나간다.
	 * dp[i][j]는 i번째 앱까지 중에서 j의 비용을 사용하면 dp[i][j]만큼의 메모리를 확보할 수 있다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] memory = new int[n + 1];
		int[] close = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			memory[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 1; i <= n; i++) {
			close[i] = Integer.parseInt(st.nextToken());
			max += close[i];
		}
		int[][] dp = new int[n + 1][max + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= max; j++) {
				dp[i][j] = dp[i - 1][j];
				try {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - close[i]] + memory[i]);
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		}
		for (int i = 1; i <= max; i++)
			if (dp[n][i] >= m) {
				System.out.println(i);
				return;
			}
	}
}
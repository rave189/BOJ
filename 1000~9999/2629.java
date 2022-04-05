package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 양팔 저울이 있다.
 * 무게 추 N개가 있다.
 * 무게를 측정하고 싶은 구슬이 있다.
 * 양팔 저울의 한쪽에 구슬을 두고, 무게 추를 양팔에 적절히 조합하여 구슬의 무게를 측정할 수 있는지 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 냅색 문제
	 * 구슬이 있는쪽에 놓는 것은 현재 무게 - 무게, 구슬 반대편에 놓는 것은 현재 무게 + 무게
	 * 최대로 나올 수 있는 무게를 구하고 dp[n][max]를 사용한다.
	 * i번째 추까지 사용하여 구할 수 있는 무게 v를 저장한다.
	 * 
	 * 대부분의 경우 현재 무게 - 무게로 구할 수 있음.
	 * 현재 무게 + 무게를 안해주니 정답이 안나왔음.
	 * 3
	 * 7 8 9
	 * 1
	 * 6
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] weights = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < n; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
			max += weights[i];
		}
		boolean[][] dp = new boolean[n][max + 1];
		dp[0][weights[0]] = true;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= max; j++) {
				dp[i][j] |= dp[i - 1][j];
				try {
					dp[i][j] |= dp[i - 1][Math.abs(j - weights[i])];
					dp[i][j-weights[i]] |= dp[i][j];
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
			dp[i][weights[i]] = true;
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (m-- > 0) {
			int v = Integer.parseInt(st.nextToken());
			try {
				answer.append(dp[n - 1][v] ? "Y" : "N");
			} catch (ArrayIndexOutOfBoundsException e) {
				answer.append("N");
			}
			answer.append(' ');
		}
		System.out.println(answer);
	}
}
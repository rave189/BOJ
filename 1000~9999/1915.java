package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * NxM 크기의 배열이 주어진다.
 * 배열에는 1과 0으로만 이루어져 있을 때, 1로 이루어진 가장 큰 정사각형의 넓이를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 가장 큰 정사각형의 넓이를 dp로 저장하며 푼다.
	 * 왼쪽, 대각선, 위가 1이면 정사각형이 될 수 있다.
	 * 이 때 저장하는 값은 왼쪽, 대각선, 위의 값중 가장 작은 값에서 +1한 넓이를 저장한다.
	 * 
	 * 굳이 넓이 구한다고 sqrt쓰지말고 그냥 길이만 저장해두고, 길이의 최대값을 제곱하여 넓이를 구하는게 훨씬 더 보기 좋을 것 같다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++)
				map[i][j + 1] = line.charAt(j) == '1' ? true : false;
		}
		int[][] dp = new int[n + 1][m + 1];
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (!map[i][j])
					continue;
				dp[i][j] = 1;
				if (map[i - 1][j] && map[i - 1][j - 1] && map[i][j - 1]) {
					int row = (int) Math.sqrt(Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]));
					dp[i][j] = (row + 1) * (row + 1);
				}
				answer = Math.max(answer, dp[i][j]);
			}
		}
		System.out.println(answer);
	}
}
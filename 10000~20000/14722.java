package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 정사각형 형태의 2차원 격자 모양의 각 지점이 우유 가게로 되어있는 도시가 있다.
 * 우유 가게는 한 종류의 우유만을 판매한다.
 * 이 도시의 (1, 1)부터 (N, N)까지 각 우유 가게를 들러 우유를 마시려고한다.
 * 단, 우유는 딸기 우유, 초코 우유, 바나나 우유 다시 딸기 우유 순서로 마셔야 한다.
 * 하지만 우유를 마시지 않고 넘어가도 상관 없다.
 * 또한, 항상 동쪽과 남쪽 방향으로만 움직여야 한다.
 * 이때, 마실 수 있는 우유의 최댓값을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static int[][][] dp;

	/**
	 * 입력값이 1000까지 들어오고, 1000x1000 배열을 bfs로 탐색하면 메모리 초과가 일어날 수 있다.
	 * 따라서 dp를 사용하여 문제를 해결한다.
	 * dp는 NxN 이외에 이전에 무엇을 마셨는지도 중요하므로 3차원 배열로 선언한다.
	 * (우유를 마신 갯수로도 이전에 무엇을 마셨는지 알 수 있다.
	 * ex. 1: 딸기 우유, 2: 초코 우유, 3: 바나나 우유 반복)
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[3][n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					dp[0][i][j] = 1;
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				for (int t = 0; t < dp.length; t++) {
					if (dp[t][i][j] == 0)
						continue;
					int nextType = (t + 1) % 3;
					// 배열의 크기를 n+1로 잡았으면 조건을 걸지 않고 j-1, i-1로 처리할 수 있었음.
					if (j + 1 < map[0].length) {
						// 다음 가게에서 판매하는 우유가 마셔야 하는 우유과 같다면 최댓값인지 비교한다.
						if (map[i][j + 1] == nextType)
							dp[nextType][i][j + 1] = Math.max(dp[nextType][i][j + 1], dp[t][i][j] + 1);
						// 마시지 않고 그냥 넘어가는 경우
						dp[t][i][j + 1] = Math.max(dp[t][i][j + 1], dp[t][i][j]);
					}
					if (i + 1 < map.length) {
						if (map[i + 1][j] == nextType)
							dp[nextType][i + 1][j] = Math.max(dp[nextType][i + 1][j], dp[t][i][j] + 1);
						dp[t][i + 1][j] = Math.max(dp[t][i + 1][j], dp[t][i][j]);
					}
				}
			}
		}
		int max = 0;
		for (int i = 0; i < dp.length; i++)
			max = Math.max(max, dp[i][n - 1][n - 1]);
		System.out.println(max);
	}
}
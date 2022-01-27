package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 외판원이 순회를 하려고 한다.
 * 모든 도시를 한 번씩만 지나면서 최소한의 비용으로 다시 출발점으로 돌아오는 비용을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[][] map, dp;
	static final int INF = 20000000;
	static int answer = Integer.MAX_VALUE, n;

	/**
	 * 외판원 순회 문제
	 * 비트마스킹과 재귀를 사용해서 구현한다.
	 * 
	 * dfs의 메모이제이션을 이용하는게 훨씬 빠르다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		dp = new int[n + 1][1 << n];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= n; i++)
			Arrays.fill(dp[i], INF);
		dp[1][1] = 0;
		tsp(1, 1);
		System.out.println(answer);
	}

	public static void tsp(int cur, int visited) {
		if (visited == (1 << n) - 1) {
			if (map[cur][1] != 0)
				answer = Math.min(answer, dp[cur][visited] + map[cur][1]);
			return;
		}

		for (int i = 1; i <= n; i++) {
			int next = 1 << (i - 1);
			int nextVisited = visited | next;
			// if 순서 바꾸면 시간 초과
			// 아마 방문체크로 걸러지는게 많아서 
			if (nextVisited == visited)
				continue;
			else if (map[cur][i] == 0)
				continue;
			if (dp[cur][visited] + map[cur][i] < dp[i][nextVisited]) {
				dp[i][nextVisited] = dp[cur][visited] + map[cur][i];
				tsp(i, nextVisited);
			}
		}
	}
}
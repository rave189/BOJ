package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N개의 발전소가 있다.
 * 이 중 몇몇 발전소가 고장이 났다.
 * 발전소들 중에서 P개의 발전소가 고장이 나지 않도록 하려고 한다.
 * i번 발전소에서 j번 발전소를 고치는 비용이 주어질 때,
 * P개의 발전소가 고장나지 않도록 하는 최솟값을 구하는 문제
 * 불가능한 경우 -1을 출력한다.
 * @author Rave
 *
 */
public class Main {

	static int[][] map, dp;
	static int answer = Integer.MAX_VALUE, INF = 1000000, n, p;

	/**
	 * 외판원 문제와 유형이 거의 똑같다.
	 * dp[i][j]는 j의 방문을 통해 i개의 발전소를 고쳤다는 의미이다.
	 * 발전소가 전부다 망가지는 경우도 있으므로 0부터 n까지 모두 초기화 해준다.
	 * 탐색은 이중 for문을 통해 망가지지 않은 발전소를 찾고, 망가진 발전소를 찾아 고치는 비용을 더해 최솟값을 dp에 저장한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		dp = new int[n + 1][1 << n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		String line = br.readLine();
		p = Integer.parseInt(br.readLine());
		int visited = 0, onCnt = 0;
		for (int i = 0; i < n; i++)
			if (line.charAt(i) == 'Y') {
				visited |= 1 << i;
				onCnt++;
			}
		for (int i = 0; i <= n; i++)
			Arrays.fill(dp[i], INF);
		int result = tsp(onCnt, visited);
		System.out.println(result == INF ? -1 : result);
	}

	public static int tsp(int count, int visited) {
		if (count >= p)
			return 0;
		if (dp[count][visited] != INF)
			return dp[count][visited];
		for (int i = 0; i < n; i++) {
			if ((visited & (1 << i)) >= 1) {
				for (int j = 0; j < n; j++)
					if ((visited & (1 << j)) == 0)
						dp[count][visited] = Math.min(dp[count][visited],
								tsp(count + 1, visited | (1 << j)) + map[i][j]);
			}
		}
		return dp[count][visited];
	}
}
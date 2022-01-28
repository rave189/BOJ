package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ���ǿ��� ��ȸ�� �Ϸ��� �Ѵ�.
 * ��� ���ø� �� ������ �����鼭 �ּ����� ������� �ٽ� ��������� ���ƿ��� ����� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int[][] map, dp;
	static final int INF = 20000000;
	static int answer = Integer.MAX_VALUE, n;

	/**
	 * ���ǿ� ��ȸ ����
	 * ��Ʈ����ŷ�� ��͸� ����ؼ� �����Ѵ�.
	 * 
	 * dfs�� �޸������̼��� �̿��ϴ°� �ξ� ������.
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
			// if ���� �ٲٸ� �ð� �ʰ�
			// �Ƹ� �湮üũ�� �ɷ����°� ���Ƽ� 
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
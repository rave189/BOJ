package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N���� �����Ұ� �ִ�.
 * �� �� ��� �����Ұ� ������ ����.
 * �����ҵ� �߿��� P���� �����Ұ� ������ ���� �ʵ��� �Ϸ��� �Ѵ�.
 * i�� �����ҿ��� j�� �����Ҹ� ��ġ�� ����� �־��� ��,
 * P���� �����Ұ� ���峪�� �ʵ��� �ϴ� �ּڰ��� ���ϴ� ����
 * �Ұ����� ��� -1�� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	static int[][] map, dp;
	static int answer = Integer.MAX_VALUE, INF = 1000000, n, p;

	/**
	 * ���ǿ� ������ ������ ���� �Ȱ���.
	 * dp[i][j]�� j�� �湮�� ���� i���� �����Ҹ� ���ƴٴ� �ǹ��̴�.
	 * �����Ұ� ���δ� �������� ��쵵 �����Ƿ� 0���� n���� ��� �ʱ�ȭ ���ش�.
	 * Ž���� ���� for���� ���� �������� ���� �����Ҹ� ã��, ������ �����Ҹ� ã�� ��ġ�� ����� ���� �ּڰ��� dp�� �����Ѵ�.
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
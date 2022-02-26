package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ������ �־�����.
 * �������� ������ �������� ���̰� �����ִ�.
 * ���̰� ���� �����θ� �̵��Ϸ��� �� ��,
 * (0, 0) -> (N-1, M-1)�� �̵��� �� �ִ� ����� ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int n, m;
	static int[][] map, dp;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	/**
	 * dfs + dp�� Ǯ �� �ִ�.
	 * dp�� ó���� -1�� �ʱ�ȭ�صξ� �Ȱ� ������ ǥ���ؾ� �Ѵ�.
	 * 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		dfs(new Point(0, 0));
		System.out.println(dp[0][0]);
	}

	public static int dfs(Point cur) {
		if (dp[cur.x][cur.y] >= 0)
			return dp[cur.x][cur.y];
		else if (cur.x == n - 1 && cur.y == m - 1)
			return 1;
		dp[cur.x][cur.y] = 0;
		for (int i = 0; i < dx.length; i++) {
			int nextX = cur.x + dx[i];
			int nextY = cur.y + dy[i];
			try {
				if (map[cur.x][cur.y] > map[nextX][nextY])
					dp[cur.x][cur.y] += dfs(new Point(nextX, nextY));
			} catch (ArrayIndexOutOfBoundsException e) {
			}
		}
		return dp[cur.x][cur.y];
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
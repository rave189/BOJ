package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 지도가 주어진다.
 * 지도에는 각각의 지점마다 높이가 적혀있다.
 * 높이가 낮은 곳으로만 이동하려고 할 때,
 * (0, 0) -> (N-1, M-1)로 이동할 수 있는 경우의 수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int n, m;
	static int[][] map, dp;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	/**
	 * dfs + dp로 풀 수 있다.
	 * dp를 처음에 -1로 초기화해두어 안간 지점을 표시해야 한다.
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
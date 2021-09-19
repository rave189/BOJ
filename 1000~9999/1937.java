package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 대나무 숲에서 판다를 키우려고 한다.
 * 판다는 한 곳에서 대나무를 다 먹으면 상, 하, 좌, 우로 이동하여 다시 대나무를 전부 먹는다.
 * 이 때 판다는 현재 먹은 지점의 대나무 수보다 많은 대나무가 있는 지점으로만 이동한다.
 * 판다가 이동할 수 있는 최대 칸 수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static int[][] dp;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	/**
	 * 전체 맵에 판다를 한 번씩 다 놓아본다.
	 * 그리고 최대 이동 칸 수를 dp에 기록해둔다.
	 * 그리고 이미 이동해 본 지점에 도착한 경우 dp의 값을 사용하여 판다의 최대 이동 칸 수를 구한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				answer = Math.max(answer, DFS(new Point(i, j)));
		System.out.println(answer);
	}

	/**
	 * dp에 이미 값이 존재할 경우 그대로 return해준다.
	 * 없을 경우 상하좌우를 모두 탐색하여 최댓값에 + 1을 dp에 저장하며 return한다.
	 * @param p 현재 지점
	 * @return
	 */
	public static int DFS(Point p) {
		if (dp[p.x][p.y] != 0) {
			return dp[p.x][p.y];
		}
		int max = 0;
		for (int i = 0; i < dx.length; i++) {
			int nextX = p.x + dx[i];
			int nextY = p.y + dy[i];
			try {
				if (map[nextX][nextY] > map[p.x][p.y])
					max = Math.max(max, DFS(new Point(nextX, nextY)));
			} catch (ArrayIndexOutOfBoundsException e) {
			}
		}
		return dp[p.x][p.y] = max + 1;
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
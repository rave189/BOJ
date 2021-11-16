package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * ����ó�� ������ ���� �������� ���ڰ� �� �������� ���ϴ� ����
 * ������ �κ��� 1�� ǥ���ǰ�, �ƴ� �κ��� 0���� ǥ���ȴ�.
 * ������ �κ��� ��, ��, ��, ��, �밢������ �����ϸ� ����Ǿ� �� ���� ���ڶ�� �Ǵ��Ѵ�.
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };

	/**
	 * bfs Ž���� ���� ���ڰ� ����� ���Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(new Point(i, j));
					answer++;
				}
		System.out.println(answer);
	}

	public static void bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		visited[start.x][start.y] = true;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					if (visited[nextX][nextY] || map[nextX][nextY] == 0)
						continue;
					visited[nextX][nextY] = true;
					q.add(new Point(nextX, nextY));
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		}
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
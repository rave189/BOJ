package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 오목에서 검은 돌이 이기면 1, 흰 돌이 이기면 2, 아직 승부가 결정나지 않았으면 0을 출력하는 문제
 * 검은 돌이나 흰 돌이 이기는 경우 가장 왼쪽의 돌을 두 번째 줄에 출력한다.
 * 세로로 이긴 경우 가장 위의 돌을 출력한다.
 * @author Rave
 *
 */
public class Main {

	static final int SIZE = 19;
	static int[][] map = new int[SIZE][SIZE];
	static boolean[][] visited;
	static int[][] dx = { { 0, 0 }, { 1, -1 }, { -1, 1 }, { 1, -1 } };
	static int[][] dy = { { 1, -1 }, { 0, 0 }, { 1, -1 }, { 1, -1 } };
	static Point left;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[0].length; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < dx.length; i++) {
			visited = new boolean[SIZE][SIZE];
			for (int j = 0; j < SIZE; j++) {
				for (int t = 0; t < SIZE; t++) {
					if (visited[j][t] || map[j][t] == 0)
						continue;
					if (bfs(new Point(j, t), dx[i], dy[i])) {
						System.out.printf("%d\n%d %d", map[j][t], left.x + 1, left.y + 1);
						return;
					}
				}
			}
		}
		System.out.println(0);
	}

	public static boolean bfs(Point start, int[] dx, int[] dy) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		left = start;
		visited[start.x][start.y] = true;
		int count = 0;
		int type = map[start.x][start.y];
		while (!q.isEmpty()) {
			Point cur = q.poll();
			left.update(cur);
			if (map[cur.x][cur.y] == type)
				count++;
			for (int i = 0; i < dx.length; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					if (visited[nextX][nextY] || map[nextX][nextY] != type)
						continue;
					q.add(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
				} catch (Exception e) {
				}
			}
		}
		return count == 5;
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void update(Point o) {
		if (o.y < y) {
			x = o.x;
			y = o.y;
		}
	}
}
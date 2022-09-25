package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static char[][] map;
	public static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	public static int[][][] visited;
	public static Point[] points = new Point[2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new int[dx.length][n][m];
		for (int i = 0; i < dx.length; i++)
			for (int j = 0; j < n; j++)
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
		for (int i = 0, idx = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'C')
					points[idx++] = new Point(i, j);
			}
		}
		bfs(points[0]);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < dx.length; i++)
			min = min(min, visited[i][points[1].x][points[1].y]);
		System.out.println(min);
	}

	public static void bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < dx.length; i++) {
			q.add(new Point(start.x, start.y, i));
			visited[i][start.x][start.y] = 0;
		}
		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (points[1].x == cur.x && points[1].y == cur.y)
				continue;
			for (int i = 0; i < dx.length; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					if (map[nextX][nextY] == '*')
						continue;
					if (getRight(cur.direction) == i || getLeft(cur.direction) == i) {
						if (visited[i][nextX][nextY] <= visited[cur.direction][cur.x][cur.y] + 1)
							continue;
						visited[i][nextX][nextY] = visited[cur.direction][cur.x][cur.y] + 1;
					} else {
						if (visited[i][nextX][nextY] <= visited[cur.direction][cur.x][cur.y])
							continue;
						else
							visited[i][nextX][nextY] = visited[cur.direction][cur.x][cur.y];
					}
					q.add(new Point(nextX, nextY, i));
				} catch (Exception e) {
				}
			}
		}
	}

	public static int getRight(int n) {
		return (n + 1) % dx.length;
	}

	public static int getLeft(int n) {
		return n == 0 ? dx.length - 1 : n - 1;
	}

	public static int min(int x, int y) {
		return x > y ? y : x;
	}
}

class Point {
	int x, y, direction;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, int direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
}
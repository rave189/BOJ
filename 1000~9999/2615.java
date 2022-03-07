package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * ���񿡼� ���� ���� �̱�� 1, �� ���� �̱�� 2, ���� �ºΰ� �������� �ʾ����� 0�� ����ϴ� ����
 * ���� ���̳� �� ���� �̱�� ��� ���� ������ ���� �� ��° �ٿ� ����Ѵ�.
 * ���η� �̱� ��� ���� ���� ���� ����Ѵ�.
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
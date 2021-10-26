package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * �� �ʿ��� ���Ǹ� ��Ż�ϴ� ���Ϸ��ǰ� �ִ�.
 * �� ���ǿ� ������ ������ ���ǰ� �����Ѵ�.
 * (0, 0)���� (N-1, N-1)���� �̵��ϸ�
 * ���Ϸ��ǿ��� ��Ż���ϴ� ������ �ּ� �ݾ��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static int[][] route;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	/**
	 * �ʱⰪ�� MaxValue�� �����صΰ� value�� �� ���� ��츸 BFS�� ���� �̵��غ���.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int count = 1;
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			map = new int[n][n];
			route = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				Arrays.fill(route[i], Integer.MAX_VALUE);
				for (int j = 0; j < n; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			BFS();
			answer.append("Problem " + count++ + ": " + route[n - 1][n - 1] + '\n');
		}
		System.out.println(answer);
	}

	public static void BFS() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));
		route[0][0] = map[0][0];
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					if (route[cur.x][cur.y] + map[nextX][nextY] < route[nextX][nextY]) {
						route[nextX][nextY] = route[cur.x][cur.y] + map[nextX][nextY];
						q.add(new Point(nextX, nextY));
					}
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
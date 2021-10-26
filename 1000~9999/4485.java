package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 각 맵에는 루피를 강탈하는 도둑루피가 있다.
 * 이 루피와 만나면 소지한 루피가 감소한다.
 * (0, 0)에서 (N-1, N-1)까지 이동하며
 * 도둑루피에게 강탈당하는 루피의 최소 금액을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static int[][] route;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	/**
	 * 초기값을 MaxValue로 설정해두고 value가 더 적은 경우만 BFS를 통해 이동해본다.
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
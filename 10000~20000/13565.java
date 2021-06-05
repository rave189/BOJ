package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 지도의 위부분에서 전류가 침투한다.
 * 전류가 지도의 아래쪽까지 침투할 수 있는지 구하는 문제
 * 전류는 지도의 0인 부분을 이동할 수 있고, 1인 부분으로는 이동할 수 없다.
 * @author Rave
 *
 */
public class Main {

	static Queue<Point> q = new LinkedList<>();
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	/**
	 * i가 0인 지점에서 값이 0인 부분을 모두 큐에 넣는다.
	 * 이후 지나간 지점은 2로 바꾸면서 너비 우선 탐색을 한다.
	 * 탐색이 종료되면 n-1지점에서의 값이 2가 있으면 YES 아니라면 NO를 출력한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0';
				// 전류가 침투할 수 있는 지점을 모두 큐에 넣는다.
				if (i == 0 && map[i][j] == 0)
					q.add(new Point(i, j));
			}
		}
		// 너비우선 탐색
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					if (map[nextX][nextY] == 0) {
						map[nextX][nextY] = 2;
						q.add(new Point(nextX, nextY));
					}
				} catch (Exception e) {
				}
			}
		}
		// 전류가 가장 아래쪽까지 침투했으면 YES 아니라면 NO를 출력한다.
		while (--m > 0)
			if (map[n - 1][m] == 2) {
				System.out.println("YES");
				return;
			}
		System.out.println("NO");
	}
}

class Point {
	int x, y;

	public Point(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}
}
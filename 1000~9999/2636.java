package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * NxM 크기의 판이 있다.
 * 판에는 치즈가 있고, 치즈는 외부 공기에 닿으면 1시간 후에 없어진다.
 * 치즈가 사라지는데 걸리는 시간과 치즈가 모두 사라지기 1시간 전 남은 치즈의 개수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static boolean[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int cheeseCnt = 0;

	/**
	 * bfs문제 결국 돌고돌아 처음 생각으로 구현함..
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
				if (map[i][j])
					cheeseCnt++;
			}
		}
		int time = 0;
		int lastCnt = -1;
		while (cheeseCnt > 0) {
			time++;
			lastCnt = cheeseCnt;
			melt();
		}
		System.out.println(String.format("%d\n%d", time, lastCnt));
	}

	public static void melt() {
		Queue<Point> q = new LinkedList<>();
		Queue<Point> meltList = new LinkedList<>();
		boolean[][] visited = new boolean[map.length][map[0].length];
		q.add(new Point(0, 0));
		visited[0][0] = true;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					if (visited[nextX][nextY])
						continue;
					visited[nextX][nextY] = true;
					Point next = new Point(nextX, nextY);
					if (map[nextX][nextY])
						meltList.add(next);
					else
						q.add(next);
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		}
		cheeseCnt -= meltList.size();
		while (!meltList.isEmpty()) {
			Point cur = meltList.poll();
			map[cur.x][cur.y] = false;
		}
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
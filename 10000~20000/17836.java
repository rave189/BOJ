package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 마왕에게 잡힌 공주가 (N,M)에 있다.
 * 마왕은 공주에게 저주를 걸어 T시간 이후에는 공주가 돌이 되어 구할 수 없다.
 * 공주를 구하기 위해 용사가 (1,1)에서 출발하여 T시간 안에 구할 수 있는지를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static Queue<Point> q = new LinkedList<>();
	static int[][][] map;
	static boolean[][][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		map = new int[2][n][m];
		visited = new boolean[2][n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				map[0][i][j] = Integer.parseInt(st.nextToken());
		}
		System.out.println(BFS(new Point(n - 1, m - 1, 0), t));
	}

	/**
	 * BFS를 통해 (N,M)에 있는 공주를 제한 시간 안에 구할 수 있는지를 구하는 메소드
	 * @param end 공주의 위치
	 * @param t 주어진 시간
	 * @return 구할 수 있다면 시간, 구하지 못한다면 Fail
	 */
	public static String BFS(Point end, int t) {
		q.add(new Point(0, 0, 0));
		visited[0][0][0] = true;
		for (int time = 0; time <= t; time++) {
			int size = q.size();
			while (size-- > 0) {
				Point cur = q.poll();
				if (cur.compareTo(end) == 0)
					return Integer.toString(time);

				for (int i = 0; i < 4; i++) {
					int nextX = cur.x + dx[i];
					int nextY = cur.y + dy[i];
					try {
						if (visited[cur.isGram][nextX][nextY] || map[cur.isGram][nextX][nextY] == 1)
							continue;
						if (map[cur.isGram][nextX][nextY] == 2) {
							q.add(new Point(nextX, nextY, 1));
							visited[1][nextX][nextY] = true;
						} else {
							q.add(new Point(nextX, nextY, cur.isGram));
							visited[cur.isGram][nextX][nextY] = true;
						}
					} catch (Exception e) {
					}
				}
			}
		}
		return "Fail";
	}
}

class Point implements Comparable<Point> {
	int x, y, isGram;

	public Point(int _x, int _y, int _isGram) {
		this.x = _x;
		this.y = _y;
		this.isGram = _isGram;
	}

	@Override
	public int compareTo(Point o) {
		if (x == o.x && y == o.y)
			return 0;
		return 1;
	}
}
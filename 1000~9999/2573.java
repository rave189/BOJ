package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 한 덩이의 빙산의 각 부분별 높이가 주어진다.
 * 빙산 이외의 값은 0이 주어질 때, 빙산은 지구 온난화로 인해 동서남북의 0의 개수 만큼 높이가 감소한다.
 * 이 때 한 덩이의 빙산이 두 덩이 이상으로 쪼개지는데 걸린 최초의 해를 출력하는 문제
 * @author Rave
 *
 */
public class Main {

	// 빙산을 저장할 큐
	static Queue<Point> icebergs = new LinkedList<>();
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 빙산을 큐에 저장한다.
				if (map[i][j] > 0)
					icebergs.add(new Point(i, j));
			}
		}
		int answer = 0;
		while (!icebergs.isEmpty()) {
			// 1년이 지나면 빙산이 녹는다.
			answer++;
			IceMelt();
			// 두 덩이 이상이 되었는지 확인하고 두 덩이 이상이라면 걸린 년도를 출력하고 종료한다.
			if (isDivide()) {
				System.out.println(answer);
				return;
			}
		}
		System.out.println(0);
	}

	/**
	 * 빙산이 1년이 지나 주변의 0의 개수만큼 녹는다.
	 */
	public static void IceMelt() {
		// map에 저장하면 0의 개수가 달라지기 때문에 임시 배열을 선언한다.
		int[][] tmp = new int[map.length][map[0].length];
		int size = icebergs.size();
		// 초기 크기 만큼의 빙산이 녹는다.
		while (size-- > 0) {
			Point iceberg = icebergs.poll();
			// 0의 개수를 센다.
			int zeroCnt = 0;
			for (int i = 0; i < 4; i++) {
				try {
					if (map[iceberg.x + dx[i]][iceberg.y + dy[i]] == 0)
						zeroCnt++;
				} catch (Exception e) {
				}
			}
			// 기존 값에 0의 개수를 뺏을 때 0보다 크다면 tmp에 저장한 후 큐에 다시 넣는다.
			if (map[iceberg.x][iceberg.y] - zeroCnt > 0) {
				tmp[iceberg.x][iceberg.y] = map[iceberg.x][iceberg.y] - zeroCnt;
				icebergs.add(iceberg);
			}
		}
		map = tmp;
	}

	/**
	 * 빙산이 두 덩이 이상이 됬는지 확인하는 메소드
	 * @return 두 덩이 이상이라면 true, 아니라면 false
	 */
	public static boolean isDivide() {
		visited = new boolean[map.length][map[0].length];
		int icebergCnt = 0;
		// 큐에 들어있는 빙산을 하나씩 탐색해본다.
		for (Point iceberg : icebergs) {
			if (!visited[iceberg.x][iceberg.y]) {
				// 빙산이 이 if문 안을 2번 들어온 경우 두 덩이 이상이므로 true를 반환한다.
				if (icebergCnt == 1)
					return true;
				icebergCnt++;
				BFS(iceberg);
			}
		}
		return false;
	}

	/**
	 * 시작 지점을 받아 BFS를 수행하는 메소드
	 * @param start 시작 지점
	 */
	public static void BFS(Point start) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		visited[start.x][start.y] = true;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					if (!visited[nextX][nextY] && map[nextX][nextY] > 0) {
						q.add(new Point(nextX, nextY));
						visited[nextX][nextY] = true;
					}
				} catch (Exception e) {
				}
			}
		}
	}
}

class Point {
	int x, y;

	public Point(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}

	public String toString() {
		return x + " " + y;
	}
}
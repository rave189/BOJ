package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 0은 이동 가능한 공간, 1은 벽으로 표현된 지도가 주어진다.
 * 이 지도에서 벽을 한 개 까지만 부수면서 (1, 1)에서 (N, M)까지 가는 최단 거리를 출력하는 문제
 * @author Rave
 *
 */
public class Main {

	static Queue<Point> q = new LinkedList<>();
	static char[][] map;
	// 벽을 부수지 않았을 때 사용하는 방문 체크 배열
	static boolean[][] visited;
	// 벽을 부수었을 때 사용하는 방문 체크 배열
	static boolean[][] brokeVisited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m];
		brokeVisited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++)
				map[i][j] = line.charAt(j);
		}
		BFS();
		System.out.println(-1);
	}

	/**
	 * (1, 1)에서 시작하여 (N, M)까지 BFS를 수행한다.
	 */
	public static void BFS() {
		q.add(new Point(0, 0, 1));
		visited[0][0] = true;
		// 움직인 거리를 저장하는 변수
		int distance = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			distance++;
			// 각 정점에서 한 번씩 움직인다.
			while (size-- > 0) {
				Point cur = q.poll();
				if (cur.x == map.length - 1 && cur.y == map[0].length - 1) {
					System.out.println(distance);
					System.exit(0);
				}
				for (int i = 0; i < 4; i++) {
					int nextX = cur.x + dx[i];
					int nextY = cur.y + dy[i];
					try {
						Next(cur, nextX, nextY);
					} catch (Exception e) {
					}
				}
			}
		}
	}

	/**
	 * 다음 경로를 찾아 큐에 넣는 메소드
	 * @param cur 현재 정점
	 * @param x 다음 정점의 X좌표
	 * @param y 다음 정점의 Y좌표
	 * @throws Exception 배열의 범위를 초과할 경우 에러 발생
	 */
	public static void Next(Point cur, int x, int y) throws Exception {
		// 벽을 이미 부순 경우 0인 곳만 이동할 수 있다.
		if (cur.broke == 0) {
			// 이미 벽을 부셨기 때문에 brokeVisited를 사용한다.
			if (!brokeVisited[x][y] && map[x][y] == '0') {
				q.add(new Point(x, y, 0));
				brokeVisited[x][y] = true;
			}
		}
		// 벽을 부수지 않은 경우
		// 0과 1 모두 갈 수 있고, 0인 경우는 visited를 1인 경우는 brokeVisited를 사용한다.
		else if (!visited[x][y] && map[x][y] == '0') {
			q.add(new Point(x, y, cur.broke));
			visited[x][y] = true;
		} else if (cur.broke > 0 && map[x][y] == '1') {
			q.add(new Point(x, y, cur.broke - 1));
			brokeVisited[x][y] = true;
		}
	}
}

class Point {
	int x, y, broke;

	public Point(int _x, int _y, int _broke) {
		this.x = _x;
		this.y = _y;
		this.broke = _broke;
	}
}
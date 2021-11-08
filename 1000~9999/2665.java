package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * NxN 크기의 바둑판이 있고, 이 바둑판에는 흰 방과 검은 방이 있다.
 * 검은 방은 지나갈 수 없는 방이고 흰 방은 지나갈 수 있다.
 * 하지만 흰 방을 무조건 가야하기 때문에 검은 방을 몇 개 부술수도 있다.
 * (1, 1)에서 (N, N)까지 가는데 부숴야하는 검은 방의 최소 개수를 구하는 문제 
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static int[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	/**
	 * 처음을 MaxValue로 설정해둔다.
	 * 이후 항상 부순 검은 방의 개수가 적을 경우만 들어가서 탐색하도록 한다.
	 * 
	 * Point 클래스에 부순 검은 방의 개수를 넣고, 우선순위 큐로 앞으로 땡긴 다음 처음 만나는 (N, N)을 반환해도 됨
	 * Point에 넣으면 터질 줄 알았는데, 바로 리턴하니까 안터지는듯
	 * 속도도 빠름 (테케때문인지는 잘...)
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new int[n][n];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++)
				map[i][j] = line.charAt(j) - '0';
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		bfs();
		System.out.println(visited[n - 1][n - 1]);
	}

	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));
		visited[0][0] = 0;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					// 검은 방이면 이전까지 부순 개수 +1을 해준다.
					int bomb = map[nextX][nextY] == 0 ? visited[cur.x][cur.y] + 1 : visited[cur.x][cur.y];
					// 부순 검은 방의 개수가 적을때만 들어간다.
					if (bomb < visited[nextX][nextY]) {
						q.add(new Point(nextX, nextY));
						visited[nextX][nextY] = bomb;
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
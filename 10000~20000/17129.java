package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 딱따구리 세 식구가 정보섬에 있다.
 * 이 정보섬의 2층에는 청국장, 스시, 맥앤치즈가 있다.
 * 세 식구는 가장 가까운 음식을 먹으러 가기로 했다.
 * 이 때, 어느 음식에 더 빨리 도착할 수 있는지 구하는 문제
 * 세 식구의 위치는 2, 청국장은 3, 스시는 4, 맥앤치즈는 5로 표시된다.
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int isFind = -1;

	/**
	 * 단순 BFS로 방문한 지점을 체크하며 음식일 경우 결과를 저장하고 return한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		Point start = null;
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0';
				if (map[i][j] == 2)
					start = new Point(i, j);
			}
		}
		BFS(start);
		System.out.println(isFind == -1 ? "NIE" : "TAK\n" + isFind);
	}

	public static void BFS(Point start) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		visited[start.x][start.y] = true;
		int move = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Point cur = q.poll();
				for (int i = 0; i < dx.length; i++) {
					int nextX = cur.x + dx[i];
					int nextY = cur.y + dy[i];
					try {
						if (map[nextX][nextY] == 1 || visited[nextX][nextY])
							continue;
						if (map[nextX][nextY] != 0) {
							isFind = move + 1;
							return;
						}
						q.add(new Point(nextX, nextY));
						visited[nextX][nextY] = true;
					} catch (ArrayIndexOutOfBoundsException e) {
					}
				}
			}
			move++;
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
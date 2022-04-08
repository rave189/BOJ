package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * NxM 크기의 체육관을 달리려고 한다.
 * 매 초 위, 아래, 왼쪽, 오른쪽으로 이동할 수 있고, 최소 1~K개의 빈칸을 이동할 수 있다.
 * 시작점과 도착점이 주어질 때, 최소 이동 시간을 구하는 문제
 * 도착할 수 없다면 -1을 출력한다.
 * @author Rave
 *
 */
public class Main {

	static int[][] visited;
	static char[][] map;
	static Point[] points = new Point[2];
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	/**
	 * 일반 BFS에서 조금 더 생각해야 하는 문제
	 * 방문체크를 boolean으로 하면 시간 초과가 난다.
	 * int 배열을 사용하여 현재 시간보다 이전에 방문한 지점을 발견하면 이후 지점도 이미 방문했거나 현재 시간 안에 방문할 예정이므로 break를 걸어주어야 한다.
	 * 만약 현재 시간에 방문했던 지점은 이후 지점을 다음 시간에 방문해야 하므로 현재 시간에 탐색해준다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new int[n][m];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++)
				map[i][j] = input.charAt(j);
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < points.length; i++) {
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			points[i] = new Point(x, y);
		}
		System.out.println(bfs(points[0], k));
	}

	public static int bfs(Point start, int stepLimit) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		int count = 0;
		visited[start.x][start.y] = count;
		while (!q.isEmpty()) {
			int size = q.size();
			count++;
			while (size-- > 0) {
				Point cur = q.poll();
				if (cur.equals(points[1]))
					return count - 1;
				for (int i = 0; i < dx.length; i++) {
					for (int step = 1; step <= stepLimit; step++) {
						int nextX = cur.x + dx[i] * step;
						int nextY = cur.y + dy[i] * step;
						try {
							if (map[nextX][nextY] == '#' || visited[nextX][nextY] < count)
								break;
							else if (visited[nextX][nextY] != Integer.MAX_VALUE)
								continue;
							visited[nextX][nextY] = count;
							q.add(new Point(nextX, nextY));
						} catch (ArrayIndexOutOfBoundsException e) {
							break;
						}
					}
				}
			}
		}
		return -1;
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}
}
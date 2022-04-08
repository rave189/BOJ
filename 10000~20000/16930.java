package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * NxM ũ���� ü������ �޸����� �Ѵ�.
 * �� �� ��, �Ʒ�, ����, ���������� �̵��� �� �ְ�, �ּ� 1~K���� ��ĭ�� �̵��� �� �ִ�.
 * �������� �������� �־��� ��, �ּ� �̵� �ð��� ���ϴ� ����
 * ������ �� ���ٸ� -1�� ����Ѵ�.
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
	 * �Ϲ� BFS���� ���� �� �����ؾ� �ϴ� ����
	 * �湮üũ�� boolean���� �ϸ� �ð� �ʰ��� ����.
	 * int �迭�� ����Ͽ� ���� �ð����� ������ �湮�� ������ �߰��ϸ� ���� ������ �̹� �湮�߰ų� ���� �ð� �ȿ� �湮�� �����̹Ƿ� break�� �ɾ��־�� �Ѵ�.
	 * ���� ���� �ð��� �湮�ߴ� ������ ���� ������ ���� �ð��� �湮�ؾ� �ϹǷ� ���� �ð��� Ž�����ش�.
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
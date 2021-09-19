package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * �������� �� �ı��� �������� �ִ�.
 * �� �������� 2������ û����, ����, �ƾ�ġ� �ִ�.
 * �� �ı��� ���� ����� ������ ������ ����� �ߴ�.
 * �� ��, ��� ���Ŀ� �� ���� ������ �� �ִ��� ���ϴ� ����
 * �� �ı��� ��ġ�� 2, û������ 3, ���ô� 4, �ƾ�ġ��� 5�� ǥ�õȴ�.
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
	 * �ܼ� BFS�� �湮�� ������ üũ�ϸ� ������ ��� ����� �����ϰ� return�Ѵ�.
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
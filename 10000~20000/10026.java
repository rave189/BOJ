package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ���ϻ����� ������ ����� �������� ���ϴ� ���̴�.
 * ������ ����, ���, û���� ���� ��
 * ���ϻ����� ���� ���� ������ ������ �ƴ� ����� ���� ���� ������ ������ ����ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static char[][] map;
	static Queue<Point> q = new LinkedList<>();
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	// ���� ������ ���� �� R�� G�� �̷����  ������ ����
	static int redGreenWeekness = 0;
	// ���� ������ ����
	static int red = 0;
	// ��� ������ ����
	static int green = 0;
	// û�� ������ ����
	static int blue = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++)
				map[i][j] = line.charAt(j);
		}
		// ���ϻ����� �ƴ� ����� ���� ���� ������ ������ ���Ѵ�.
		Find(false);
		// ���ϻ����� ����� ���� ���� ������ ������ ���Ѵ�.
		Find(true);
		// �Ϲ� ����� R+G+B, ���ϻ����� ��� (R+G)+B�� ����Ѵ�.
		System.out.println(String.format("%d %d", red + green + blue, redGreenWeekness + blue));
	}

	/**
	 * ���ϻ����� ����� �ƴ� ����� ���� ���� ������ ������ ���ϴ� �޼ҵ�
	 * @param isRedGreenWeekness ���ϻ����̶�� true, �ƴ϶�� false
	 */
	public static void Find(boolean isRedGreenWeekness) {
		visited = new boolean[map.length][map.length];
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map.length; j++)
				if (!visited[i][j]) {
					// ���ϻ����� ���
					if (isRedGreenWeekness) {
						// map�� ���� R �Ǵ� G�� ��� ���ϻ��� ������ ������ ������Ű�� BFS�� �����Ѵ�.
						if (map[i][j] == 'R' || map[i][j] == 'G')
							IncreaseCnt(true, ' ');
						else
							continue;
					}
					// ���ϻ����� �ƴ϶�� map�� ���� �´� ������ ������ ������Ű�� BFS�� �����Ѵ�.
					else
						IncreaseCnt(false, map[i][j]);
					BFS(isRedGreenWeekness, new Point(i, j));
				}
	}

	/**
	 * ���� ���� start�� �������� BFS Ž���� �����Ѵ�.
	 * @param isRedGreenWeekness ���ϻ����̶�� true, �ƴ϶�� false
	 * @param start Ž�� ���� ����
	 */
	public static void BFS(boolean isRedGreenWeekness, Point start) {
		char color = map[start.x][start.y];
		q.add(start);
		visited[start.x][start.y] = true;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			Search(cur, isRedGreenWeekness, color);
		}
	}

	/**
	 * ���ϻ����̸� redGreenWeekness�� ������Ű��
	 * �ƴ϶�� �� ���� �´� ������ ���� ������Ų��.
	 * @param isRedGreenWeekness ���ϻ����̶�� true, �ƴ϶�� false
	 * @param color ���ϻ����̶�� ' ', �ƴ϶�� R �Ǵ� G �Ǵ� B
	 */
	public static void IncreaseCnt(boolean isRedGreenWeekness, char color) {
		if (isRedGreenWeekness)
			redGreenWeekness++;
		else if (color == 'R')
			red++;
		else if (color == 'G')
			green++;
		else if (color == 'B')
			blue++;
	}

	/**
	 * q�� ����ִ� �����鿡 ���� 4���� Ž���� �����Ѵ�.
	 * @param cur ���� Ž���� ����
	 * @param isRedGreenWeekness ���ϻ��� �̶�� true, �ƴ϶�� false
	 * @param color ���ϻ����̶�� ' ', �ƴ϶�� R �Ǵ� G �Ǵ� B
	 */
	public static void Search(Point cur, boolean isRedGreenWeekness, char color) {
		for (int i = 0; i < 4; i++) {
			int nextX = cur.x + dx[i];
			int nextY = cur.y + dy[i];
			try {
				if (!visited[nextX][nextY]) {
					if (isRedGreenWeekness) {
						if (!(map[nextX][nextY] == 'R' || map[nextX][nextY] == 'G'))
							continue;
					} else if (map[nextX][nextY] != color)
						continue;
					q.add(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			} catch (Exception e) {
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
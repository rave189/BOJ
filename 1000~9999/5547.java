package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * ������������ �̷���� �迭�� �ְ�, �迭�� ������ ���� ��ġ�ȴ�.
 *  0 1 0 1 0 1 1 1
 * 0 1 1 0 0 1 0 0
 *  1 0 1 0 1 1 1 1
 * 0 1 1 0 1 0 1 0
 * ���⼭ 1�� �ǹ��̰�, 0�� �� �����̴�.
 * �� �ǹ��� �ܺ��� ������ ��ġ�Ϸ��� �Ѵ�.
 * �ܺ��� ������ ���� ���ϴ� ����
 * �� ��ġ���� (2, 1)�� 0�� �ֺ��� ��� 1�� �ѷ��׿� �ִ�.
 * �� 0�� �ֺ� ���� �������� �ܺ��� �ƴϱ� ������ ������ ��ġ���� �ʴ´�.
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int answer = 0;
	// ��ġ�� ���� Ȧ�� ��� ¦�� ���� �ֺ��� �ٸ��Ƿ� �ٸ� dx, dy�� ����Ѵ�.
	static int[] dxEven = { -1, -1, 0, 1, 1, 0 };
	static int[] dyEven = { 0, 1, 1, 1, 0, -1 };
	static int[] dxOdd = { -1, -1, 0, 1, 1, 0 };
	static int[] dyOdd = { -1, 0, 1, 0, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		visited = new boolean[h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++) {
				// �湮 �߰ų� ������ �ƴ� �� ������ ��� �Ѿ��.
				if (visited[i][j] || map[i][j] == -1)
					continue;
				// �ǹ��� �ѷ��� ���̸� �����ش�.
				if (map[i][j] == 1)
					answer += countOuterWall(new Point(i, j));
				else {
					int result = countInnerWall(new Point(i, j));
					// �ǹ��� ������ ��� �ѷ��� ���̿��� ������ ���̸� ���ش�.
					if (result != -1)
						answer -= result;
				}
			}
		System.out.println(answer);
	}

	/**
	 * �ǹ��� �ѷ��� ���̸� ���ϴ� �޼ҵ�
	 * @param start ���� ����
	 * @return �ǹ��� �ѷ��� ����
	 */
	public static int countOuterWall(Point start) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		visited[start.x][start.y] = true;
		int total = 0;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			int arround = 0;
			for (int i = 0; i < dxOdd.length; i++) {
				int nextX, nextY;
				if (cur.x % 2 == 0) {
					nextX = cur.x + dxEven[i];
					nextY = cur.y + dyEven[i];
				} else {
					nextX = cur.x + dxOdd[i];
					nextY = cur.y + dyOdd[i];
				}
				try {
					if (map[nextX][nextY] == 1)
						arround++;
					if (map[nextX][nextY] < 1 || visited[nextX][nextY])
						continue;
					q.add(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
			// ���������� �ֺ� 1�� ������ ���� �ǹ��� �ѷ��� ���̰� ���´�.
			total += 6 - arround;
		}
		return total;
	}

	/**
	 * �ǹ��� ������ ���̸� ���Ѵ�.
	 * ������ �ƴ� �� ������ ��� -1�� �����Ѵ�.
	 * @param cur ���� ����
	 * @return �� ������ ��� -1, ������ ��� ������ ����
	 */
	public static int countInnerWall(Point cur) {
		visited[cur.x][cur.y] = true;
		int count = 0;
		for (int i = 0; i < dxOdd.length; i++) {
			int nextX, nextY;
			if (cur.x % 2 == 0) {
				nextX = cur.x + dxEven[i];
				nextY = cur.y + dyEven[i];
			} else {
				nextX = cur.x + dxOdd[i];
				nextY = cur.y + dyOdd[i];
			}
			try {
				// �� ������ ��� -1�� �����Ѵ�.
				if (map[nextX][nextY] == -1)
					return map[cur.x][cur.y] = -1;
				// �ֺ� 1�� ������ �� ������ �����̴�.
				if (map[nextX][nextY] == 1)
					count++;
				else if (visited[nextX][nextY])
					continue;
				else {
					// ���� ������ ������ ���̸� ���Ѵ�.
					int result = countInnerWall(new Point(nextX, nextY));
					// �� ������ ��� -1�� �����Ѵ�.
					if (result == -1)
						return map[cur.x][cur.y] = -1;
					// �� ������ �ƴϸ� ������ �����̹Ƿ� count�� �����ش�.
					count += result;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				return map[cur.x][cur.y] = -1;
			}
		}
		return count;
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
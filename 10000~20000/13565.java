package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * ������ ���κп��� ������ ħ���Ѵ�.
 * ������ ������ �Ʒ��ʱ��� ħ���� �� �ִ��� ���ϴ� ����
 * ������ ������ 0�� �κ��� �̵��� �� �ְ�, 1�� �κ����δ� �̵��� �� ����.
 * @author Rave
 *
 */
public class Main {

	static Queue<Point> q = new LinkedList<>();
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	/**
	 * i�� 0�� �������� ���� 0�� �κ��� ��� ť�� �ִ´�.
	 * ���� ������ ������ 2�� �ٲٸ鼭 �ʺ� �켱 Ž���� �Ѵ�.
	 * Ž���� ����Ǹ� n-1���������� ���� 2�� ������ YES �ƴ϶�� NO�� ����Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0';
				// ������ ħ���� �� �ִ� ������ ��� ť�� �ִ´�.
				if (i == 0 && map[i][j] == 0)
					q.add(new Point(i, j));
			}
		}
		// �ʺ�켱 Ž��
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					if (map[nextX][nextY] == 0) {
						map[nextX][nextY] = 2;
						q.add(new Point(nextX, nextY));
					}
				} catch (Exception e) {
				}
			}
		}
		// ������ ���� �Ʒ��ʱ��� ħ�������� YES �ƴ϶�� NO�� ����Ѵ�.
		while (--m > 0)
			if (map[n - 1][m] == 2) {
				System.out.println("YES");
				return;
			}
		System.out.println("NO");
	}
}

class Point {
	int x, y;

	public Point(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * �� ������ ������ �� �κк� ���̰� �־�����.
 * ���� �̿��� ���� 0�� �־��� ��, ������ ���� �³�ȭ�� ���� ���������� 0�� ���� ��ŭ ���̰� �����Ѵ�.
 * �� �� �� ������ ������ �� ���� �̻����� �ɰ����µ� �ɸ� ������ �ظ� ����ϴ� ����
 * @author Rave
 *
 */
public class Main {

	// ������ ������ ť
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
				// ������ ť�� �����Ѵ�.
				if (map[i][j] > 0)
					icebergs.add(new Point(i, j));
			}
		}
		int answer = 0;
		while (!icebergs.isEmpty()) {
			// 1���� ������ ������ ��´�.
			answer++;
			IceMelt();
			// �� ���� �̻��� �Ǿ����� Ȯ���ϰ� �� ���� �̻��̶�� �ɸ� �⵵�� ����ϰ� �����Ѵ�.
			if (isDivide()) {
				System.out.println(answer);
				return;
			}
		}
		System.out.println(0);
	}

	/**
	 * ������ 1���� ���� �ֺ��� 0�� ������ŭ ��´�.
	 */
	public static void IceMelt() {
		// map�� �����ϸ� 0�� ������ �޶����� ������ �ӽ� �迭�� �����Ѵ�.
		int[][] tmp = new int[map.length][map[0].length];
		int size = icebergs.size();
		// �ʱ� ũ�� ��ŭ�� ������ ��´�.
		while (size-- > 0) {
			Point iceberg = icebergs.poll();
			// 0�� ������ ����.
			int zeroCnt = 0;
			for (int i = 0; i < 4; i++) {
				try {
					if (map[iceberg.x + dx[i]][iceberg.y + dy[i]] == 0)
						zeroCnt++;
				} catch (Exception e) {
				}
			}
			// ���� ���� 0�� ������ ���� �� 0���� ũ�ٸ� tmp�� ������ �� ť�� �ٽ� �ִ´�.
			if (map[iceberg.x][iceberg.y] - zeroCnt > 0) {
				tmp[iceberg.x][iceberg.y] = map[iceberg.x][iceberg.y] - zeroCnt;
				icebergs.add(iceberg);
			}
		}
		map = tmp;
	}

	/**
	 * ������ �� ���� �̻��� ����� Ȯ���ϴ� �޼ҵ�
	 * @return �� ���� �̻��̶�� true, �ƴ϶�� false
	 */
	public static boolean isDivide() {
		visited = new boolean[map.length][map[0].length];
		int icebergCnt = 0;
		// ť�� ����ִ� ������ �ϳ��� Ž���غ���.
		for (Point iceberg : icebergs) {
			if (!visited[iceberg.x][iceberg.y]) {
				// ������ �� if�� ���� 2�� ���� ��� �� ���� �̻��̹Ƿ� true�� ��ȯ�Ѵ�.
				if (icebergCnt == 1)
					return true;
				icebergCnt++;
				BFS(iceberg);
			}
		}
		return false;
	}

	/**
	 * ���� ������ �޾� BFS�� �����ϴ� �޼ҵ�
	 * @param start ���� ����
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
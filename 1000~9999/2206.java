package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 0�� �̵� ������ ����, 1�� ������ ǥ���� ������ �־�����.
 * �� �������� ���� �� �� ������ �μ��鼭 (1, 1)���� (N, M)���� ���� �ִ� �Ÿ��� ����ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static Queue<Point> q = new LinkedList<>();
	static char[][] map;
	// ���� �μ��� �ʾ��� �� ����ϴ� �湮 üũ �迭
	static boolean[][] visited;
	// ���� �μ����� �� ����ϴ� �湮 üũ �迭
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
	 * (1, 1)���� �����Ͽ� (N, M)���� BFS�� �����Ѵ�.
	 */
	public static void BFS() {
		q.add(new Point(0, 0, 1));
		visited[0][0] = true;
		// ������ �Ÿ��� �����ϴ� ����
		int distance = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			distance++;
			// �� �������� �� ���� �����δ�.
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
	 * ���� ��θ� ã�� ť�� �ִ� �޼ҵ�
	 * @param cur ���� ����
	 * @param x ���� ������ X��ǥ
	 * @param y ���� ������ Y��ǥ
	 * @throws Exception �迭�� ������ �ʰ��� ��� ���� �߻�
	 */
	public static void Next(Point cur, int x, int y) throws Exception {
		// ���� �̹� �μ� ��� 0�� ���� �̵��� �� �ִ�.
		if (cur.broke == 0) {
			// �̹� ���� �μ̱� ������ brokeVisited�� ����Ѵ�.
			if (!brokeVisited[x][y] && map[x][y] == '0') {
				q.add(new Point(x, y, 0));
				brokeVisited[x][y] = true;
			}
		}
		// ���� �μ��� ���� ���
		// 0�� 1 ��� �� �� �ְ�, 0�� ���� visited�� 1�� ���� brokeVisited�� ����Ѵ�.
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
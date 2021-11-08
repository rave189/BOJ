package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * NxN ũ���� �ٵ����� �ְ�, �� �ٵ��ǿ��� �� ��� ���� ���� �ִ�.
 * ���� ���� ������ �� ���� ���̰� �� ���� ������ �� �ִ�.
 * ������ �� ���� ������ �����ϱ� ������ ���� ���� �� �� �μ����� �ִ�.
 * (1, 1)���� (N, N)���� ���µ� �ν����ϴ� ���� ���� �ּ� ������ ���ϴ� ���� 
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static int[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	/**
	 * ó���� MaxValue�� �����صд�.
	 * ���� �׻� �μ� ���� ���� ������ ���� ��츸 ���� Ž���ϵ��� �Ѵ�.
	 * 
	 * Point Ŭ������ �μ� ���� ���� ������ �ְ�, �켱���� ť�� ������ ���� ���� ó�� ������ (N, N)�� ��ȯ�ص� ��
	 * Point�� ������ ���� �� �˾Ҵµ�, �ٷ� �����ϴϱ� �������µ�
	 * �ӵ��� ���� (���ɶ��������� ��...)
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
					// ���� ���̸� �������� �μ� ���� +1�� ���ش�.
					int bomb = map[nextX][nextY] == 0 ? visited[cur.x][cur.y] + 1 : visited[cur.x][cur.y];
					// �μ� ���� ���� ������ �������� ����.
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
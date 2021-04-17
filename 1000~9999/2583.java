package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * �� ���̿� K���� ���簢���� �׸� ��,
 * K���� ���簢�� �ܺ��� �и��� ������ ������ ������ ���̸� ���ϴ� ����
 * ���̴� ������������ ����Ѵ�.
 */
public class Main {

	static boolean[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	// ���̸� ������������ ����ϱ� ���� �켱���� ť
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new boolean[n][m];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			// (x1,y1) ~ (x2, y2)���� ��� ���� true�� �ٲ۴�.
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			for (int j = x1; j < x2; j++)
				for (int t = y1; t < y2; t++)
					map[j][t] = true;
		}
		int count = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				// �ܺ��� ������ �߰��� ������ count+1�� ���ְ� BFS�� ���� ���̸� ���Ѵ�.
				if (!map[i][j]) {
					count++;
					BFS(new Point(i, j));
				}
		sb.append(count + "\n");
		while (!pq.isEmpty())
			sb.append(pq.poll() + " ");
		System.out.println(sb);
	}

	/**
	 * ���� ������ ���ڷ� �޾� ���簢�� �ܺ��� ���̸� ���ϴ� �޼ҵ�
	 * @param start ���� ����
	 */
	public static void BFS(Point start) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		map[start.x][start.y] = true;
		int sum = 0;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			sum++;
			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					if (!map[nextX][nextY]) {
						q.add(new Point(nextX, nextY));
						map[nextX][nextY] = true;
					}
				} catch (Exception e) {
				}
			}
		}
		pq.add(sum);
	}
}

class Point {
	int x, y;

	public Point(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}
}
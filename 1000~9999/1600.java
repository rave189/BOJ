package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * �����̰� (1,1)���� (H, W)���� �̵��Ϸ��� �Ѵ�.
 * �����̴� ���� ������ �� �־, K�� ���� �������� ������ �� �ִ�.
 * �����̰� ���������� �����̴� ������ �ּڰ��� ���ϴ� ���� �������� ���ϸ� -1�� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	static Queue<Point> q = new LinkedList<>();
	// ������ k�� ������ ���� ������ ���¸� �����ϴ� 3���� �迭
	static boolean[][][] map;
	// map�� �湮 ���θ� Ȯ���ϴ� 3���� �迭
	static boolean[][][] visited;
	// ���� ������
	static int[] dxH = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dyH = { 1, 2, 2, 1, -1, -2, -2, -1 };
	// �������� ������
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		map = new boolean[k + 1][h][w];
		visited = new boolean[k + 1][h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++)
				map[k][i][j] = st.nextToken().equals("1") ? true : false;
		}
		q.add(new Point(0, 0, k));
		visited[k][0][0] = true;
		int answer = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Point cur = q.poll();
				if (cur.x == h - 1 && cur.y == w - 1) {
					System.out.println(answer);
					return;
				}
				MoveLikeHorse(cur);
				MoveMonkey(cur);
			}
			answer++;
		}
		System.out.println(-1);
	}

	/**
	 * �����̰� ���� �������� �����Ͽ� �����ϴ� ������ Ž���ϴ� �޼ҵ�
	 * @param cur ���� �������� ����
	 */
	public static void MoveLikeHorse(Point cur) {
		for (int i = 0; i < 8; i++) {
			int nextX = cur.x + dxH[i];
			int nextY = cur.y + dyH[i];
			try {
				// ������ ���´� map[k]�� �����Ͽ��� ������ map�� ���� �񱳴� map.length-1�� ���Ѵ�.
				// ���� �������� �����ϹǷ� k-1 �迭�� (x, y)������ �湮�ߴ��� Ȯ���Ѵ�.
				if (!map[map.length - 1][nextX][nextY] && !visited[cur.k - 1][nextX][nextY]) {
					q.add(new Point(nextX, nextY, cur.k - 1));
					visited[cur.k - 1][nextX][nextY] = true;
				}
			} catch (Exception e) {
			}
		}
	}

	/**
	 * �����̰� �������� ���������� �����ϴ� ������ Ž���ϴ� �޼ҵ�
	 * @param cur ���� �������� ����
	 */
	public static void MoveMonkey(Point cur) {
		for (int i = 0; i < 4; i++) {
			int nextX = cur.x + dx[i];
			int nextY = cur.y + dy[i];
			try {
				// ���������� map[k]�� ���¿� ���ϰ� k�϶��� (x, y) ������ �湮 ���θ� Ȯ���Ѵ�.
				if (!map[map.length - 1][nextX][nextY] && !visited[cur.k][nextX][nextY]) {
					q.add(new Point(nextX, nextY, cur.k));
					visited[cur.k][nextX][nextY] = true;
				}
			} catch (Exception e) {
			}
		}
	}
}

class Point {
	int x, y, k;

	public Point(int _x, int _y, int _k) {
		this.x = _x;
		this.y = _y;
		this.k = _k;
	}

	public String toString() {
		return k + " " + x + " " + y;
	}
}
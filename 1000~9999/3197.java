package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * ȣ������ �� ������ ������ ��� �ְ�, �������� ���� ���� ������ ���Ѵ�.
 * �ֺ� ���� ������������ ������ ������ ���� ��´�.
 * �� ������ ������ �������� �ּ� ��ĥ�� �������ϴ��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static char[][] map;
	static boolean[][] visited;
	// ���� ��ġ�� ������ ť
	static Queue<Point> waters = new LinkedList<>();
	// ������ ��ġ�� ������ �迭
	static ArrayList<Point> Swans = new ArrayList<>();
	// ������ BFS�� ������ �迭
	static Queue<Point> q = new LinkedList<>();
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == '.')
					waters.add(new Point(i, j));
				else if (map[i][j] == 'L') {
					Swans.add(new Point(i, j));
					// ������ �ִ� ������ ���� �Ǵ��ϱ� ������ waters�� �־��ش�.
					waters.add(new Point(i, j));
				}
			}
		}
		// ù ��° ������ ť�� �ְ� ����
		Point start = Swans.get(0);
		q.add(start);
		visited[start.x][start.y] = true;
		int answer = 1;
		while (!q.isEmpty()) {
			// �Ϸ簡 �������Ƿ� ������ ��´�.
			IceMelt();
			// ������ ���� ���� �� �ִ��� Ȯ���Ѵ�.
			if (isFindDuck()) {
				System.out.println(answer);
				return;
			}
			// �������� �ȴ�.
			answer++;
		}
	}

	/**
	 * ���� ������ ������ ���̴� �޼ҵ�
	 */
	public static void IceMelt() {
		// ������ ���� �� ���� �ڸ��� nextQ�� �����Ѵ�.
		Queue<Point> nextQ = new LinkedList<>();
		while (!waters.isEmpty()) {
			Point cur = waters.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					if (map[nextX][nextY] == 'X') {
						// ������ �ڸ��� ���� �ٲٰ� nextQ�� ����
						nextQ.add(new Point(nextX, nextY));
						map[nextX][nextY] = '.';
					}
				} catch (Exception e) {
				}
			}
		}
		// waters�� nextQ�� �ٲ� ������ ���� ������ �����ϵ��� �Ѵ�.
		waters = nextQ;
	}

	/**
	 * �� ������ ������ ���� ���� �� �ִ��� Ȯ���ϴ� �޼ҵ�
	 * BFS�� �����Ͽ� ���� �� �ִ��� Ȯ���Ѵ�.
	 * @return ������ ���� �����ٸ� true, �ƴ϶�� false
	 */
	public static boolean isFindDuck() {
		// Ž���� ��� ������ nextQ�� �����Ͽ� ������ ������ ������ �����Ѵ�.
		Queue<Point> nextQ = new LinkedList<>();
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					if (!visited[nextX][nextY]) {
						// ������ �����ٸ� true�� ��ȯ�Ѵ�.
						if (map[nextX][nextY] == 'L')
							return true;
						else if (map[nextX][nextY] == '.') {
							// ������ �̵��ϸ� ������ ��� ������ ť�� nextQ�� �ִ´�.
							nextQ.add(new Point(nextX, nextY));
							q.add(new Point(nextX, nextY));
							visited[nextX][nextY] = true;
						}
					}
				} catch (Exception e) {
				}
			}
		}
		// ť�� ������ ������ ������� �����Ѵ�.
		q = nextQ;
		return false;
	}
}

class Point {
	int x, y;

	public Point(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}
}
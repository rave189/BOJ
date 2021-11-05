package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * �ѿ�ѿ��� ���°� �־����� �� �� ���Ⱑ �Ͼ���� ���ϴ� ����
 * �ѿ�ѿ�� ��, ��, ��, ��� 4�� �̻��� ����Ǹ� ������.
 * ���� �� �ִ� �ѿ�ѿ䰡 ���� �׷��̶�� �� ���� ��Ʈ����.
 * @author Rave
 *
 */
public class Main {

	static char[][] map = new char[12][6];
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int count = 0;
	static boolean[][] visited;
	static ArrayList<Point> removeList = new ArrayList<>();

	/**
	 * �ѿ�ѿ䰡 4�� �̻� �𿴴��� Ȯ���ϰ�, �𿴴ٸ� ��Ʈ����.
	 * ���� �ѿ�ѿ並 ��� �߷¿� ���� �Ʒ��� �������.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < map.length; i++) {
			String line = br.readLine();
			for (int j = 0; j < map[0].length; j++)
				map[i][j] = line.charAt(j);
		}
		int answer = 0;
		while (true) {
			visited = new boolean[map.length][map[0].length];
			// �ѿ�ѿ䰡 �����ٸ� ���⸦ ������Ű�� �߷¿� ���� ���� �ѿ�ѿ並 �������.
			// ���Ⱑ ����Ǹ� while�� ����
			if (isBomb()) {
				answer++;
				gravityPuyo();
			} else
				break;
		}
		System.out.println(answer);
	}

	public static boolean isBomb() {
		boolean isBomb = false;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == '.')
					continue;
				// �׷��� 4�� �̻��� �ѿ�ѿ�� �����Ǿ� �ִ��� Ȯ���Ѵ�.
				BFS(new Point(i, j), map[i][j]);
				// 4�� �̻��̶�� ��Ʈ����.
				if (removeList.size() >= 4) {
					removePuyo();
					isBomb = true;
				}
				removeList.clear();
			}
		}
		return isBomb;
	}

	public static void BFS(Point start, char type) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		removeList.add(start);
		visited[start.x][start.y] = true;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					if (visited[nextX][nextY] || map[nextX][nextY] == '.' || map[nextX][nextY] != type)
						continue;
					Point next = new Point(nextX, nextY);
					visited[nextX][nextY] = true;
					q.add(next);
					removeList.add(next);
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		}
	}

	public static void removePuyo() {
		for (Point cur : removeList)
			map[cur.x][cur.y] = '.';
	}

	public static void gravityPuyo() {
		for (int i = 0; i < map[0].length; i++) {
			for (int j = map.length - 1; j >= 0; j--) {
				if (map[j][i] != '.')
					continue;
				for (int t = j - 1; t >= 0; t--) {
					if (map[t][i] != '.') {
						map[j][i] = map[t][i];
						map[t][i] = '.';
						break;
					}
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
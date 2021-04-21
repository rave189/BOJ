package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * ���� �� �� �̻� �־�����.
 * 1�� ������, 0�� �ٴٸ� �ǹ��Ѵ�.
 * �� �� ���̿� �ٸ��� �������� �� ��, �ٸ��� ���̰� ���� ª�� ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static Queue<Point>[] island;
	static int[][] map;
	static int group = 1;
	static boolean[][][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		Grouping();
		islandSet();
		for (int i = 0; i < group; i++)
			BridgeBFS(island[i], i + 1);
		System.out.println(answer);
	}

	/**
	 * ���� ������ �׷����� ������ �ִ� �޼ҵ�
	 * 0�� �ƴ� ���� �߰��ϸ� BFS�� �����Ͽ� ���� �׷�ȭ�Ѵ�.
	 */
	public static void Grouping() {
		boolean[][] tmpVisited = new boolean[map.length][map.length];
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map.length; j++)
				if (!tmpVisited[i][j] && map[i][j] != 0) {
					tmpVisited[i][j] = true;
					BFS(tmpVisited, new Point(i, j));
					group++;
				}
	}

	/**
	 * ���� �׷��� ����������� ���ϴ� �޼ҵ�
	 * @param tmpVisited ���� ������ ���� �ӽ� �湮 üũ �迭
	 * @param start ���� ����
	 */
	public static void BFS(boolean[][] tmpVisited, Point start) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		while (!q.isEmpty()) {
			Point cur = q.poll();
			map[cur.x][cur.y] = group;
			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					if (!tmpVisited[nextX][nextY] && map[nextX][nextY] == 1) {
						q.add(new Point(nextX, nextY));
						tmpVisited[nextX][nextY] = true;
					}
				} catch (Exception e) {
				}
			}
		}
	}

	/**
	 * ������ ���� �׷� ���� �ٸ� ť�� �ִ´�.
	 */
	public static void islandSet() {
		visited = new boolean[group][map.length][map.length];
		island = new LinkedList[group];
		for (int i = 0; i < group; i++)
			island[i] = new LinkedList<>();
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map.length; j++)
				if (map[i][j] != 0) {
					island[map[i][j] - 1].add(new Point(i, j));
					visited[map[i][j] - 1][i][j] = true;
				}
	}

	/**
	 * �� �ϳ��� ť�� �Է����� �޾� �ٸ��� �Ǽ��غ���.
	 * ���� ���� �ٸ� ���� ������ answer�� ���Ͽ� �� ���� ���� answer�� �ִ´�.
	 * @param q �� �ϳ��� ť
	 * @param num ���� �׷� ��ȣ
	 */
	public static void BridgeBFS(Queue<Point> q, int num) {
		int distance = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Point cur = q.poll();
				if (map[cur.x][cur.y] != 0 && map[cur.x][cur.y] != num) {
					answer = Math.min(answer, distance - 1);
					return;
				}
				for (int i = 0; i < 4; i++) {
					int nextX = cur.x + dx[i];
					int nextY = cur.y + dy[i];
					try {
						if (map[nextX][nextY] != num && !visited[num - 1][nextX][nextY]) {
							q.add(new Point(nextX, nextY));
							visited[num - 1][nextX][nextY] = true;
						}
					} catch (Exception e) {
					}
				}
			}
			distance++;
		}
	}
}

class Point {
	int x, y;

	public Point(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}
}
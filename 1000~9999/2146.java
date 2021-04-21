package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 섬이 두 개 이상 주어진다.
 * 1은 육지를, 0은 바다를 의미한다.
 * 이 섬 사이에 다리를 놓으려고 할 때, 다리의 길이가 가장 짧은 것을 구하는 문제
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
	 * 섬을 각각의 그룹으로 나누어 주는 메소드
	 * 0이 아닌 값을 발견하면 BFS를 수행하여 섬을 그룹화한다.
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
	 * 섬의 그룹이 어느정도인지 구하는 메소드
	 * @param tmpVisited 섬의 면적을 구할 임시 방문 체크 배열
	 * @param start 시작 지점
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
	 * 각각의 섬을 그룹 별로 다른 큐에 넣는다.
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
	 * 섬 하나의 큐를 입력으로 받아 다리를 건설해본다.
	 * 가장 먼저 다른 섬을 만나면 answer과 비교하여 더 작은 쪽을 answer에 넣는다.
	 * @param q 섬 하나의 큐
	 * @param num 섬의 그룹 번호
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
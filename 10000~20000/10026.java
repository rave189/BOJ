package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 적록색약은 적색과 녹색을 구분하지 못하는 것이다.
 * 지도에 적색, 녹색, 청색이 있을 때
 * 적록색약이 봤을 때의 구역의 개수와 아닌 사람이 봤을 때의 구역의 개수를 출력하는 문제
 * @author Rave
 *
 */
public class Main {

	static char[][] map;
	static Queue<Point> q = new LinkedList<>();
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	// 적록 색약이 봤을 때 R과 G로 이루어진  구역의 개수
	static int redGreenWeekness = 0;
	// 적색 구역의 개수
	static int red = 0;
	// 녹색 구역의 개수
	static int green = 0;
	// 청색 구역의 개수
	static int blue = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++)
				map[i][j] = line.charAt(j);
		}
		// 적록색약이 아닌 사람이 봤을 때의 구역의 개수를 구한다.
		Find(false);
		// 적록색약인 사람이 봤을 때의 구역의 개수를 구한다.
		Find(true);
		// 일반 사람은 R+G+B, 적록색약의 경우 (R+G)+B를 출력한다.
		System.out.println(String.format("%d %d", red + green + blue, redGreenWeekness + blue));
	}

	/**
	 * 적록색약인 사람과 아닌 사람이 봤을 때의 구역의 개수를 구하는 메소드
	 * @param isRedGreenWeekness 적록색약이라면 true, 아니라면 false
	 */
	public static void Find(boolean isRedGreenWeekness) {
		visited = new boolean[map.length][map.length];
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map.length; j++)
				if (!visited[i][j]) {
					// 적록색약인 경우
					if (isRedGreenWeekness) {
						// map의 값이 R 또는 G인 경우 적록색약 구역의 개수를 증가시키고 BFS를 수행한다.
						if (map[i][j] == 'R' || map[i][j] == 'G')
							IncreaseCnt(true, ' ');
						else
							continue;
					}
					// 적록색약이 아니라면 map의 값에 맞는 구역의 개수를 증가시키고 BFS를 수행한다.
					else
						IncreaseCnt(false, map[i][j]);
					BFS(isRedGreenWeekness, new Point(i, j));
				}
	}

	/**
	 * 시작 지점 start를 기준으로 BFS 탐색을 수행한다.
	 * @param isRedGreenWeekness 적록색약이라면 true, 아니라면 false
	 * @param start 탐색 시작 지점
	 */
	public static void BFS(boolean isRedGreenWeekness, Point start) {
		char color = map[start.x][start.y];
		q.add(start);
		visited[start.x][start.y] = true;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			Search(cur, isRedGreenWeekness, color);
		}
	}

	/**
	 * 적록색약이면 redGreenWeekness를 증가시키고
	 * 아니라면 각 색깔에 맞는 변수의 값을 증가시킨다.
	 * @param isRedGreenWeekness 적록색약이라면 true, 아니라면 false
	 * @param color 적록색약이라면 ' ', 아니라면 R 또는 G 또는 B
	 */
	public static void IncreaseCnt(boolean isRedGreenWeekness, char color) {
		if (isRedGreenWeekness)
			redGreenWeekness++;
		else if (color == 'R')
			red++;
		else if (color == 'G')
			green++;
		else if (color == 'B')
			blue++;
	}

	/**
	 * q에 들어있는 지점들에 대한 4방향 탐색을 수행한다.
	 * @param cur 현재 탐색할 지점
	 * @param isRedGreenWeekness 적록색약 이라면 true, 아니라면 false
	 * @param color 적록색약이라면 ' ', 아니라면 R 또는 G 또는 B
	 */
	public static void Search(Point cur, boolean isRedGreenWeekness, char color) {
		for (int i = 0; i < 4; i++) {
			int nextX = cur.x + dx[i];
			int nextY = cur.y + dy[i];
			try {
				if (!visited[nextX][nextY]) {
					if (isRedGreenWeekness) {
						if (!(map[nextX][nextY] == 'R' || map[nextX][nextY] == 'G'))
							continue;
					} else if (map[nextX][nextY] != color)
						continue;
					q.add(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			} catch (Exception e) {
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
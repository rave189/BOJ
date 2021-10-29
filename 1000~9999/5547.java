package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 정육각형으로 이루어진 배열이 있고, 배열은 다음과 같이 배치된다.
 *  0 1 0 1 0 1 1 1
 * 0 1 1 0 0 1 0 0
 *  1 0 1 0 1 1 1 1
 * 0 1 1 0 1 0 1 0
 * 여기서 1은 건물이고, 0은 빈 공간이다.
 * 이 건물의 외벽에 조명을 설치하려고 한다.
 * 외벽의 길이의 합을 구하는 문제
 * 위 배치에서 (2, 1)의 0은 주변이 모두 1로 둘러쌓여 있다.
 * 이 0의 주변 벽은 내벽으로 외벽이 아니기 때문에 조명을 설치하지 않는다.
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int answer = 0;
	// 배치를 보면 홀수 행과 짝수 행의 주변이 다르므로 다른 dx, dy를 사용한다.
	static int[] dxEven = { -1, -1, 0, 1, 1, 0 };
	static int[] dyEven = { 0, 1, 1, 1, 0, -1 };
	static int[] dxOdd = { -1, -1, 0, 1, 1, 0 };
	static int[] dyOdd = { -1, 0, 1, 0, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		visited = new boolean[h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++) {
				// 방문 했거나 내벽이 아닌 빈 공간인 경우 넘어간다.
				if (visited[i][j] || map[i][j] == -1)
					continue;
				// 건물의 둘레의 길이를 더해준다.
				if (map[i][j] == 1)
					answer += countOuterWall(new Point(i, j));
				else {
					int result = countInnerWall(new Point(i, j));
					// 건물이 내벽인 경우 둘레의 길이에서 내벽의 길이를 빼준다.
					if (result != -1)
						answer -= result;
				}
			}
		System.out.println(answer);
	}

	/**
	 * 건물의 둘레의 길이를 구하는 메소드
	 * @param start 시작 지점
	 * @return 건물의 둘레의 길이
	 */
	public static int countOuterWall(Point start) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		visited[start.x][start.y] = true;
		int total = 0;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			int arround = 0;
			for (int i = 0; i < dxOdd.length; i++) {
				int nextX, nextY;
				if (cur.x % 2 == 0) {
					nextX = cur.x + dxEven[i];
					nextY = cur.y + dyEven[i];
				} else {
					nextX = cur.x + dxOdd[i];
					nextY = cur.y + dyOdd[i];
				}
				try {
					if (map[nextX][nextY] == 1)
						arround++;
					if (map[nextX][nextY] < 1 || visited[nextX][nextY])
						continue;
					q.add(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
			// 육각형에서 주변 1의 개수를 빼면 건물의 둘레의 길이가 나온다.
			total += 6 - arround;
		}
		return total;
	}

	/**
	 * 건물의 내벽의 길이를 구한다.
	 * 내벽이 아닌 빈 공간인 경우 -1을 리턴한다.
	 * @param cur 현재 지점
	 * @return 빈 공간인 경우 -1, 내벽인 경우 내벽의 길이
	 */
	public static int countInnerWall(Point cur) {
		visited[cur.x][cur.y] = true;
		int count = 0;
		for (int i = 0; i < dxOdd.length; i++) {
			int nextX, nextY;
			if (cur.x % 2 == 0) {
				nextX = cur.x + dxEven[i];
				nextY = cur.y + dyEven[i];
			} else {
				nextX = cur.x + dxOdd[i];
				nextY = cur.y + dyOdd[i];
			}
			try {
				// 빈 공간인 경우 -1을 리턴한다.
				if (map[nextX][nextY] == -1)
					return map[cur.x][cur.y] = -1;
				// 주변 1의 개수가 곧 내벽의 길이이다.
				if (map[nextX][nextY] == 1)
					count++;
				else if (visited[nextX][nextY])
					continue;
				else {
					// 다음 지점의 내벽의 길이를 구한다.
					int result = countInnerWall(new Point(nextX, nextY));
					// 빈 공간인 경우 -1을 리턴한다.
					if (result == -1)
						return map[cur.x][cur.y] = -1;
					// 빈 공간이 아니면 내벽의 길이이므로 count에 더해준다.
					count += result;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				return map[cur.x][cur.y] = -1;
			}
		}
		return count;
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
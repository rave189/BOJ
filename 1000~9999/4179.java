package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 미로에 갇힌 지훈이가 탈출하려고 한다.
 * 미로에는 불이 붙어있어 불에 타기전에 탈출해야 한다.
 * 불과 지훈이는 매 분마다 수평 또는 수직으로 이동한다.
 * 아무곳이나 미로에 바깥을 만나면 탈출할 수 있다.
 * 지훈이가 탈출할 수 없다면 IMPOSSIBLE을 출력하고
 * 탈출할 수 있다면 가장 빠른 탈출시간을 출력하는 문제
 * @author Rave
 *
 */
public class Main {

	static char[][] map;
	static Queue<Point> jihun = new LinkedList<>();
	static Queue<Point> fire = new LinkedList<>();
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			String line = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'J')
					jihun.add(new Point(i, j));
				else if (map[i][j] == 'F')
					fire.add(new Point(i, j));
			}
		}
		System.out.println(BFS());
	}

	public static String BFS() {
		int count = 0;
		while (!jihun.isEmpty()) {
			count++;
			// 불부터 이동시켜 지훈이가 못가는 곳을 미리 차단한다.
			moveFire();
			// 지훈이가 움직이고 탈출할 수 있다면 시간을 반환
			if (moveJihun())
				return count + "";
		}
		return "IMPOSSIBLE";
	}

	public static void moveFire() {
		int size = fire.size();
		while (size-- > 0) {
			Point cur = fire.poll();
			for (int i = 0; i < dx.length; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					if (map[nextX][nextY] == '#' || map[nextX][nextY] == 'F')
						continue;
					map[nextX][nextY] = 'F';
					fire.add(new Point(nextX, nextY));
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		}
	}

	public static boolean moveJihun() {
		int size = jihun.size();
		while (size-- > 0) {
			Point cur = jihun.poll();
			for (int i = 0; i < dx.length; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					if (map[nextX][nextY] == '#' || map[nextX][nextY] == 'F' || map[nextX][nextY] == 'J')
						continue;
					map[nextX][nextY] = 'J';
					jihun.add(new Point(nextX, nextY));
				} catch (ArrayIndexOutOfBoundsException e) {
					// 배열의 인덱스를 초과했으므로 탈출
					return true;
				}
			}
		}
		return false;
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
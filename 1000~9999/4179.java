package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * �̷ο� ���� �����̰� Ż���Ϸ��� �Ѵ�.
 * �̷ο��� ���� �پ��־� �ҿ� Ÿ������ Ż���ؾ� �Ѵ�.
 * �Ұ� �����̴� �� �и��� ���� �Ǵ� �������� �̵��Ѵ�.
 * �ƹ����̳� �̷ο� �ٱ��� ������ Ż���� �� �ִ�.
 * �����̰� Ż���� �� ���ٸ� IMPOSSIBLE�� ����ϰ�
 * Ż���� �� �ִٸ� ���� ���� Ż��ð��� ����ϴ� ����
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
			// �Һ��� �̵����� �����̰� ������ ���� �̸� �����Ѵ�.
			moveFire();
			// �����̰� �����̰� Ż���� �� �ִٸ� �ð��� ��ȯ
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
					// �迭�� �ε����� �ʰ������Ƿ� Ż��
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
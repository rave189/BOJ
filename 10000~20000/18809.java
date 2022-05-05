package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * ������ ���� �ǿ���� �Ѵ�.
 * ���� �ǿ�� ���� �ʷ� ���װ� ���� ���� ������ �Ѹ����� �Ѵ�.
 * ������ �����¿�� �� �ʸ��� �����Ѵ�.
 * �ʷ� ���װ� ���� ������ ���� �ð��� ���� ������ �����Ѵٸ� ���� �ǿ��.
 * ���� �ǿ� �Ŀ��� ������ �ߴ��Ѵ�.
 * ������ ȣ���δ� �������� ���Ѵ�.
 * 0 = ȣ��, 1 = ������ �ڶ��� ���ϴ� ����, 2 = ������ �ڶ� �� �ִ� ����
 * 2���� ������ �ѷ��� ���� �ǿ���� �Ҷ�, �ǿ� �� �ִ� �ִ� ���� ������ ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static ArrayList<Point> seeds = new ArrayList<>();
	static int[][] map;
	static int answer = 0, r, g, n, m;
	static final int RED = 3, GREEN = 4;
	static Point[] reds, greens;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	/**
	 * ���Ʈ������ ���� ��ġ �ڸ��� ���� �� bfs�� Ž���غ���.
	 * bfs �����ϱⰡ ���� �������.
	 * ó������ ���� ������ �̵� ��θ� hash�� ������ �� �ʷ� ������ �̵���ο� ������ ������ �����ִ� ������� �������� (4000ms)
	 * �ƴѰ� ���Ƽ� int[][]���ٰ� �ð��� �����ؼ� �����ϴ� ������� �ٲ� (1400ms)
	 * ���⼭ �� ���̴°� ��....? �����
	 * ó�� ���� ������ ���� ��߽�Ű��, �ʷ� ������ ��߽�ų �� �����̸� �̸� �ɷ��ִ� ������� ����
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		reds = new Point[r];
		greens = new Point[g];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					seeds.add(new Point(i, j));
			}
		}
		bruteforce(0, 0, 0);
		System.out.println(answer);
	}

	public static void bruteforce(int cur, int rIdx, int gIdx) {
		if (rIdx == r && gIdx == g) {
			answer = Math.max(answer, bfs(copy(map)));
			return;
		}

		for (int i = cur; i < seeds.size(); i++) {
			if (rIdx < r) {
				reds[rIdx] = seeds.get(i);
				bruteforce(i + 1, rIdx + 1, gIdx);
			}
			if (gIdx < g) {
				greens[gIdx] = seeds.get(i);
				bruteforce(i + 1, rIdx, gIdx + 1);
			}
		}
	}

	public static int bfs(int[][] map) {
		Queue<Point> redQ = new LinkedList<>(), greenQ = new LinkedList<>();
		int[][] timeMap = new int[n][m];
		for (Point red : reds) {
			map[red.x][red.y] = RED;
			redQ.add(red);
		}
		for (Point green : greens) {
			greenQ.add(green);
			map[green.x][green.y] = GREEN;
		}
		int count = 0, time = 0;
		while (!redQ.isEmpty() && !greenQ.isEmpty()) {
			time++;
			int size = redQ.size();
			while (size-- > 0) {
				Point cur = redQ.poll();
				if (map[cur.x][cur.y] == 0)
					continue;
				for (int i = 0; i < dx.length; i++) {
					int nextX = cur.x + dx[i];
					int nextY = cur.y + dy[i];
					try {
						if (map[nextX][nextY] == 0 || map[nextX][nextY] == RED || map[nextX][nextY] == GREEN)
							continue;
						map[nextX][nextY] = RED;
						timeMap[nextX][nextY] = time;
						redQ.add(new Point(nextX, nextY));
					} catch (ArrayIndexOutOfBoundsException e) {
					}
				}
			}
			size = greenQ.size();
			while (size-- > 0) {
				Point cur = greenQ.poll();
				for (int i = 0; i < dx.length; i++) {
					int nextX = cur.x + dx[i];
					int nextY = cur.y + dy[i];
					try {
						if (map[nextX][nextY] == RED) {
							if (timeMap[nextX][nextY] == time) {
								count++;
								map[nextX][nextY] = 0;
							}
							continue;
						} else if (map[nextX][nextY] == 0 || map[nextX][nextY] == GREEN)
							continue;
						timeMap[nextX][nextY] = time;
						map[nextX][nextY] = GREEN;
						greenQ.add(new Point(nextX, nextY));
					} catch (ArrayIndexOutOfBoundsException e) {
					}
				}
			}
		}
		return count;
	}

	public static int[][] copy(int[][] map) {
		int[][] copy = new int[n][m];
		for (int i = 0; i < n; i++)
			System.arraycopy(map[i], 0, copy[i], 0, m);
		return copy;
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
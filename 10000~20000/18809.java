package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 정원에 꽃을 피우려고 한다.
 * 꽃을 피우기 위해 초록 배양액과 빨간 배양액 씨앗을 뿌리려고 한다.
 * 배양액은 상하좌우로 매 초마다 증식한다.
 * 초록 배양액과 빨간 배양액은 같은 시간에 같은 지점에 도달한다면 꽃을 피운다.
 * 꽃을 피운 후에는 증식을 중단한다.
 * 배양액은 호수로는 증식하지 못한다.
 * 0 = 호수, 1 = 배양액이 자라지 못하는 지점, 2 = 배양액이 자랄 수 있는 지점
 * 2번에 배양액을 뿌려서 꽃을 피우려고 할때, 피울 수 있는 최대 꽃의 개수를 구하는 문제
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
	 * 브루트포스로 배양액 설치 자리를 구한 후 bfs로 탐색해본다.
	 * bfs 구현하기가 조금 힘들었음.
	 * 처음에는 빨간 배양액의 이동 경로를 hash에 저장한 후 초록 배양액의 이동경로와 만나는 지점을 지워주는 방식으로 구현했음 (4000ms)
	 * 아닌거 같아서 int[][]에다가 시간을 저장해서 구현하는 방법으로 바꿈 (1400ms)
	 * 여기서 더 줄이는건 음....? 힘들듯
	 * 처음 빨간 배양액을 먼저 출발시키고, 초록 배양액을 출발시킬 때 빨강이면 미리 걸러주는 방식으로 구현
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
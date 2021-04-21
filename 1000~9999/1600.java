package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 원숭이가 (1,1)에서 (H, W)까지 이동하려고 한다.
 * 원숭이는 말을 따라할 수 있어서, K번 말의 움직임을 따라할 수 있다.
 * 원숭이가 도착점까지 움직이는 동작의 최솟값을 구하는 문제 도착하지 못하면 -1을 출력한다.
 * @author Rave
 *
 */
public class Main {

	static Queue<Point> q = new LinkedList<>();
	// 동작이 k번 남았을 때의 지도의 상태를 저장하는 3차원 배열
	static boolean[][][] map;
	// map의 방문 여부를 확인하는 3차원 배열
	static boolean[][][] visited;
	// 말의 움직임
	static int[] dxH = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dyH = { 1, 2, 2, 1, -1, -2, -2, -1 };
	// 원숭이의 움직임
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		map = new boolean[k + 1][h][w];
		visited = new boolean[k + 1][h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++)
				map[k][i][j] = st.nextToken().equals("1") ? true : false;
		}
		q.add(new Point(0, 0, k));
		visited[k][0][0] = true;
		int answer = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Point cur = q.poll();
				if (cur.x == h - 1 && cur.y == w - 1) {
					System.out.println(answer);
					return;
				}
				MoveLikeHorse(cur);
				MoveMonkey(cur);
			}
			answer++;
		}
		System.out.println(-1);
	}

	/**
	 * 원숭이가 말의 움직임을 따라하여 도착하는 지점을 탐색하는 메소드
	 * @param cur 현재 원숭이의 지점
	 */
	public static void MoveLikeHorse(Point cur) {
		for (int i = 0; i < 8; i++) {
			int nextX = cur.x + dxH[i];
			int nextY = cur.y + dyH[i];
			try {
				// 지도의 상태는 map[k]에 저장하였기 때문에 map에 대한 비교는 map.length-1과 비교한다.
				// 말의 움직임을 따라하므로 k-1 배열의 (x, y)지점을 방문했는지 확인한다.
				if (!map[map.length - 1][nextX][nextY] && !visited[cur.k - 1][nextX][nextY]) {
					q.add(new Point(nextX, nextY, cur.k - 1));
					visited[cur.k - 1][nextX][nextY] = true;
				}
			} catch (Exception e) {
			}
		}
	}

	/**
	 * 원숭이가 원숭이의 움직임으로 도착하는 지점을 탐색하는 메소드
	 * @param cur 현재 원숭이의 지점
	 */
	public static void MoveMonkey(Point cur) {
		for (int i = 0; i < 4; i++) {
			int nextX = cur.x + dx[i];
			int nextY = cur.y + dy[i];
			try {
				// 마찬가지로 map[k]의 상태와 비교하고 k일때의 (x, y) 지점의 방문 여부를 확인한다.
				if (!map[map.length - 1][nextX][nextY] && !visited[cur.k][nextX][nextY]) {
					q.add(new Point(nextX, nextY, cur.k));
					visited[cur.k][nextX][nextY] = true;
				}
			} catch (Exception e) {
			}
		}
	}
}

class Point {
	int x, y, k;

	public Point(int _x, int _y, int _k) {
		this.x = _x;
		this.y = _y;
		this.k = _k;
	}

	public String toString() {
		return k + " " + x + " " + y;
	}
}
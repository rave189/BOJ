package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 상범 빌딩에 갇혀 탈출하려고 한다.
 * 상범 빌딩은 L개의 층이 있고, 각 층은 RxC로 이루어져 있다.
 * 이동은 동, 서, 남, 북, 상, 하로 이동할 수 있다.
 * 탈출하는데 필요한 최단 시간을 구하는 문제
 * @author Rave
 *
 */
public class Main {

    // 빌딩은 L개의 층이 각각 RxC로 이루어져 있다.
	static char[][][] building;
	static boolean[][][] visited;
	static Queue<Point> q;
	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, 1, -1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		while (true) {
			q = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
            // 입력이 0이면 종료한다.
			if (l == 0 && r == 0 && c == 0)
				break;
			building = new char[l][r][c];
			visited = new boolean[l][r][c];
			for (int h = 0; h < l; h++) {
				for (int x = 0; x < r; x++) {
					String line = br.readLine();
					for (int y = 0; y < c; y++) {
						building[h][x][y] = line.charAt(y);
                        // 시작 지점을 알 수 없으므로 입력 받을 때 미리 큐에 넣어둔다.
						if (building[h][x][y] == 'S') {
							q.add(new Point(x, y, h));
							visited[h][x][y] = true;
						}
					}
				}
                // 각 층 사이에 빈 줄이 하나씩 있다.
				br.readLine();
			}
			int result = BFS();
			if (result > 0)
				sb.append(String.format("Escaped in %d minute(s).", result));
			else
				sb.append("Trapped!");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	/**
	 * 시작지점부터 도착지점 까지 너비 우선 탐색을 수행하는 메소드
	 * 동, 서, 남, 북, 상, 하로 움직인다.
	 * @return 걸린 시간, 탈출하지 못하면 -1
	 */
	public static int BFS() {
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Point cur = q.poll();
				if (building[cur.h][cur.x][cur.y] == 'E')
					return time;
				for (int i = 0; i < 6; i++) {
					int nextX = cur.x + dx[i];
					int nextY = cur.y + dy[i];
					int nextH = cur.h + dh[i];
					try {
						if (building[nextH][nextX][nextY] != '#' && !visited[nextH][nextX][nextY]) {
							q.add(new Point(nextX, nextY, nextH));
							visited[nextH][nextX][nextY] = true;
						}
					} catch (Exception e) {
					}
				}
			}
			time++;
		}
		return -1;
	}
}

class Point {
	int x, y, h;

	public Point(int _x, int _y, int _h) {
		this.x = _x;
		this.y = _y;
		this.h = _h;
	}
}
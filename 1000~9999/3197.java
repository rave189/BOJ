package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 호수에는 두 마리의 백조가 살고 있고, 빙판으로 길이 막혀 만나지 못한다.
 * 주변 물과 동서남북으로 접촉한 빙판은 매일 녹는다.
 * 두 마리의 백조가 만나려면 최소 며칠이 지나야하는지 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static char[][] map;
	static boolean[][] visited;
	// 물의 위치를 저장할 큐
	static Queue<Point> waters = new LinkedList<>();
	// 오리의 위치를 저장할 배열
	static ArrayList<Point> Swans = new ArrayList<>();
	// 오리가 BFS를 수행할 배열
	static Queue<Point> q = new LinkedList<>();
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == '.')
					waters.add(new Point(i, j));
				else if (map[i][j] == 'L') {
					Swans.add(new Point(i, j));
					// 오리가 있는 지점도 물로 판단하기 때문에 waters에 넣어준다.
					waters.add(new Point(i, j));
				}
			}
		}
		// 첫 번째 백조를 큐에 넣고 시작
		Point start = Swans.get(0);
		q.add(start);
		visited[start.x][start.y] = true;
		int answer = 1;
		while (!q.isEmpty()) {
			// 하루가 지났으므로 얼음이 녹는다.
			IceMelt();
			// 백조가 서로 만날 수 있는지 확인한다.
			if (isFindDuck()) {
				System.out.println(answer);
				return;
			}
			// 다음날이 된다.
			answer++;
		}
	}

	/**
	 * 물과 접촉한 얼음을 녹이는 메소드
	 */
	public static void IceMelt() {
		// 얼음을 녹인 후 녹인 자리를 nextQ에 저장한다.
		Queue<Point> nextQ = new LinkedList<>();
		while (!waters.isEmpty()) {
			Point cur = waters.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					if (map[nextX][nextY] == 'X') {
						// 얼음인 자리를 물로 바꾸고 nextQ에 저장
						nextQ.add(new Point(nextX, nextY));
						map[nextX][nextY] = '.';
					}
				} catch (Exception e) {
				}
			}
		}
		// waters를 nextQ로 바꿔 다음날 녹일 얼음을 저장하도록 한다.
		waters = nextQ;
	}

	/**
	 * 두 마리의 백조가 서로 만날 수 있는지 확인하는 메소드
	 * BFS를 수행하여 만날 수 있는지 확인한다.
	 * @return 백조가 서로 만난다면 true, 아니라면 false
	 */
	public static boolean isFindDuck() {
		// 탐색한 모든 정점을 nextQ에 저장하여 다음날 움직일 백조를 저장한다.
		Queue<Point> nextQ = new LinkedList<>();
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					if (!visited[nextX][nextY]) {
						// 백조를 만났다면 true를 반환한다.
						if (map[nextX][nextY] == 'L')
							return true;
						else if (map[nextX][nextY] == '.') {
							// 백조가 이동하며 만나는 모든 정점을 큐와 nextQ에 넣는다.
							nextQ.add(new Point(nextX, nextY));
							q.add(new Point(nextX, nextY));
							visited[nextX][nextY] = true;
						}
					}
				} catch (Exception e) {
				}
			}
		}
		// 큐를 다음날 움직일 정점들로 복사한다.
		q = nextQ;
		return false;
	}
}

class Point {
	int x, y;

	public Point(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}
}
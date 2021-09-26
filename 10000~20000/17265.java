package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 숫자와 연산자가 쓰여있는 지도가 있다.
 * 이 지도의 (0, 0)에서 (N, N)까지 최단 거리로 가는 동안 만나는 숫자와 연산자를 계산하여 최댓값과 최솟값을 구하는 문제
 * 최단거리로 이동하기 위해 오른쪽과 아래로만 이동한다.
 * (0, 0)은 숫자이고, 숫자 다음은 연산자, 연산자 다음은 숫자가 반드시 나온다.
 * 연산자의 우선순위는 무시하고 계산한다.
 * 연산자는 +, -, *만 나온다.
 * @author Rave
 *
 */
public class Main {

	static char[][] map;
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	/**
	 * 일반적인 BFS로 풀리는 문제
	 * 최댓값과 최솟값은 (N, N)에서만 확인해야한다.
	 * 항상 최단거리인 오른쪽, 아래쪽으로만 움직이기 때문에 방문체크는 하지 않아도 된다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = st.nextToken().charAt(0);
		}
		BFS();
		System.out.println(max + " " + min);
	}

	public static void BFS() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, map[0][0] - '0'));
		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (cur.x == map.length - 1 && cur.y == map.length - 1) {
				min = Math.min(min, cur.result);
				max = Math.max(max, cur.result);
				continue;
			}
			for (int i = 0; i < dx.length; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					char ch = map[nextX][nextY];
					if ('0' <= ch && ch <= '9') {
						int result = calc(cur.result, cur.op, ch - '0');
						q.add(new Point(nextX, nextY, result));
					} else {
						q.add(new Point(nextX, nextY, cur.result, ch));
					}
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		}
	}

	public static int calc(int left, char op, int right) {
		if (op == '+')
			return left + right;
		else if (op == '-')
			return left - right;
		else if (op == '*')
			return left * right;
		return -1;
	}
}

class Point {
	int x, y, result;
	char op;

	public Point(int x, int y, int result) {
		this.x = x;
		this.y = y;
		this.result = result;
	}

	public Point(int x, int y, int result, char op) {
		this.x = x;
		this.y = y;
		this.result = result;
		this.op = op;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", result=" + result + ", op=" + op + "]";
	}
}
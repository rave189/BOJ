package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * ���ڿ� �����ڰ� �����ִ� ������ �ִ�.
 * �� ������ (0, 0)���� (N, N)���� �ִ� �Ÿ��� ���� ���� ������ ���ڿ� �����ڸ� ����Ͽ� �ִ񰪰� �ּڰ��� ���ϴ� ����
 * �ִܰŸ��� �̵��ϱ� ���� �����ʰ� �Ʒ��θ� �̵��Ѵ�.
 * (0, 0)�� �����̰�, ���� ������ ������, ������ ������ ���ڰ� �ݵ�� ���´�.
 * �������� �켱������ �����ϰ� ����Ѵ�.
 * �����ڴ� +, -, *�� ���´�.
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
	 * �Ϲ����� BFS�� Ǯ���� ����
	 * �ִ񰪰� �ּڰ��� (N, N)������ Ȯ���ؾ��Ѵ�.
	 * �׻� �ִܰŸ��� ������, �Ʒ������θ� �����̱� ������ �湮üũ�� ���� �ʾƵ� �ȴ�.
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
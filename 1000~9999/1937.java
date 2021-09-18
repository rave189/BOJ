package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �볪�� ������ �Ǵٸ� Ű����� �Ѵ�.
 * �Ǵٴ� �� ������ �볪���� �� ������ ��, ��, ��, ��� �̵��Ͽ� �ٽ� �볪���� ���� �Դ´�.
 * �� �� �Ǵٴ� ���� ���� ������ �볪�� ������ ���� �볪���� �ִ� �������θ� �̵��Ѵ�.
 * �Ǵٰ� �̵��� �� �ִ� �ִ� ĭ ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static int[][] dp;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	/**
	 * ��ü �ʿ� �Ǵٸ� �� ���� �� ���ƺ���.
	 * �׸��� �ִ� �̵� ĭ ���� dp�� ����صд�.
	 * �׸��� �̹� �̵��� �� ������ ������ ��� dp�� ���� ����Ͽ� �Ǵ��� �ִ� �̵� ĭ ���� ���Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				answer = Math.max(answer, DFS(new Point(i, j)));
		System.out.println(answer);
	}

	/**
	 * dp�� �̹� ���� ������ ��� �״�� return���ش�.
	 * ���� ��� �����¿츦 ��� Ž���Ͽ� �ִ񰪿� + 1�� dp�� �����ϸ� return�Ѵ�.
	 * @param p ���� ����
	 * @return
	 */
	public static int DFS(Point p) {
		if (dp[p.x][p.y] != 0) {
			return dp[p.x][p.y];
		}
		int max = 0;
		for (int i = 0; i < dx.length; i++) {
			int nextX = p.x + dx[i];
			int nextY = p.y + dy[i];
			try {
				if (map[nextX][nextY] > map[p.x][p.y])
					max = Math.max(max, DFS(new Point(nextX, nextY)));
			} catch (ArrayIndexOutOfBoundsException e) {
			}
		}
		return dp[p.x][p.y] = max + 1;
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
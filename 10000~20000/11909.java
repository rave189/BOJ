package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �迭�� Ż���Ϸ��� �Ѵ�.
 * Ż���ϱ����� �ִܰŸ��� �����ʰ� �Ʒ������θ� �̵��� �� �ִ�.
 * ���� (a, b)���� (c, d)�� ������ A[a][b] > A[c][d]�̾�߸� �Ѵ�.
 * �� ������ �����ϱ� ���� ����� 1 �����ϰ� A[a][b]�� ĭ�� ���� 1 ������ų �� �ִ�.
 * Ż���ϴµ� �ʿ��� �ּ� ����� ���ϴ� ����
 * �Է��� 2222�� �ſ�ſ�ſ� ũ��.
 * @author Rave
 *
 */
public class Main {

	static int[][] map, pays;
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };
	static int INF = 100000000;

	/**
	 * dp�� ���ͽ�Ʈ��� Ǫ�� ����� �ִ�.
	 * ���ͽ�Ʈ��δ� 1400ms �����̰�, dp�� �ٲٴ� 900ms ���� ���´�.
	 * ���ǿ� �°� �̵��ϸ� ���� Ż���� �� �ִ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		pays = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				pays[i][j] = INF;
			}
		}
		pays[0][0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (pays[i][j] == INF)
					continue;
				int compareValue = map[i][j];
				int comparePay = pays[i][j];
				for (int t = 0; t < dx.length; t++) {
					int nextX = i + dx[t];
					int nextY = j + dy[t];
					try {
						if (compareValue > map[nextX][nextY] && comparePay < pays[nextX][nextY])
							pays[nextX][nextY] = comparePay;
						else if (compareValue <= map[nextX][nextY]
								&& map[nextX][nextY] + 1 - compareValue + comparePay < pays[nextX][nextY])
							pays[nextX][nextY] = map[nextX][nextY] + 1 - compareValue + comparePay;
					} catch (ArrayIndexOutOfBoundsException e) {
					}
				}
			}
		}
		System.out.println(pays[n - 1][n - 1]);
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ġ����ſ� ����Ƣ���� �����ִ�.
 * ���� �ֹ��� ������ �����ִ� ���ſ� Ƣ������ �ֹ��� �޾ƾ� �Ѵ�.
 * �ֹ��� �־��� ���ſ� Ƣ���� ��� �� �� �־�� �ֹ��� �Ϸ��� �� �ִ�.
 * �ֹ��� �־�����, ó���� �� �ִ� �ִ� �ֹ��� ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int[][] orders;

	/**
	 * dp�� [n][301][301]�� �س��� 1100ms �ɸ�
	 * [n+1][m+1][k+1]�� �ٲٴ� 800ms �ɸ�
	 * 44��° �� ��ȭ�� try���� if�� �ٲٴ� 212ms �ɸ� (�������� ���̰� �� ���� �ֳ�?)
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		orders = new int[n + 1][2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < orders[i].length; j++)
				orders[i][j] = Integer.parseInt(st.nextToken());
		}
		int[][][] dp = new int[n + 1][m + 1][k + 1];
		for (int i = 1; i <= n; i++) {
			int burger = orders[i][0], frie = orders[i][1];
			for (int j = 1; j <= m; j++) {
				for (int t = 1; t <= k; t++) {
					dp[i][j][t] = dp[i - 1][j][t];
					if (j - burger >= 0 && t - frie >= 0)
						dp[i][j][t] = Math.max(dp[i][j][t], dp[i - 1][j - burger][t - frie] + 1);
				}
			}
		}
		System.out.println(dp[n][m][k]);
	}
}
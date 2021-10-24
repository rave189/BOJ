package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ���簢�� ������ 2���� ���� ����� �� ������ ���� ���Է� �Ǿ��ִ� ���ð� �ִ�.
 * ���� ���Դ� �� ������ �������� �Ǹ��Ѵ�.
 * �� ������ (1, 1)���� (N, N)���� �� ���� ���Ը� �鷯 ������ ���÷����Ѵ�.
 * ��, ������ ���� ����, ���� ����, �ٳ��� ���� �ٽ� ���� ���� ������ ���ž� �Ѵ�.
 * ������ ������ ������ �ʰ� �Ѿ�� ��� ����.
 * ����, �׻� ���ʰ� ���� �������θ� �������� �Ѵ�.
 * �̶�, ���� �� �ִ� ������ �ִ��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static int[][][] dp;

	/**
	 * �Է°��� 1000���� ������, 1000x1000 �迭�� bfs�� Ž���ϸ� �޸� �ʰ��� �Ͼ �� �ִ�.
	 * ���� dp�� ����Ͽ� ������ �ذ��Ѵ�.
	 * dp�� NxN �̿ܿ� ������ ������ ���̴����� �߿��ϹǷ� 3���� �迭�� �����Ѵ�.
	 * (������ ���� �����ε� ������ ������ ���̴��� �� �� �ִ�.
	 * ex. 1: ���� ����, 2: ���� ����, 3: �ٳ��� ���� �ݺ�)
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[3][n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					dp[0][i][j] = 1;
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				for (int t = 0; t < dp.length; t++) {
					if (dp[t][i][j] == 0)
						continue;
					int nextType = (t + 1) % 3;
					// �迭�� ũ�⸦ n+1�� ������� ������ ���� �ʰ� j-1, i-1�� ó���� �� �־���.
					if (j + 1 < map[0].length) {
						// ���� ���Կ��� �Ǹ��ϴ� ������ ���ž� �ϴ� ������ ���ٸ� �ִ����� ���Ѵ�.
						if (map[i][j + 1] == nextType)
							dp[nextType][i][j + 1] = Math.max(dp[nextType][i][j + 1], dp[t][i][j] + 1);
						// ������ �ʰ� �׳� �Ѿ�� ���
						dp[t][i][j + 1] = Math.max(dp[t][i][j + 1], dp[t][i][j]);
					}
					if (i + 1 < map.length) {
						if (map[i + 1][j] == nextType)
							dp[nextType][i + 1][j] = Math.max(dp[nextType][i + 1][j], dp[t][i][j] + 1);
						dp[t][i + 1][j] = Math.max(dp[t][i + 1][j], dp[t][i][j]);
					}
				}
			}
		}
		int max = 0;
		for (int i = 0; i < dp.length; i++)
			max = Math.max(max, dp[i][n - 1][n - 1]);
		System.out.println(max);
	}
}
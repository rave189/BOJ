package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N���� ���� �ִ�.
 * �� ���� ����, �ʷ�, �Ķ����� ĥ�ϴ� ����� �־�����.
 * �� ���� �������� ����Ǿ� �ִ� ����������, i��° ���� i-1��° ��, i+1��° ���� ���� ���� ���� �ȵȴ�.
 * �� ���� ĥ�ϴ� �ּ� ����� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static final int COLOR_CNT = 3, RED = 0, GREEN = 1, BLUE = 2;
	static int[][] cost, dp;

	/**
	 * ù ������ �����صΰ� ����
	 * ������ ���� ��� �ؾߵ��� ���� �ϵ��ڵ����� �־��
	 * �׳� for�� ������ ���� �� ����.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		cost = new int[n][COLOR_CNT];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < cost[i].length; j++)
				cost[i][j] = Integer.parseInt(st.nextToken());
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < COLOR_CNT; i++) {
			dp = new int[n][COLOR_CNT];
			for (int j = 0; j < COLOR_CNT; j++)
				if (i == j)
					dp[0][j] = cost[0][j];
				else
					dp[0][j] = 1000000;
			for (int j = 1; j < n; j++) {
				dp[j][RED] = Math.min(dp[j - 1][GREEN], dp[j - 1][BLUE]) + cost[j][RED];
				dp[j][GREEN] = Math.min(dp[j - 1][RED], dp[j - 1][BLUE]) + cost[j][GREEN];
				dp[j][BLUE] = Math.min(dp[j - 1][RED], dp[j - 1][GREEN]) + cost[j][BLUE];
			}
			if (i == 0)
				answer = Math.min(answer, Math.min(dp[n - 1][GREEN], dp[n - 1][BLUE]));
			else if (i == 1)
				answer = Math.min(answer, Math.min(dp[n - 1][RED], dp[n - 1][BLUE]));
			else
				answer = Math.min(answer, Math.min(dp[n - 1][RED], dp[n - 1][GREEN]));
		}
		System.out.println(answer);
	}
}
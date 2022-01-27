package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Math.min;

/**
 * ��� N���� �־����� ��, ��� ����� ���� ������ �ּڰ��� ���ϴ� ����
 * ����� ���� ������ ������ ���� ���� Ƚ���� �ٸ���.
 * 
 * @author Rave
 *
 */
public class Main {

	/**
	 * dp�� �̿��Ͽ� ���� ������ ���� ���Ѵ�.
	 * dp[i][i]�� ������ ���� �����Ƿ� 0�̴�.
	 * ���A�� ���B�� ���� ������ rowA * colA * colB�̴�.
	 * i��° ��ĺ��� j��° ��ı����� ���� ������ i~k��°������ �������� + k+1~j��°������ �������� ��
	 * ����� ���� �� ����� ���� ������ �����ִ� ������ ���� �� �ִ�.
	 * �߰� ���� ������ DP�� �����صΰ� ����� ���� �� ����� ���� ���� Ƚ���� ���ؼ� dp[i][j]�� ���Ѵ�.
	 * i�� 1���� �����ϰ� �Ǹ� k+1~j�� ���� ���� ���·� ���� �� �����Ƿ�, n���� �ٿ����� ������� ���Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] r = new int[n + 1];
		int[] c = new int[n + 1];
		int[][] dp = new int[n + 2][n + 2];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = n - 1; i >= 1; i--) {
			for (int j = i + 1; j <= n; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k <= j; k++)
					dp[i][j] = min(dp[i][j], dp[i][k] + dp[k + 1][j] + r[i] * c[k] * c[j]);
			}
		}
		System.out.println(dp[1][n]);
	}
}
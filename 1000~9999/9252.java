package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Math.max;

/**
 * �� ���ڿ��� �־����� �� ���� �� ���� �κ� ������ ���ϴ� ����
 * ���� �κ� ������ ���̸� ���ϰ�, �κ� ������ ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	static int[] dx = { -1, 0, -1 };
	static int[] dy = { 0, -1, -1 };

	/**
	 * dp�� ����Ͽ� Ǫ�� ����
	 * s1�� i��° char�� s2�� j��° char�� ���ٸ� �밢������ ���� �����´�.
	 * �ٸ��ٸ� ���ʰ� ���� �߿��� ū ���� �����´�. 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		int[][] route = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					route[i][j] = 2;
				} else {
					dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
					route[i][j] = dp[i][j] == dp[i - 1][j] ? 0 : 1;
				}
			}
		}
		StringBuilder answer = new StringBuilder();
		for (int i = s1.length(), j = s2.length(); i > 0 && j > 0;) {
			int prev = route[i][j];
			if (prev == 2)
				answer.append(s1.charAt(i - 1));
			i += dx[prev];
			j += dy[prev];
		}
		System.out.println(dp[s1.length()][s2.length()]);
		System.out.println(answer.reverse());
	}
}
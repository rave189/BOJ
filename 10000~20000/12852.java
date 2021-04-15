package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * ���� N�� 1�� ����µ� �ʿ��� ������ �ּڰ��� 1�� ����� ����� ���ϴ� ����
 * ������ ������ ����.
 * N�� 3���� ������ ��������, 3���� ������.
 * N�� 2�� ������ ��������, 2�� ������.
 * 1�� ����.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[2][n + 1];
		// dp �ʱ�ȭ
		Arrays.fill(dp[0], 100000000);
		dp[0][1] = 0;
		for (int i = 1; i <= n; i++) {
			if (dp[0][i] == 100000000)
				continue;
			if (i + 1 <= n && dp[0][i] + 1 < dp[0][i + 1]) {
				// ���� ������Ʈ
				dp[0][i + 1] = dp[0][i] + 1;
				// ���� �ε��� ����
				dp[1][i + 1] = i;
			}
			if (i * 2 <= n && dp[0][i] + 1 < dp[0][i * 2]) {
				dp[0][i * 2] = dp[0][i] + 1;
				dp[1][i * 2] = i;
			}
			if (i * 3 <= n && dp[0][i] + 1 < dp[0][i * 3]) {
				dp[0][i * 3] = dp[0][i] + 1;
				dp[1][i * 3] = i;
			}
		}
		// ��θ� �������Ѵ�.
		StringBuffer answer = new StringBuffer(dp[0][n] + "\n");
		// ����! for������ int�� �����ϴ� ���� �޸� �ʰ�
		while (n > 0) {
			answer.append(n + " ");
			n = dp[1][n];
		}
		System.out.println(answer);
	}
}
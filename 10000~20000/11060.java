package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * �迭�� �ְ� �� ĭ���� ���ڰ� �����ִ�.
 * �ִ� �迭�� �� ĭ�� ���� ����ŭ ���������� ������ �� �ִ�.
 * 3�� �����ִٸ� x+1, x+2, x+3���� ������ �� �ִ�.
 * ���� ������ ������ ������ ���� ���� �ּ� ���� Ƚ���� ���ϴ� ����
 * �������� ���Ѵٸ� -1�� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	/**
	 * x+1, x+2, x+3�� ���Ʈ������ Ž���ϰ� �Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] maze = new int[n];
		for (int i = 0; i < n; i++)
			maze[i] = Integer.parseInt(st.nextToken());
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			if (dp[i] == Integer.MAX_VALUE)
				continue;
			for (int j = 1; j <= maze[i]; j++) {
				try {
					dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
				} catch (ArrayIndexOutOfBoundsException e) {
					break;
				}
			}
		}
		System.out.println(dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1]);
	}
}
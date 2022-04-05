package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ���� ������ �ִ�.
 * ���� �� N���� �ִ�.
 * ���Ը� �����ϰ� ���� ������ �ִ�.
 * ���� ������ ���ʿ� ������ �ΰ�, ���� �߸� ���ȿ� ������ �����Ͽ� ������ ���Ը� ������ �� �ִ��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * ���� ����
	 * ������ �ִ��ʿ� ���� ���� ���� ���� - ����, ���� �ݴ��� ���� ���� ���� ���� + ����
	 * �ִ�� ���� �� �ִ� ���Ը� ���ϰ� dp[n][max]�� ����Ѵ�.
	 * i��° �߱��� ����Ͽ� ���� �� �ִ� ���� v�� �����Ѵ�.
	 * 
	 * ��κ��� ��� ���� ���� - ���Է� ���� �� ����.
	 * ���� ���� + ���Ը� �����ִ� ������ �ȳ�����.
	 * 3
	 * 7 8 9
	 * 1
	 * 6
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] weights = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < n; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
			max += weights[i];
		}
		boolean[][] dp = new boolean[n][max + 1];
		dp[0][weights[0]] = true;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= max; j++) {
				dp[i][j] |= dp[i - 1][j];
				try {
					dp[i][j] |= dp[i - 1][Math.abs(j - weights[i])];
					dp[i][j-weights[i]] |= dp[i][j];
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
			dp[i][weights[i]] = true;
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (m-- > 0) {
			int v = Integer.parseInt(st.nextToken());
			try {
				answer.append(dp[n - 1][v] ? "Y" : "N");
			} catch (ArrayIndexOutOfBoundsException e) {
				answer.append("N");
			}
			answer.append(' ');
		}
		System.out.println(answer);
	}
}
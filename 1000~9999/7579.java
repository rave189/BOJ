package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N���� ���� �ִ�.
 * �� �� �߿��� �� ���� �� M ����Ʈ �̻��� �޸𸮸� Ȯ���Ϸ��� �Ѵ�.
 * �� ���� ����ϰ� �ִ� ����Ʈ�� ���� �����ϴµ� ��� ����� �־��� ��
 * M ����Ʈ�� �޸𸮸� Ȯ���ϴµ� ��� �ּ� ����� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * ���� ������.
	 * ���µ� ��� �� ����� �ִ� ũ��� �ΰ� ���� ���µ� ��� ����� ����س�����.
	 * dp[i][j]�� i��° �۱��� �߿��� j�� ����� ����ϸ� dp[i][j]��ŭ�� �޸𸮸� Ȯ���� �� �ִ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] memory = new int[n + 1];
		int[] close = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			memory[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 1; i <= n; i++) {
			close[i] = Integer.parseInt(st.nextToken());
			max += close[i];
		}
		int[][] dp = new int[n + 1][max + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= max; j++) {
				dp[i][j] = dp[i - 1][j];
				try {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - close[i]] + memory[i]);
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		}
		for (int i = 1; i <= max; i++)
			if (dp[n][i] >= m) {
				System.out.println(i);
				return;
			}
	}
}
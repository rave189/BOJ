package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2xN ũ���� ���� �ִ�.
 * �� ���� 2x1, 1x2, 1x1 ũ���� Ÿ�Ϸ� ä��� ����� ���� ���ϴ� ����
 * ���� ũ�� ������ 1000000007�� �������ش�.
 * @author Rave
 *
 */
public class Main {

	static int mod = 1000000007;

	/**
	 * Ÿ�Ϸ� ä��� ����� ���� ������ ����.
	 * n-1��°���� 2x1�� �þ 2x1 Ÿ�� 1�� �Ǵ� 1x1 Ÿ�� 2���� ä��� ����� ���� �ִ�. (*2)
	 * n-2��°���� 2x2�� �þ 1x2 Ÿ�� 2�� �Ǵ� 1x2 Ÿ�� 1��, 1x1Ÿ�� 2���� ���Ʒ��� ���̴� ����� �ִ�. (*3)
	 * �׸��� n-3��°���� �� ������ ���� ���̽����� �߰��ȴ�.
	 * .--   .--.  .----
	 * --.   ----  ----.
	 * �̷��� ����� ���� dp�� ����Ͽ� ���Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[1000000];
		long[] dp = new long[1000000];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 7;
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + arr[i - 3]) % mod;
			arr[i] = (arr[i - 1] * 2 + arr[i - 2] * 3 + dp[i] * 2) % mod;
		}
		System.out.println(arr[n] % mod);
	}
}
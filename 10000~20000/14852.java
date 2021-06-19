package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2xN 크기의 벽이 있다.
 * 이 벽을 2x1, 1x2, 1x1 크기의 타일로 채우는 경우의 수를 구하는 문제
 * 수가 크기 때문에 1000000007로 나누어준다.
 * @author Rave
 *
 */
public class Main {

	static int mod = 1000000007;

	/**
	 * 타일로 채우는 경우의 수는 다음과 같다.
	 * n-1번째에서 2x1이 늘어나 2x1 타일 1개 또는 1x1 타일 2개로 채우는 경우의 수가 있다. (*2)
	 * n-2번째에서 2x2가 늘어나 1x2 타일 2개 또는 1x2 타일 1개, 1x1타일 2개를 위아래로 붙이는 방법이 있다. (*3)
	 * 그리고 n-3번째에서 는 다음과 같은 케이스들이 추가된다.
	 * .--   .--.  .----
	 * --.   ----  ----.
	 * 이러한 경우의 수를 dp를 사용하여 구한다.
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
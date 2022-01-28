package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Math.min;

/**
 * 행렬 N개가 주어졌을 때, 모든 행렬의 곱셈 연산의 최솟값을 구하는 문제
 * 행렬의 곱셈 연산은 순서에 따라 연산 횟수가 다르다.
 * 
 * @author Rave
 *
 */
public class Main {

	/**
	 * dp를 이용하여 곱셈 연산의 수를 구한다.
	 * dp[i][i]는 곱셈을 하지 않으므로 0이다.
	 * 행렬A와 행렬B의 곱셈 연산은 rowA * colA * colB이다.
	 * i번째 행렬부터 j번째 행렬까지의 곱셈 연산은 i~k번째까지의 곱셈연산 + k+1~j번째까지의 곱셈연산 후
	 * 결과로 나온 두 행렬의 곱셈 연산을 더해주는 것으로 구할 수 있다.
	 * 중간 곱셈 연산은 DP에 저장해두고 결과로 나온 두 행렬의 곱셈 연산 횟수만 더해서 dp[i][j]를 구한다.
	 * i를 1부터 시작하게 되면 k+1~j의 값이 없는 상태로 계산될 수 있으므로, n부터 줄여가는 방식으로 구한다.
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
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 정수 N을 1로 만드는데 필요한 연산의 최솟값과 1로 만드는 방법을 구하는 문제
 * 연산은 다음과 같다.
 * N이 3으로 나누어 떨어지면, 3으로 나눈다.
 * N이 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[2][n + 1];
		// dp 초기화
		Arrays.fill(dp[0], 100000000);
		dp[0][1] = 0;
		for (int i = 1; i <= n; i++) {
			if (dp[0][i] == 100000000)
				continue;
			if (i + 1 <= n && dp[0][i] + 1 < dp[0][i + 1]) {
				// 연산 업데이트
				dp[0][i + 1] = dp[0][i] + 1;
				// 이전 인덱스 저장
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
		// 경로를 역추적한다.
		StringBuffer answer = new StringBuffer(dp[0][n] + "\n");
		// 주의! for문으로 int를 선언하는 순간 메모리 초과
		while (n > 0) {
			answer.append(n + " ");
			n = dp[1][n];
		}
		System.out.println(answer);
	}
}
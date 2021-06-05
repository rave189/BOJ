package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 두 문자열이 주어졌을 때 모두의 부분 수열이 되는 가장 긴 것을 찾는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 이차원 배열의 dp를 생성한다.
	 * 이후 char를 비교하며 같으면 i-1번째, j-1번째 값에 +1을 한다.
	 * 같지 않다면 i-1번쨰 값과 j-1번째 값 중 큰 값을 저장한다.
	 * 1차원 배열로는 풀이에 한계가 있는 것 같다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int[][] dp = new int[str1.length()][str2.length()];
		int answer = 0;
		// 첫 글자를 먼저 비교한다. 예외의 가짓수를 줄이기 위해
		for (int i = 0; i < str2.length(); i++) {
			if (str1.charAt(0) == str2.charAt(i))
				answer = 1;
			dp[0][i] = answer;
		}
		for (int i = 1; i < str1.length(); i++) {
			char ch1 = str1.charAt(i);
			int max = 0;
			for (int j = 0; j < str2.length(); j++) {
				char ch2 = str2.charAt(j);
				// 같다면 i-1, j-1번쨰 값에서 +1한 값을 넣는다.
				if (ch1 == ch2) {
					try {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					} catch (Exception e) {
						dp[i][j] = 1;
					}
				} else {
					// 같지 않다면 i-1번쨰 값과 j-1번쨰 값 중 큰 값을 넣는다.
					try {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					} catch (Exception e) {
						dp[i][j] = dp[i - 1][j];
					}
				}
				answer = Math.max(answer, dp[i][j]);
			}
		}
		System.out.println(answer);
	}
}
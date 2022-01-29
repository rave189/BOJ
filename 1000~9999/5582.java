package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 두 문자열이 주어지고, 두 문자열에서 연속된 가장 긴 공통 부분 문자열을 구하는 문제
 * 가장 긴 공통 부분 문자열의 길이를 출력한다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * LCS와 같은 문제
	 * 연속된 공통 문자열을 찾는 것이기 때문에 연속이 되는 경우에만 +1을 해준다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		int max = 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		System.out.println(max);
	}
}
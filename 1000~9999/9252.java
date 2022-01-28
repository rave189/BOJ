package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Math.max;

/**
 * 두 문자열이 주어졌을 때 가장 긴 공통 부분 수열을 구하는 문제
 * 공통 부분 수열의 길이를 구하고, 부분 수열을 출력한다.
 * @author Rave
 *
 */
public class Main {

	static int[] dx = { -1, 0, -1 };
	static int[] dy = { 0, -1, -1 };

	/**
	 * dp를 사용하여 푸는 문제
	 * s1의 i번째 char와 s2의 j번째 char가 같다면 대각선에서 값을 가져온다.
	 * 다르다면 왼쪽과 위쪽 중에서 큰 값을 가져온다. 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		int[][] route = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					route[i][j] = 2;
				} else {
					dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
					route[i][j] = dp[i][j] == dp[i - 1][j] ? 0 : 1;
				}
			}
		}
		StringBuilder answer = new StringBuilder();
		for (int i = s1.length(), j = s2.length(); i > 0 && j > 0;) {
			int prev = route[i][j];
			if (prev == 2)
				answer.append(s1.charAt(i - 1));
			i += dx[prev];
			j += dy[prev];
		}
		System.out.println(dp[s1.length()][s2.length()]);
		System.out.println(answer.reverse());
	}
}
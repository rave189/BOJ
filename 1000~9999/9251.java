package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * �� ���ڿ��� �־����� �� ����� �κ� ������ �Ǵ� ���� �� ���� ã�� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * ������ �迭�� dp�� �����Ѵ�.
	 * ���� char�� ���ϸ� ������ i-1��°, j-1��° ���� +1�� �Ѵ�.
	 * ���� �ʴٸ� i-1���� ���� j-1��° �� �� ū ���� �����Ѵ�.
	 * 1���� �迭�δ� Ǯ�̿� �Ѱ谡 �ִ� �� ����.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int[][] dp = new int[str1.length()][str2.length()];
		int answer = 0;
		// ù ���ڸ� ���� ���Ѵ�. ������ �������� ���̱� ����
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
				// ���ٸ� i-1, j-1���� ������ +1�� ���� �ִ´�.
				if (ch1 == ch2) {
					try {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					} catch (Exception e) {
						dp[i][j] = 1;
					}
				} else {
					// ���� �ʴٸ� i-1���� ���� j-1���� �� �� ū ���� �ִ´�.
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
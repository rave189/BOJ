package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * �� ���ڿ��� �־�����, �� ���ڿ����� ���ӵ� ���� �� ���� �κ� ���ڿ��� ���ϴ� ����
 * ���� �� ���� �κ� ���ڿ��� ���̸� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	/**
	 * LCS�� ���� ����
	 * ���ӵ� ���� ���ڿ��� ã�� ���̱� ������ ������ �Ǵ� ��쿡�� +1�� ���ش�.
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
package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * NxM ũ���� �迭�� �־�����.
 * �迭���� 1�� 0���θ� �̷���� ���� ��, 1�� �̷���� ���� ū ���簢���� ���̸� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * ���� ū ���簢���� ���̸� dp�� �����ϸ� Ǭ��.
	 * ����, �밢��, ���� 1�̸� ���簢���� �� �� �ִ�.
	 * �� �� �����ϴ� ���� ����, �밢��, ���� ���� ���� ���� ������ +1�� ���̸� �����Ѵ�.
	 * 
	 * ���� ���� ���Ѵٰ� sqrt�������� �׳� ���̸� �����صΰ�, ������ �ִ밪�� �����Ͽ� ���̸� ���ϴ°� �ξ� �� ���� ���� �� ����.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++)
				map[i][j + 1] = line.charAt(j) == '1' ? true : false;
		}
		int[][] dp = new int[n + 1][m + 1];
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (!map[i][j])
					continue;
				dp[i][j] = 1;
				if (map[i - 1][j] && map[i - 1][j - 1] && map[i][j - 1]) {
					int row = (int) Math.sqrt(Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]));
					dp[i][j] = (row + 1) * (row + 1);
				}
				answer = Math.max(answer, dp[i][j]);
			}
		}
		System.out.println(answer);
	}
}
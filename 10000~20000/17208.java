package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 치즈버거와 감자튀김이 남아있다.
 * 새로 주문이 들어오면 남아있는 버거와 튀김으로 주문을 받아야 한다.
 * 주문에 주어진 버거와 튀김을 모두 줄 수 있어야 주문을 완료할 수 있다.
 * 주문이 주어질때, 처리할 수 있는 최대 주문의 수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[][] orders;

	/**
	 * dp를 [n][301][301]로 해놔서 1100ms 걸림
	 * [n+1][m+1][k+1]로 바꾸니 800ms 걸림
	 * 44번째 줄 점화식 try에서 if로 바꾸니 212ms 걸림 (이정도로 차이가 날 수가 있나?)
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		orders = new int[n + 1][2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < orders[i].length; j++)
				orders[i][j] = Integer.parseInt(st.nextToken());
		}
		int[][][] dp = new int[n + 1][m + 1][k + 1];
		for (int i = 1; i <= n; i++) {
			int burger = orders[i][0], frie = orders[i][1];
			for (int j = 1; j <= m; j++) {
				for (int t = 1; t <= k; t++) {
					dp[i][j][t] = dp[i - 1][j][t];
					if (j - burger >= 0 && t - frie >= 0)
						dp[i][j][t] = Math.max(dp[i][j][t], dp[i - 1][j - burger][t - frie] + 1);
				}
			}
		}
		System.out.println(dp[n][m][k]);
	}
}
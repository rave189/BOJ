package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 배열이 있고 각 칸마다 숫자가 적혀있다.
 * 최대 배열의 각 칸에 적힌 수만큼 오른쪽으로 점프할 수 있다.
 * 3이 적혀있다면 x+1, x+2, x+3으로 점프할 수 있다.
 * 왼쪽 끝에서 오른쪽 끝까지 가기 위한 최소 점프 횟수를 구하는 문제
 * 도달하지 못한다면 -1을 출력한다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * x+1, x+2, x+3을 브루트포스로 탐색하게 한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] maze = new int[n];
		for (int i = 0; i < n; i++)
			maze[i] = Integer.parseInt(st.nextToken());
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			if (dp[i] == Integer.MAX_VALUE)
				continue;
			for (int j = 1; j <= maze[i]; j++) {
				try {
					dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
				} catch (ArrayIndexOutOfBoundsException e) {
					break;
				}
			}
		}
		System.out.println(dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1]);
	}
}
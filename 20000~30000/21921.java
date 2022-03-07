package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 블로그를 n일동안 운영했다.
 * 이 n일 중에서 x일 동안 가장 많이 들어온 방문자 수와 기간이 몇 개가 있는지 구하는 문제
 * 최대 방문자 수가 0인 경우 SAD를 출력한다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * 누적합을 통해 x일 동안의 방문자 수를 빠르게 구한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		int max = 0;
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			int sum = arr[i] - arr[Math.max(i - x, 0)];
			if (sum > max) {
				max = sum;
				cnt = 1;
			} else if (sum == max)
				cnt++;
		}
		if (max == 0)
			System.out.println("SAD");
		else
			System.out.printf("%d\n%d", max, cnt);
	}
}
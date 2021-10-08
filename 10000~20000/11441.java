package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수열 N이 주어진다.
 * 이 수열의 i번째부터 j번쨰까지 수의 합을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 배열에 누적 합을 저장해두고 j번째 값 - i-1번째 값을 빼 i부터 j까지의 합을 구할 수 있다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			sb.append(arr[second] - arr[first - 1]).append("\n");
		}
		System.out.println(sb);
	}
}
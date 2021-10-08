package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 정수로 이루어진 배열 N이 있다.
 * 이 배열의 부분 배열 중 원소의 합이 가장 큰 최대 부분배열을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[] arr;

	/**
	 * 배열을 누적합으로 저장한다.
	 * 이후 브루트포스로 하나씩 더해보며 최대값인지 구한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[n + 1];
			for (int i = 1; i <= n; i++)
				arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
			sb.append(findMax()).append('\n');
		}
		System.out.print(sb);
	}

	public static int findMax() {
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < arr.length; i++)
			for (int j = i; j < arr.length; j++)
				max = Math.max(max, arr[j] - arr[i - 1]);
		return max;
	}
}
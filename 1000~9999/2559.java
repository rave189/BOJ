package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 원소가 들어있는 수열이 주어졌을 때,
 * 연속된 K개의 합이 가장 큰 값을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 처음 k개의 합을 구한 후 두 포인터로 이동하며 왼쪽을 빼고, 오른쪽을 더한다.
	 * 이후 최대값인지 확인하여 답을 구한다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int left = 0, right = k, sum = 0, answer = Integer.MIN_VALUE;
		for (int i = left; i < right; i++)
			sum += arr[i];
		while (right < n) {
			answer = Math.max(answer, sum);
			sum -= arr[left++];
			sum += arr[right++];
		}
		System.out.println(Math.max(answer, sum));
	}
}
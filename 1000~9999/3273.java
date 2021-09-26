package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * n개의 서로 다른 양의 정수가 주어진다.
 * 그리고 자연수 x가 주어졌을 때, a[i] + a[j] = x가 되는 i, j 쌍을 구하는 문제
 * i와 j는 같지 않다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * 브루트포스로 더하면 시간초과가 나온다.
	 * 따라서 두 포인터를 사용하여 양 끝에서부터 더해본다.
	 * x를 찾은 경우 왼쪽이나 오른쪽 아무데나 올리거나 내린다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int answer = 0;
		int start = 0;
		int end = n - 1;
		while (start < end) {
			int sum = arr[start] + arr[end];
			if (sum < x)
				start++;
			else if (sum == x) {
				answer++;
				start++;
			} else
				end--;
		}
		System.out.println(answer);
	}
}
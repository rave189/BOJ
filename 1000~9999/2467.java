package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 두 용액과 같은 문제
 * N개의 용액이 주어진다.
 * 용액은 각가의 특성값을 가지고 이 값은 -10억에서 10억까지의 값으로 표현할 수 있다.
 * 이 중 두 용액을 선택하여 특성값의 합이 0에 가까운 두 용액을 찾는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 한 개의 용액을 선형으로 선택한 후 다른 한 용액을 이분 탐색으로 찾는다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		int[] answer = {};
		for (int i = 0; i < n - 1; i++) {
			int left = i + 1, right = n - 1;
			// = 기호를 제거하면 i+1의 값을 탐색하지 못한다.
			while (left <= right) {
				int mid = (left + right) / 2;
				int sum = arr[i] + arr[mid];
				if (Math.abs(sum) < min) {
					min = Math.abs(sum);
					answer = new int[] { arr[i], arr[mid] };
				}
				if (sum < 0)
					left = mid + 1;
				else if (sum == 0)
					break;
				else
					right = mid - 1;
			}
		}
		System.out.println(String.format("%d %d", answer[0], answer[1]));
	}
}
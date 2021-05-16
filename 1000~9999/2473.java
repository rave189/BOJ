package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 특성값이 모두 다른 용액 N개가 있다.
 * 이 중에서 3개의 용액을 선택하여 특성값의 합이 0에 가장 가까운 용액을 만드는 문제
 * 답이 여러 개일 경우 아무거나 출력한다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * 한 개의 용액을 선형으로 선택한다.
	 * 이후 두 개의 용액을 이분 탐색으로 탐색한다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		// 용액을 정렬한다.
		Arrays.sort(arr);
		int[] answer = new int[3];
		long min = Long.MAX_VALUE;
		// 선형으로 i번째 용액을 선택
		for (int i = 0; i < n - 2; i++) {
			// i+1번째 용액와 n-1번째 용액을 기준으로 이분 탐색을 한다.
			int left = i + 1, right = n - 1;
			while (left < right) {
				// 용액의 값은 -10억부터 10억까지이므로 세 용액을 더하면 int의 범위를 초과한다.
				long sum = (long) arr[i] + arr[left] + arr[right];
				// 0에 더 가까우면 min과 answer을 업데이트한다.
				if (Math.abs(sum) < min) {
					answer = new int[] { arr[i], arr[left], arr[right] };
					min = Math.abs(sum);
				}
				if (sum > 0)
					right--;
				else if (sum == 0)
					break;
				else
					left++;
			}
		}
		System.out.println(String.format("%d %d %d", answer[0], answer[1], answer[2]));
	}
}
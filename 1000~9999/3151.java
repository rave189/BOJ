package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * n명의 사람 중에서 3명을 선택하여 합이 0이 되도록 하려고 한다.
 * 합이 0이 되는 경우의 수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 선형으로 한 사람을 선택한다.
	 * 이후 투 포인터를 이용하여 두 사람을 선택한다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().replaceAll(" ", ""));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		long answer = 0;
		for (int i = 0; i < n; i++) {
			// 한명을 선형으로 선택
			int first = arr[i];
			// 정렬 되어 있기 때문에 양수인 경우 더 선택할 사람이 없어짐
			if (first > 0)
				break;
			int left = i + 1;
			int right = n - 1;
			while (left < right) {
				// 합을 구한다.
				int sum = first + arr[left] + arr[right];
				if (sum > 0)
					right--;
				else if (sum < 0)
					left++;
				// 합이 0인 경우
				else {
					// left와 right가 같은 경우 정렬되어 있기 때문에 left와 right 사이에는 같은 값들만 존재한다.
					// 그러므로 right-left개의 수 중에서 2개를 선택하는 nC2가 된다.
					if (arr[left] == arr[right]) {
						answer += (right - left + 1) * (long) (right - left) / 2;
						break;
					} else {
						// arr[left]의 개수를 센다.
						int leftCnt = 1;
						int prev = arr[left];
						while (prev == arr[++left])
							leftCnt++;
						// arr[right]의 개수를 센다.
						int rightCnt = 1;
						prev = arr[right];
						while (prev == arr[--right])
							rightCnt++;
						// arr[left]의 개수와 arr[right]의 개수를 곱하여 경우의 수를 찾는다.
						answer += leftCnt * (long) rightCnt;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
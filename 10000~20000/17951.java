package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시험을 풀던 도중 현수의 시험지가 날라갔다.
 * 하지만 착한 조교는 시험이를 찾아와 현재 순서 그대로 K개의 그룹으로 나눈 뒤
 * 그룹에서 맞은 문제의 개수의 합을 구하고 그 중 최솟값을 점수로 인정해 주기로 한다.
 * 현수가 받을 수 있는 최대 점수를 출력하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 시험 점수의 최대값을 mid로 두어 이분 탐색을 시도해본다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int left = 0, right = 2000000;
		while (left <= right) {
			int mid = (left + right) / 2;
			int groupCnt = 0, sum = 0;
			for (int i = 0; i < n; i++) {
				sum += arr[i];
				// 시험 점수가 mid 이상이 될 때마다 group의 값을 증가시킨다.
				if (sum >= mid) {
					sum = 0;
					groupCnt++;
				}
			}
			if (groupCnt < k)
				right = mid - 1;
			else
				left = mid + 1;
		}
		System.out.println(left - 1);
	}
}
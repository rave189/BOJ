package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 막대 과자가 있다.
 * 이 막대 과자를 M명의 조카에게 같은 길이의 과자로 주려고 한다.
 * 과자는 조각을 낼 수는 있지만, 합칠 수는 없다.
 * 조카 1명에게 줄 수 있는 막대 과자의 최대 길이를 구하는 문제
 * 모든 조카에게 나눠줄 수 없다면 0을 출력한다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * 이분 탐색
	 * 오랜만에 해서 그런가 right를 더해주다가 자꾸 틀림.
	 * max로 바꾸는게 맞았음.
	 * 어차피 최소 길이가 1이기 때문에 왼쪽을 1로 두고 못주면 그대로 0이 나올 수 있게 함.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] cookies = new int[n];
		int left = 1, right = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cookies[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, cookies[i]);
		}
		while (left <= right) {
			int mid = (left + right) / 2;
			int count = 0;
			for (int i = 0; i < n; i++)
				count += cookies[i] / mid;
			if (count < m)
				right = mid - 1;
			else
				left = mid + 1;
		}
		System.out.println(left - 1);
	}
}
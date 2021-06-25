package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 용돈을 효율적으로 관리하기 위해 N일 중에 M번만 통장에서 돈을 인출하려고 한다.
 * 통장에서 K원을 인출하여 하루를 보낼 수 있다면 그대로 사용하고
 * 모자라면 남은 금액은 다시 통장에 넣고 다시 K원을 인출한다.
 * 만약 남은 금액이 그날 사용 금액보다 크더라도 M번을 맞추기 위해
 * 통장에 넣고 다시 인출할 수 있다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * 인출할 금액 K원을 mid로 잡고 이분 탐색을 한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] pay = new int[n];
		// right = 최대 금액 * 최대 일수
		int left = 0, right = 10000 * 100000;
		for (int i = 0; i < n; i++) {
			pay[i] = Integer.parseInt(br.readLine());
			left = Math.max(left, pay[i]);
		}
		if (n == 1) {
			System.out.println(pay[0]);
			return;
		}
		int answer = Integer.MAX_VALUE;
		while (left <= right) {
			int mid = (left + right) / 2;
			int count = 0;
			int money = 0;
			for (int i = 0; i < n; i++) {
				if (pay[i] > money) {
					count++;
					money = mid - pay[i];
				} else
					money -= pay[i];
			}
			if (count <= m) {
				answer = Math.min(answer, mid);
				right = mid - 1;
			} else
				left = mid + 1;
		}
		System.out.println(answer);
	}
}
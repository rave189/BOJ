package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 공을 K개의 바구니에 빠짐없이 나누어 담으려고 한다.
 * 각 바구니에는 공이 1개 이상 들어있어야 한다.
 * 각 바구니에 담긴 공의 개수는 모두 달라야 한다.
 * 가장 많이 담긴 바구니와 가장 적게 담긴 바구니의 공의 개수 차이가 최소가 되어야 한다.
 * 차이를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 우선 각 바구니에 공을 1개부터 k개까지 담는다.
	 * 이 때 담기지 않으면 -1을 출력하고 종료한다.
	 * 이후 가장 개수가 많은 바구니부터 순서대로 1개씩 공을 넣는다.
	 * 마지막 바구니와 처음 바구니를 빼서 차이를 구한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[k];
		for (int i = 1; i <= k; i++) {
			arr[i - 1] = i;
			n -= i;
		}
		if (n < 0) {
			System.out.println(-1);
			return;
		}
		int index = k - 1;
		while (n-- > 0) {
			arr[index--]++;
			if (index < 0)
				index = k - 1;
		}
		System.out.println(arr[k - 1] - arr[0]);
	}
}
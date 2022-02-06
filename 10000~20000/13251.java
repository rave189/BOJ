package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 상자에 N개의 조약돌이 들어있다.
 * 조약돌의 색상은 1부터 M까지 중의 하나이다.
 * 조약돌을 랜덤하게 K개 뽑았을 때, 모두 같은 색일 확률을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 각 조약돌의 색깔만 뽑는 확률을 모두 더해준다.
	 * 모두 같은 조약돌을 뽑을 확률은 (v-i)/(sum-i)이다. (0 <= i < k)
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		double sum = 0;
		int[] arr = new int[m];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		int k = Integer.parseInt(br.readLine());
		double answer = 0;
		for (int v : arr) {
			if (v < k)
				continue;
			answer += solution(sum, v, k);
		}
		System.out.println(answer);
	}

	public static double solution(double sum, int count, int k) {
		double result = 1;
		for (int i = 0; i < k; i++)
			result *= (count - i) / (sum - i);
		return result;
	}
}
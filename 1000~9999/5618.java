package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2개 혹은 3개의 자연수가 주어진다.
 * 이 수들의 공약수를 모두 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 단순 비교로 구함.
	 * 세 수의 최대공약수를 찾고, 최대 공약수의 약수를 구하는 방법이 가장 빠름.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			min = Math.min(arr[i], min);
		}
		for (int i = 1; i <= min; i++) {
			boolean isValid = true;
			for (int j = 0; j < n; j++)
				if (arr[j] % i != 0)
					isValid = false;
			if (isValid)
				answer.append(i).append('\n');
		}
		System.out.println(answer);
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 숫자로 이루어진 수열이 주어진다.
 * 이 수열의 부분 합 중에서 M으로 나누어 떨어지는 부분합의 수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * m의 최대값이 1000이므로 나머지의 종류는 0~ 999까지이다.
	 * 따라서 누적 합의 나머지를 mod에 저장하여 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n + 1];
		int[] mod = new int[1001];
		long answer = 0;
		for (int i = 1; i <= n; i++) {
			// 나머지의 누적 합을 구한다.
			arr[i] = (arr[i - 1] + Integer.parseInt(st.nextToken())) % m;
			// 나머지가 0이라면 answer을 증가시킨다.
			if (arr[i] == 0)
				answer++;
			// arr[i] ~ arr[j]까지의 누적 합 = arr[0]~arr[j] 누적합 - arr[0]~arr[i]까지의 누적 합 이다.
			// 그리고 나머지를 0으로 만드는게 목적이므로 나머지가 1이라면 1을 빼주어야 한다.
			// 따라서 같은 나머지의 수만큼 answer을 증가시킨다.
			answer += mod[arr[i]];
			mod[arr[i]]++;
		}
		System.out.println(answer);
	}
}
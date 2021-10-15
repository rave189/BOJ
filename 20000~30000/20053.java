package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 정수가 주어진다.
 * 이때, N개의 수들 중 최솟값과 최댓값을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				int value = Integer.parseInt(st.nextToken());
				min = Math.min(min, value);
				max = Math.max(max, value);
			}
			answer.append(min + " " + max).append("\n");
		}
		System.out.println(answer);
	}
}
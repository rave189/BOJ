package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 0 < a < b < n이고 (a^2 + b^2 + m)/ab가 정수인 쌍의 개수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 브루트포스를 사용하여 모든 경우를 탐색한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			sb.append(solution(n, m)).append('\n');
		}
		System.out.println(sb);
	}

	public static int solution(int n, int m) {
		int count = 0;
		for (double i = 1; i < n; i++)
			for (double j = i + 1; j < n; j++) {
				double result = (i * i + j * j + m) / (i * j);
				if (result == (int) result)
					count++;
			}
		return count;
	}
}
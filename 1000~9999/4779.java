package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 다음과 같은 과정을 통해 칸토어 집합의 근사를 구하는 문제
 * 1. -가 3^N개 있는 문자열에서 시작한다.
 * 2. 문자열을 3등분 한 뒤, 가운데 문자열을 공백으로 바꾼다. 이렇게 하면, 선(문자열) 2개가 남는다.
 * 3. 이제 각 선(문자열)을 3등분 하고, 가운데 문자열을 공백으로 바꾼다. 이 과정은 모든 선의 길이가 1일때 까지 계속 한다.
 * 예시)
 * n == 0: -
 * n == 1: - -
 * n == 2: - -   - -
 * @author Rave
 *
 */
public class Main {

	static boolean[] binary;

	/**
	 * 분할 정복을 통해 왼쪽 가운데 오른쪽으로 나누어 해결한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		String[] result = new String[13];
		for (int i = 0; i < result.length; i++) {
			binary = new boolean[(int) Math.pow(3, i)];
			backTracking(i, 0, binary.length);
			StringBuilder sb = new StringBuilder();
			for (boolean bool : binary)
				if (bool)
					sb.append('-');
				else
					sb.append(' ');
			result[i] = sb.toString();
		}
		String input;
		while ((input = br.readLine()) != null) {
			int n = Integer.parseInt(input);
			answer.append(result[n]).append('\n');
		}
		System.out.println(answer);
	}

	public static void backTracking(int n, int left, int right) {
		if (n < 0)
			return;
		else if (n == 0)
			binary[left] = true;
		else {
			int divide = (right - left) / 3;
			backTracking(n - 1, left, left + divide);
			backTracking(n - 1, right - divide, right);
		}
	}
}
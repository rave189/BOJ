package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ������ ���� ������ ���� ĭ��� ������ �ٻ縦 ���ϴ� ����
 * 1. -�� 3^N�� �ִ� ���ڿ����� �����Ѵ�.
 * 2. ���ڿ��� 3��� �� ��, ��� ���ڿ��� �������� �ٲ۴�. �̷��� �ϸ�, ��(���ڿ�) 2���� ���´�.
 * 3. ���� �� ��(���ڿ�)�� 3��� �ϰ�, ��� ���ڿ��� �������� �ٲ۴�. �� ������ ��� ���� ���̰� 1�϶� ���� ��� �Ѵ�.
 * ����)
 * n == 0: -
 * n == 1: - -
 * n == 2: - -   - -
 * @author Rave
 *
 */
public class Main {

	static boolean[] binary;

	/**
	 * ���� ������ ���� ���� ��� ���������� ������ �ذ��Ѵ�.
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
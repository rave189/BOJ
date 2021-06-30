package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * â���̴� 4�� 7�� �̷���� ���� �����Ѵ�.
 * â���̰� �����ϴ� �� �߿��� K��° ���� ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * �� ������ �������� 4�� 7�� ǥ���ϴ� �����̴�.
	 * K��° ���� ���ϱ� ���ؼ��� K+1�� �������� ���ϰ� ù ��° �ڸ��� �����־� ���� �� �ִ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer answer = new StringBuffer();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()) + 1;
		// reverse���� 2������ ���ϴ� �����̴�.
		while (n > 0) {
			sb.append((n % 2));
			n /= 2;
		}
		sb = sb.reverse();
		sb.deleteCharAt(0);
		for (int i = 0; i < sb.length(); i++)
			answer.append(sb.charAt(i) == '1' ? "7" : "4");
		System.out.println(answer);
	}
}
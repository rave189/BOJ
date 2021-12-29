package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 3���� Ĭ������ �־��� ��, ���� ���ִ� Ĭ������ ����� ����
 * Ĭ������ ���� ���� ��ȣ�� �־�����, Ĭ������ ������ ���� ��ȣ�� ���� �ȴ�.
 * Ĭ������ ������ Ȧ���� Ĭ������ ���� ���ִ�.
 * ����, �Ȱ��� Ȧ���̰ų� ¦���� Ĭ���� �߿����� ���� �� ū Ĭ������ �� ���ִٰ� ������.
 * @author Rave
 *
 */
public class Main {

	/**
	 * �ϴ� Ȧ���� ������ ������ Ȧ���� ���Ѱ� �� ���ִ�.
	 * ¦���� �ִٸ� ���� ū Ĭ������ �������Ƿ� ���δ� ���Ѱ� ���� ���ִ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 1, evenAnswer = 1;
		boolean isOdd = false;
		for (int i = 0; i < 3; i++) {
			int v = Integer.parseInt(st.nextToken());
			if (v % 2 != 0) {
				isOdd = true;
				answer *= v;
			}
			evenAnswer *= v;
		}
		System.out.println(isOdd ? answer : evenAnswer);
	}
}
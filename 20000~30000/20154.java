package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ���ĺ� �빮�ڰ� �Է����� �־�����.
 * �� ���ڸ� ȹ���� ��ȯ�Ѵ�.
 * ���� �� ���� ¦�� ���� �����ش�. ���� �ϳ��� ���´ٸ� �״�� ���� �ܰ�� �����Ѵ�.
 * ���� �ܰ�� ���� �ܰ�� ���������� �� ���� ¦�� ���� �����ִ� �۾��� �ݺ��Ѵ�.
 * ���� ���� ���� 10�� �Ѿ�� 10���� ���� �������� �ٲپ��ش�.
 * ���������� ���� ���� Ȧ���̸� I'm a winner!�� �ƴ϶�� You're the winner?�� ����ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int[] alphabet = { 3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1 };

	/**
	 * �ᱹ ���������� ���ؾ� �ϴ� �����̹Ƿ� ¦�� ���� ������ �ʰ� ���� ���� ���� Ȧ������ �ƴ����� ���Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int answer = 0;
		for (char ch : input.toCharArray())
			answer += alphabet[ch - 'A'];
		System.out.println(answer % 2 == 1 ? "I'm a winner!" : "You're the winner?");
	}
}
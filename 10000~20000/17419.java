package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * N�ڸ� ������ K�� �ִ�.
 * K = K-(K&(~K)+1))�� �����Ͽ� K�� 0�� �ǵ��� �Ϸ��� �Ѵ�.
 * ������ �� �� �����ϴ����� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * �� ��ü�� �� ������ 1�� ���ִ� ���̴�.
	 * ���� 1�� ������ ���� �ذ��� �� �ִ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int answer = 0;
		for (char ch : input.toCharArray())
			if (ch == '1')
				answer++;
		System.out.println(answer);
	}
}
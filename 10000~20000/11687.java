package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ���� �P�� 0�� ������ M�� N! �� ���� ���� N�� ã�� ����
 * �������� �ʴ´ٸ� -1�� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	/**
	 * 5�� �����ָ� 5�� ������ŭ m�� ���ش�.
	 * m == 0�̸� ������ �����ϰ�, ������ ��� �������� �����Ƿ� -1�� ����Ѵ�.
	 * 
	 * 5/5 = 1, 10/5 = 2 ó�� N!�� ����ִ� 5�� ������ ������� �ٷ� �� �� ����
	 * �̸� �̿��Ͽ� m�� ã�� �̺� Ž���� �� �� ����.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		long answer = 0;
		while (m > 0) {
			answer += 5;
			int fiveCnt = getFiveCnt(answer);
			m -= fiveCnt;
		}
		System.out.println(m == 0 ? answer : -1);
	}

	public static int getFiveCnt(long n) {
		int count = 0;
		while (n % 5 == 0) {
			count++;
			n /= 5;
		}
		return count;
	}
}
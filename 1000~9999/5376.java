package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * �Ҽ��� ���м��� �ٲٴ� ����
 * ����� ����/�и�� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	/**
	 * ��ȯ�Ҽ��� �ڸ����� 9�� ��ȯ�Ҽ��� �ƴ� �κп��� 0�� ä�� �и� ���Ѵ�.
	 * ���� ¥�ϱ� �ȵ�
	 * ���� �� ������...
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			String num = br.readLine();
			int idx = 2;
			long numerator = 0;
			// ���ȯ�Ҽ� ���ϱ�
			for (; idx < num.length(); idx++) {
				if (num.charAt(idx) == '(')
					break;
				numerator = numerator * 10 + (num.charAt(idx) - '0');
			}
			int noCircleLength = idx - 2;
			int circleLength = 0;
			// ��ü���� ��ȯ�Ҽ��� ������ ���Ѵ�. 
			long noCircle = numerator;
			for (; idx < num.length(); idx++) {
				if (num.charAt(idx) == '(' || num.charAt(idx) == ')')
					continue;
				numerator = numerator * 10 + (num.charAt(idx) - '0');
				circleLength++;
			}
			// ��ȯ�Ҽ��� ������ ��ü���� ��ȯ�Ҽ� �κ��� ���ش�.
			if (numerator != noCircle)
				numerator -= noCircle;
			long denominator = 0;
			// ��ȯ�Ҽ� �ڸ���ŭ 9 ä���
			while (circleLength-- > 0)
				denominator = denominator * 10 + 9;
			// ��ȯ�Ҽ��� ������ 1�� �ٽ� �ʱ�ȭ ���ֱ�
			if (denominator == 0)
				denominator = 1;
			// ���ȯ�Ҽ� �ڸ���ŭ 0 ä���
			while (noCircleLength-- > 0)
				denominator = denominator * 10;
			long gcd = gcd(numerator, denominator);
			answer.append(String.format("%d/%d", numerator / gcd, denominator / gcd)).append('\n');
		}
		System.out.print(answer);
	}

	public static long gcd(long a, long b) {
		while (a % b > 0) {
			long r = a % b;
			a = b;
			b = r;
		}
		return b;
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ���� �ƴ� ������ ���� ū �ڸ������� ���� �ڸ������� �����Ѵٸ�, �� ���� �����ϴ� ����� �Ѵ�.
 * N�� �־��� ��, N��° �����ϴ� ���� ���Ѵ�.
 * N��° �����ϴ� ���� ���ٸ� -1�� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long answer = 1;
		for (int i = 0; i != n;) {
			// 9876543210�� �Ѿ�� �����ϴ� ���� ���� ���� ����.
			if (answer > 98765432210L) {
				System.out.println(-1);
				return;
			}
			int check = isDecrease(Long.toString(answer));
			// -1�� answer�� �����ϴ� ����� ǥ���̹Ƿ� i�� answer�� ������Ų��.
			if (check == -1) {
				i++;
				answer++;
			} 
			// -1�� �ƴ϶�� �����ϴ� ���� �ƴϹǷ� 10^(check-1)��ŭ �ǳʶڴ�.
			else
				answer += Math.pow(10, check);
		}
		System.out.println(answer - 1);
	}

	/**
	 * str�� �����ϴ� ������ �˻��Ѵ�.
	 * �����ϴ� ����� -1�� ��ȯ�Ѵ�.
	 * �����ϴ� ���� �ƴ϶�� �����ϴ� ���� �ƴϰԵ� �ڸ����� ��ȯ�Ѵ�.
	 * @param str �����ϴ��� �˻��� ��
	 * @return -1�̸� �����ϴ� ���̰�, �ٸ� ���̸� �����ϴ� ���� �ƴϰ� �� �ڸ����� ��ȯ�Ѵ�.
	 */
	public static int isDecrease(String str) {
		for (int i = 1; i < str.length(); i++)
			if (str.charAt(i - 1) <= str.charAt(i))
				return str.length() - i - 1;
		return -1;
	}
}
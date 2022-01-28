package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * (0, 0)���� (x, y)�� �����ϴ� ������ �ٸ� ���� ������� �ʴ� (x, y)�� �������� �������� �Ѵ�.
 * N�� �־����� ��, 0<=N<=x, y�� x, y�� ������ ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * (0, 1), (1, 0) �� ���� �⺻
	 * (1, 1)�� ������ (i, i)�� �ȵ�
	 * ������ x, y�� gcd�� 1�̸� �߰��� ����ġ�� ���� ���ٴ� ���̴�.
	 * �߰��Ǵ� ���̴� y=x ��Ī�̹Ƿ� ���ʸ� ���ؼ� 2�� ���ָ� ���� �� ����.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int[] arr = new int[1001];
		arr[0] = 2;
		arr[1] = 1;
		for (int i = 1; i < arr.length; i++) {
			arr[i] += arr[i - 1];
			int sum = 0;
			for (int j = 1; j < i; j++)
				if (gcd(i, j) == 1)
					sum++;
			arr[i] += sum * 2;
		}
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0)
			answer.append(arr[Integer.parseInt(br.readLine())]).append('\n');
		System.out.println(answer);
	}

	public static int gcd(int a, int b) {
		while (a % b > 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return b;
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ũ�Ⱑ NxN�� �迭 A�� �ִ�.
 * �� �迭�� �� A[i][j] = i*j�̴�.
 * �� �� k��° ���� ���� ã�� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * k��° ���� min(mid/i, n)�� �̿��Ͽ� ���� �� �ִ�.
	 * ���⼭ mid�� ������ ���̰�, i�� ���� �ǹ��Ѵ�.
	 * i��° �ٿ��� ������ �� mid���� ���� ���� ������ ã�� ���̴�.
	 * ���� ���� ������ n���� ũ�ٸ� n�� ��ȯ�ؾ� �Ѵ�.
	 * 1 2 3
	 * 2 4 6
	 * 3 6 9
	 * n = 3�� �迭���� mid�� 4���
	 * 1��° �࿡���� mid(4/1, 3)�� 3���� ������
	 * 2���� �࿡���� mid(4/2, 3)�� 2���� ������
	 * 3��° �࿡���� mid(4/3, 3)�� 1���� ���´�.
	 * ���� 4�� 6��° ����� ���� �� �� �ִ�.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int left = 0, right = k;
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;
			for (int i = 1; i <= n; i++)
				cnt += Math.min(mid / i, n);
			if (cnt >= k)
				right = mid - 1;
			else
				left = mid + 1;
		}
		System.out.println(left);
	}
}
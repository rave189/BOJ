package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N���� ���� K���� �ٱ��Ͽ� �������� ������ �������� �Ѵ�.
 * �� �ٱ��Ͽ��� ���� 1�� �̻� ����־�� �Ѵ�.
 * �� �ٱ��Ͽ� ��� ���� ������ ��� �޶�� �Ѵ�.
 * ���� ���� ��� �ٱ��Ͽ� ���� ���� ��� �ٱ����� ���� ���� ���̰� �ּҰ� �Ǿ�� �Ѵ�.
 * ���̸� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * �켱 �� �ٱ��Ͽ� ���� 1������ k������ ��´�.
	 * �� �� ����� ������ -1�� ����ϰ� �����Ѵ�.
	 * ���� ���� ������ ���� �ٱ��Ϻ��� ������� 1���� ���� �ִ´�.
	 * ������ �ٱ��Ͽ� ó�� �ٱ��ϸ� ���� ���̸� ���Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[k];
		for (int i = 1; i <= k; i++) {
			arr[i - 1] = i;
			n -= i;
		}
		if (n < 0) {
			System.out.println(-1);
			return;
		}
		int index = k - 1;
		while (n-- > 0) {
			arr[index--]++;
			if (index < 0)
				index = k - 1;
		}
		System.out.println(arr[k - 1] - arr[0]);
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N���� ���� ���ڰ� �ִ�.
 * �� ���� ���ڸ� M���� ��ī���� ���� ������ ���ڷ� �ַ��� �Ѵ�.
 * ���ڴ� ������ �� ���� ������, ��ĥ ���� ����.
 * ��ī 1���� �� �� �ִ� ���� ������ �ִ� ���̸� ���ϴ� ����
 * ��� ��ī���� ������ �� ���ٸ� 0�� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	/**
	 * �̺� Ž��
	 * �������� �ؼ� �׷��� right�� �����ִٰ� �ڲ� Ʋ��.
	 * max�� �ٲٴ°� �¾���.
	 * ������ �ּ� ���̰� 1�̱� ������ ������ 1�� �ΰ� ���ָ� �״�� 0�� ���� �� �ְ� ��.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] cookies = new int[n];
		int left = 1, right = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cookies[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, cookies[i]);
		}
		while (left <= right) {
			int mid = (left + right) / 2;
			int count = 0;
			for (int i = 0; i < n; i++)
				count += cookies[i] / mid;
			if (count < m)
				right = mid - 1;
			else
				left = mid + 1;
		}
		System.out.println(left - 1);
	}
}
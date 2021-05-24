package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ������ Ǯ�� ���� ������ �������� ���󰬴�.
 * ������ ���� ������ �����̸� ã�ƿ� ���� ���� �״�� K���� �׷����� ���� ��
 * �׷쿡�� ���� ������ ������ ���� ���ϰ� �� �� �ּڰ��� ������ ������ �ֱ�� �Ѵ�.
 * ������ ���� �� �ִ� �ִ� ������ ����ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * ���� ������ �ִ밪�� mid�� �ξ� �̺� Ž���� �õ��غ���.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int left = 0, right = 2000000;
		while (left <= right) {
			int mid = (left + right) / 2;
			int groupCnt = 0, sum = 0;
			for (int i = 0; i < n; i++) {
				sum += arr[i];
				// ���� ������ mid �̻��� �� ������ group�� ���� ������Ų��.
				if (sum >= mid) {
					sum = 0;
					groupCnt++;
				}
			}
			if (groupCnt < k)
				right = mid - 1;
			else
				left = mid + 1;
		}
		System.out.println(left - 1);
	}
}
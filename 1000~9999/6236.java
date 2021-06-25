package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �뵷�� ȿ�������� �����ϱ� ���� N�� �߿� M���� ���忡�� ���� �����Ϸ��� �Ѵ�.
 * ���忡�� K���� �����Ͽ� �Ϸ縦 ���� �� �ִٸ� �״�� ����ϰ�
 * ���ڶ�� ���� �ݾ��� �ٽ� ���忡 �ְ� �ٽ� K���� �����Ѵ�.
 * ���� ���� �ݾ��� �׳� ��� �ݾ׺��� ũ���� M���� ���߱� ����
 * ���忡 �ְ� �ٽ� ������ �� �ִ�.
 * @author Rave
 *
 */
public class Main {

	/**
	 * ������ �ݾ� K���� mid�� ��� �̺� Ž���� �Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] pay = new int[n];
		// right = �ִ� �ݾ� * �ִ� �ϼ�
		int left = 0, right = 10000 * 100000;
		for (int i = 0; i < n; i++) {
			pay[i] = Integer.parseInt(br.readLine());
			left = Math.max(left, pay[i]);
		}
		if (n == 1) {
			System.out.println(pay[0]);
			return;
		}
		int answer = Integer.MAX_VALUE;
		while (left <= right) {
			int mid = (left + right) / 2;
			int count = 0;
			int money = 0;
			for (int i = 0; i < n; i++) {
				if (pay[i] > money) {
					count++;
					money = mid - pay[i];
				} else
					money -= pay[i];
			}
			if (count <= m) {
				answer = Math.min(answer, mid);
				right = mid - 1;
			} else
				left = mid + 1;
		}
		System.out.println(answer);
	}
}
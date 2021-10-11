package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ĸƾ �̴ټ��� ���� �����ϱ� ���� �������� ���� �����Ѵ�.
 * ���� ����� ������ ����.
 * �������� ���ü ������� �׾� ���´�.
 * ���ü�� ���̰� N�� ���ﰢ�� ����� �����.
 * �� ���� ���̰� N-1�� ���ﰢ�� ����� ��� ������ �ݺ��Ͽ� 1ũ���� ���ﰢ�� ����� ������ �ȴ�.
 * ������ �ﰢ���� 1, 3, 6, 10 ...�� ���� �ְ� �� ���ü�� 1, 4, 10, 20 ...���� ������ ���� ���̴�.
 * �ټ��̴� ���ü�� ���� ���� ����� �������� �����ϰ� �ʹ�.
 * ���ü�� �ּ� ������ ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * ���ü�� ���ԵǴ� �������� ���� �̸� �����صд�.
	 * ���� 1������ N������ ������ ����� ���ϸ� ���ü�� �ּҰ� �Ǵ� ��츦 dp�� �����Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cannon = new int[122];
		for (int i = 1, count = 1; i < cannon.length; i++, count++)
			cannon[i] = cannon[i - 1] + count;
		for (int i = 1; i < cannon.length; i++)
			cannon[i] += cannon[i - 1];
		int[] dp = new int[n + 1];
		int idx = 1;
		for (int i = 1; i < dp.length; i++) {
			// ���� �������� �����ص� ���ü�� �����˺��� ũ�ٸ� idx ����
			if (i > cannon[idx])
				idx++;
			// ���ü�� ���� �����˰� i�� ������ ������ 1
			if (i == cannon[idx])
				dp[i] = 1;
			else {
				// ���ü�� ������ �ּҰ� �Ǵ� ��츦 ã�´�.
				int min = Integer.MAX_VALUE;
				for (int j = 1; j < idx; j++)
					min = Math.min(min, dp[i - cannon[j]] + 1);
				dp[i] = min;
			}
		}
		System.out.println(dp[n]);
	}
}
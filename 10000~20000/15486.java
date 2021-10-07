package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �����̴� �������� ���ϰ� �ְ� ��縦 �Ϸ��� �Ѵ�.
 * ����ϱ� ������ �ִ��� ���� ����� �Ͽ� �ִ� ������ �������� �Ѵ�.
 * ����� Ti���� �ɸ���, �׿� ���� ���̴� Pi�̴�.
 * �����̰� ���� �� �ִ� �ִ� ������ ���ϴ� ����
 * 
 * @author Rave
 *
 */
public class Main {

	/**
	 * ���� ����� ������ ��� ����� ����� ��¥�� ���� �ݾ� + �޴� �ݾ��� ���� �����Ѵ�.
	 * ����� �������� �ʴ� ��� ���� �ݾװ� ���� ���� �ݾ� �� ū ������ �����Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n];
		int[] pay = new int[n];
		int[] dp = new int[n + 1];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			pay[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			try {
				int nextPay = dp[i] + pay[i];
				int workingTime = i + time[i];
				// ����� ���� �ʴ� ���
				dp[i + 1] = Math.max(dp[i + 1], dp[i]);
				// ����� �ϴ� ���
				dp[workingTime] = Math.max(dp[workingTime], nextPay);
			} catch (Exception e) {
			}
		}
		System.out.println(dp[n]);
	}
}
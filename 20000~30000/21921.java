package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ��α׸� n�ϵ��� ��ߴ�.
 * �� n�� �߿��� x�� ���� ���� ���� ���� �湮�� ���� �Ⱓ�� �� ���� �ִ��� ���ϴ� ����
 * �ִ� �湮�� ���� 0�� ��� SAD�� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	/**
	 * �������� ���� x�� ������ �湮�� ���� ������ ���Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		int max = 0;
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			int sum = arr[i] - arr[Math.max(i - x, 0)];
			if (sum > max) {
				max = sum;
				cnt = 1;
			} else if (sum == max)
				cnt++;
		}
		if (max == 0)
			System.out.println("SAD");
		else
			System.out.printf("%d\n%d", max, cnt);
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N���� ������ �־�����.
 * �� ������ �� ������ �� K�� �����ϰ� ������ N-1���� �� �߿��� �ִ� ������� ã�´�.
 * �̶� �ִ������� K�� ����� ���� �ʾƾ� �Ѵ�.
 * ���� ū �ִ������� ���ϰ� �̶��� K�� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * �������� ������ ��Ŭ���� ȣ���� ����
	 * gcd(a, b, c) = gcd(gcd(a, b), c)�̴�.
	 * �̸� �����Ͽ� ���ʺ����� �ִ������� ������ ������ �ִ� ������� �̸� ���صд�.
	 * ���� i��° ���� �����ϰ�, i-1�������� �ִ� ������� left[i-1]�� i+1�������� �ִ� ������� right[i+1]�� �ִ� ������� ���Ѵ�.
	 * �� �ִ� ������� k�� ������ ���� �ʰ� ���� ū ���̸� max�� K�� �����Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 2];
		int[] left = new int[n + 2];
		int[] right = new int[n + 2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; i++)
			left[i] = gcd(arr[i], left[i - 1]);
		for (int i = n; i >= 1; i--)
			right[i] = gcd(right[i + 1], arr[i]);
		int max = 0, idx = 0;
		for (int i = 1; i <= n; i++) {
			int gcd = gcd(left[i - 1], right[i + 1]);
			if (arr[i] % gcd != 0 && gcd > max) {
				max = gcd;
				idx = i;
			}
		}
		System.out.println(max == 0 ? -1 : max + " " + arr[idx]);
	}

	public static int gcd(int a, int b) {
		while (b > 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
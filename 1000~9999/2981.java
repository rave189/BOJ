package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * N���� ���� �ִ�.
 * �� ������ M���� �������� ��, ��� �������� ���� M�� ��� ���ϴ� ����
 * M�� 1�� �̻� ���� �� ������, ������������ ����ؾ� �Ѵ�.
 * @author Rave
 *
 */
public class Main {

	/**
	 * �������� ���ƾ� �ϹǷ� ������ ���� ǥ���� �� �ִ�.
	 * A = G*a + R
	 * B = G*b + R
	 * A-B = G(a-b)
	 * �� ���� �� ���� ����� ��� ���ϸ� �ȴ�.
	 * ���� ���� �� �̹Ƿ� a[1]-a[0], a[2]-a[1] .. a[n] - a[n-1]���� ���ϰ�
	 * ���� ������ �ִ� ������� ã�� �ִ� ������� ���� ����� ���ϸ� Ǯ �� �ִ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int gcd = arr[1] - arr[0];
		for (int i = 1; i < n; i++)
			gcd = gcd(gcd, arr[i] - arr[i - 1]);
		TreeSet<Integer> result = new TreeSet<>();
		for (int i = 2; i <= gcd; i++)
			if (gcd % i == 0)
				result.add(i);
		for (int v : result)
			answer.append(v).append(' ');
		System.out.println(answer);
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
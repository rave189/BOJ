package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N���� a�� M���� z�� �̷���� ������ �ִ�.
 * �������� ���ĺ� ������ ���ϵǾ� �ִ�.
 * �� �� K��° ���ڿ��� �������� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int k;
	static long[][] pascal;

	/**
	 * ī���� ������ �ſ� ����� ����
	 * a�� z�θ� �̷���� �����Ƿ� n+m���� ���ڿ� �� a�� �� �� �ִ� n���� �ڸ��� ����.(���� ���)
	 * k�� �ִ밪�� 10���̹Ƿ� Integer.MAX_VALUE���� ū ���� �Ľ�Į�� �ﰢ���� ���� �ʿ䰡 ����.
	 * ���� n+mCn���� �����Ͽ� �� �ڸ��� a�� �־�� �ϴ��� z�� �־�� �ϴ��� Ȯ���غ���.
	 * n+mCn���� n+m-1Cn-1�� ���� k���� ũ�� a�� �� �� �ִ� �ڸ��̰�, k���� ������ a�� ���� �� �ִ� ���ڿ��� ������ ũ�Ƿ� z�� ����.
	 * n == m == 0�� ��쿡 Ż���ϵ��� �ϰ�, n==0�̸� z��, m==0�̸� a�� �߰����ָ鼭 n�� m�� 0���� �����.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		pascal = new long[n + m + 1][];
		for (int i = 0; i < pascal.length; i++) {
			pascal[i] = new long[i + 1];
			for (int j = 0; j < pascal[i].length; j++) {
				try {
					pascal[i][j] = Math.min(Integer.MAX_VALUE, pascal[i - 1][j - 1] + pascal[i - 1][j]);
				} catch (ArrayIndexOutOfBoundsException e) {
					pascal[i][j] = 1;
				}
			}
		}
		try {
			System.out.println(findString(n + m, n));
		} catch (Exception e) {
			System.out.println(-1);
		}
	}

	public static String findString(int n, int m) {
		if (n == 0 && m == 0)
			return "";
		else if (n == 0)
			return 'a' + findString(n, m - 1);
		else if (m == 0)
			return 'z' + findString(n - 1, m);
		else if (k <= pascal[n - 1][m - 1]) {
			return 'a' + findString(n - 1, m - 1);
		} else {
			k -= pascal[n - 1][m - 1];
			return 'z' + findString(n - 1, m);
		}
	}
}
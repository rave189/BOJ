package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1���� N������ ���� ������ N!���� �ִ�.
 * �� ������ �߿��� k�� �־����� k��° ������ ����ϰ�
 * ������ �־����� �� ��° �������� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static long nFacto = 1;
	static boolean[] visited;

	/**
	 * n�� 4�� ��� n! = 24�̴�.
	 * ù ��° ���ڸ� �����ϱ� ���ؼ��� n-1! = 6�� ������ ���� �� �ִ�.
	 * 1�̸� 1~6 ����, 2�̸� 7 ~ 12 ����, 3�̸� 13 ~ 18 ����, 4�̸� 19 ~ 24 ���̿� �ִ� �������� �� �� �ִ�. 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int command = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; i++)
			nFacto *= i;
		if (command == 1) {
			long k = Long.parseLong(st.nextToken());
			System.out.println(findPermutation(n, k));
		} else {
			int[] permutation = new int[n];
			for (int i = 0; i < n; i++)
				permutation[i] = Integer.parseInt(st.nextToken());
			System.out.println(findSequence(permutation, 0, n) + 1);
		}
	}

	public static String findPermutation(int n, long k) {
		if (n == 0)
			return "";
		nFacto /= n;
		for (int i = 1; i < visited.length; i++) {
			if (visited[i])
				continue;
			if (k <= nFacto) {
				visited[i] = true;
				return i + " " + findPermutation(n - 1, k);
			} else
				k -= nFacto;
		}
		return "";
	}

	public static long findSequence(int[] permutation, int cur, int n) {
		if (n == 0)
			return 0;
		nFacto /= n;
		long sum = 0;
		for (int i = 1; i < visited.length; i++) {
			if (visited[i])
				continue;
			if (permutation[cur] == i) {
				visited[i] = true;
				return sum + findSequence(permutation, cur + 1, n - 1);
			} else
				sum += nFacto;
		}
		return 0;
	}
}
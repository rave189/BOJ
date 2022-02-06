package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1부터 N까지의 수의 순열은 N!개가 있다.
 * 이 순열들 중에서 k가 주어지면 k번째 순열을 출력하고
 * 순열이 주어지면 몇 번째 순열인지 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static long nFacto = 1;
	static boolean[] visited;

	/**
	 * n이 4인 경우 n! = 24이다.
	 * 첫 번째 숫자를 결정하기 위해서는 n-1! = 6을 가지고 구할 수 있다.
	 * 1이면 1~6 사이, 2이면 7 ~ 12 사이, 3이면 13 ~ 18 사이, 4이면 19 ~ 24 사이에 있는 순열임을 알 수 있다. 
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
package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * N개의 수가 있다.
 * 이 수들을 M으로 나누었을 때, 모두 나머지가 같은 M을 모두 구하는 문제
 * M은 1개 이상 나올 수 있으며, 오름차순으로 출력해야 한다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * 나머지가 같아야 하므로 다음과 같이 표현할 수 있다.
	 * A = G*a + R
	 * B = G*b + R
	 * A-B = G(a-b)
	 * 두 수를 뺀 값의 약수를 모두 구하면 된다.
	 * 수가 여러 개 이므로 a[1]-a[0], a[2]-a[1] .. a[n] - a[n-1]들을 구하고
	 * 구한 수들의 최대 공약수를 찾고 최대 공약수에 대한 약수를 구하면 풀 수 있다.
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
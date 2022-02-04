package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 자연수와 M개의 자연수가 주어진다.
 * N개의 자연수를 모두 곱하면 A가 되고, M개의 자연수를 모두 곱하면 B가 된다.
 * A와 B의 최대공약수를 구하는 문제
 * 최대공약수가 10자리가 넘어가면 마지막 9자리만 출력한다.
 * @author Rave
 *
 */
public class Main {

	static int mod = 1000000000;
	static boolean over = false;

	/**
	 * 완탐으로 안될거같아서 이것저것 해봤는데, 그냥 완탐돌리는게 젤 편하네...
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		long[] b = new long[m];
		for (int i = 0; i < m; i++)
			b[i] = Integer.parseInt(st.nextToken());
		long answer = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				long gcd = gcd(a[i], b[j]);
				answer *= gcd;
				answer = isOver(answer);
				a[i] /= gcd;
				b[j] /= gcd;
			}
		}
		if (over)
			System.out.println(String.format("%09d", answer));
		else
			System.out.println(answer);
	}

	public static long isOver(long a) {
		if (a >= mod) {
			over = true;
			return a % mod;
		}
		return a;
	}

	public static long gcd(long a, long b) {
		while (a % b > 0) {
			long r = a % b;
			a = b;
			b = r;
		}
		return b;
	}
}
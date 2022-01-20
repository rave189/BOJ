package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 정수가 주어진다.
 * 이 정수들 중 임의의 수 K를 제외하고 나머지 N-1개의 수 중에서 최대 공약수를 찾는다.
 * 이때 최대공약수가 K의 약수가 되지 않아야 한다.
 * 가장 큰 최대공약수를 구하고 이때의 K를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 누적합을 응용한 유클리드 호제법 문제
	 * gcd(a, b, c) = gcd(gcd(a, b), c)이다.
	 * 이를 응용하여 왼쪽부터의 최대공약수와 오른쪽 부터의 최대 공약수를 미리 구해둔다.
	 * 이후 i번째 수를 제거하고, i-1번까지의 최대 공약수인 left[i-1]과 i+1번까지의 최대 공약수인 right[i+1]의 최대 공약수를 구한다.
	 * 이 최대 공약수가 k와 나누어 지지 않고 가장 큰 값이면 max와 K를 변경한다.
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
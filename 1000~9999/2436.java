package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 두 자연수의 최대공약수와 최소공배수가 주어진다.
 * 이 때, 두 자연수의 합이 최소가 되는 두 자연수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 합이 최소 = 차이의 최소?
	 * 차이가 최소라고 생각하고 풀었는데 맞음...(뭐지?)
	 * lcm/gcd를 하면 a/gcd * b/gcd가 나옴.
	 * 따라서 두 수가 서로소이면서 두 수의 곱이 lcm/gcd인 두 수를 찾고, 출력할 때 gcd를 곱해주면 구할 수 있음.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int gcd = Integer.parseInt(st.nextToken());
		int lcm = Integer.parseInt(st.nextToken());
		int divide = lcm / gcd;
		int[] nums = { 1, divide };
		for (int first = 2; first <= divide; first++) {
			if (divide % first == 0) {
				int second = divide / first;
				if (gcd(first, second) != 1)
					continue;
				if (first > second)
					break;
				int diff = nums[1] - nums[0];
				int compare = second - first;
				if (compare < diff)
					nums = new int[] { first, second };
			}
		}
		System.out.println(String.format("%d %d", nums[0] * gcd, nums[1] * gcd));
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
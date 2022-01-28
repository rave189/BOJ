package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 자연수 N을 연속된 소수의 합으로 나타내는 경우의 수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * N까지의 소수를 에라토스테네스의 체로 모두 구한다.
	 * 연속된 소수이므로 두 포인터를 이용하여 N이 되는 경우의 수를 모두 찾는다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> primeNumber = new ArrayList<>();
		boolean[] isNotPrime = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			if (isNotPrime[i])
				continue;
			primeNumber.add(i);
			for (int j = i + i; j <= n; j += i)
				isNotPrime[j] = true;
		}
		int left = 0, right = 0, sum = 0;
		long answer = 0;
		while (right < primeNumber.size()) {
			if (sum + primeNumber.get(right) < n) {
				sum += primeNumber.get(right++);
			} else {
				if (sum + primeNumber.get(right) == n)
					answer++;
				sum -= primeNumber.get(left++);
			}
		}
		System.out.println(answer);
	}
}
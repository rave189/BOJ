package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * �ڿ��� N�� ���ӵ� �Ҽ��� ������ ��Ÿ���� ����� ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * N������ �Ҽ��� �����佺�׳׽��� ü�� ��� ���Ѵ�.
	 * ���ӵ� �Ҽ��̹Ƿ� �� �����͸� �̿��Ͽ� N�� �Ǵ� ����� ���� ��� ã�´�.
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
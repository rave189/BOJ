package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * N장의 카드가 주어질 때, 가장 많이 가지고 있는 카드를 구하는 문제
 * 가장 많이 가지고 있는 카드가 여러 장이라면 그 중에 가장 작은 것을 출력한다.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Long, Integer> hash = new HashMap<>();
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		long maxNum = 0;
		for (int i = 0; i < n; i++) {
			long num = Long.parseLong(br.readLine());
			hash.compute(num, (e, v) -> hash.getOrDefault(e, 0) + 1);
		}
		for (long key : hash.keySet()) {
			int cnt = hash.get(key);
			if (cnt > max) {
				max = cnt;
				maxNum = key;
			} else if (cnt == max && key < maxNum)
				maxNum = key;
		}
		System.out.println(maxNum);
	}
}
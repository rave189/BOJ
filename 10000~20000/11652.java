package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * N���� ī�尡 �־��� ��, ���� ���� ������ �ִ� ī�带 ���ϴ� ����
 * ���� ���� ������ �ִ� ī�尡 ���� ���̶�� �� �߿� ���� ���� ���� ����Ѵ�.
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
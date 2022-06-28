package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * �θ����� 1, 5, 10, 50�� N�� ����Ͽ� ���� �� �ִ� ���� ������ ���ϴ� ����
 * ������ ������ �ٲپ ���� ���� ����Ѵ�. (ex. 9 == 11)
 * @author Rave
 *
 */
public class Main {

	static int[] arr = { 1, 5, 10, 50 };
	static HashSet<Integer> hash = new HashSet<>();

	/**
	 * �ʹ� ��ư� ������ �� ����
	 * �з� ���� Ǯ��
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		backTracking(n, 0, -1);
		System.out.println(hash.size());
	}

	public static void backTracking(int depth, int sum, int prev) {
		if (depth == 0) {
			hash.add(sum);
			return;
		}
		for (int v : arr)
			if (v >= prev)
				backTracking(depth - 1, sum + v, v);
	}
}
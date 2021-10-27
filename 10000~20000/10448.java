package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 1, 3, 6, 10 ...의 삼각수가 있다.
 * 이 중 3개의 삼각수를 더하여 자연수 K를 만들수 있는지 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[] triangles = new int[45];
	static HashSet<Integer> hash = new HashSet<>();

	/**
	 * 2개의 삼각수를 선택하고 K - (2개의 삼각수의 합)인 삼각수가 존재하는지 확인한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		for (int i = 1, count = 1; i < triangles.length; i++, count++) {
			triangles[i] = triangles[i - 1] + count;
			hash.add(triangles[i]);
		}
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			int k = Integer.parseInt(br.readLine());
			answer.append(isValid(k) ? 1 : 0).append('\n');
		}
		System.out.println(answer);
	}

	public static boolean isValid(int k) {
		for (int i = 1; i < triangles.length; i++) {
			for (int j = 1; j < triangles.length; j++) {
				int sum = triangles[i] + triangles[j];
				if (sum >= k)
					break;
				else if (hash.contains(k - sum))
					return true;
			}
		}
		return false;
	}
}
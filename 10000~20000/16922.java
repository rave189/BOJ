package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 로마숫자 1, 5, 10, 50을 N개 사용하여 만들 수 있는 수의 개수를 구하는 문제
 * 숫자의 순서를 바꾸어도 같은 수로 계산한다. (ex. 9 == 11)
 * @author Rave
 *
 */
public class Main {

	static int[] arr = { 1, 5, 10, 50 };
	static HashSet<Integer> hash = new HashSet<>();

	/**
	 * 너무 어렵게 생각한 것 같음
	 * 분류 보고 풀음
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
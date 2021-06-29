package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 배열과 +, -, *, / 연산자의 개수가 주어진다.
 * 연산자의 개수는 합이 N-1보다 크거나 같고 4N보단 작거나 같다.
 * 이 때, 연산자의 우선순위를 무시하고 앞에서부터 계산을 수행할 때
 * 식의 결과의 최댓값과 최솟값을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[] arr;
	static int[] op;
	// 수의 범위가 -10억 ~ 10억 이므로 MIN_VALUE와 MAX_VALUE로 초기화 한다.
	static int maxAns = Integer.MIN_VALUE;
	static int minAns = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		op = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < op.length; i++)
			op[i] = Integer.parseInt(st.nextToken());
		// 첫 수를 주고 시작한다.
		BruteForce(1, arr[0]);
		System.out.println(maxAns + "\n" + minAns);
	}

	/**
	 * 브루트 포스를 사용하여 모든 경우를 시도해본다.
	 * @param cur 계산에 들어갈 수
	 * @param result 현재까지의 계산 결과
	 */
	public static void BruteForce(int cur, int result) {
		if (cur == arr.length) {
			maxAns = Math.max(maxAns, result);
			minAns = Math.min(minAns, result);
			return;
		}
		// 식은 항상 순서대로 이루어져야 하므로 연산자만 고르면 된다.
		for (int i = 0; i < op.length; i++) {
			if (op[i] == 0)
				continue;
			op[i]--;
			BruteForce(cur + 1, Calculate(result, cur, i));
			op[i]++;
		}
	}

	/**
	 * 연산자에 맞게 식을 계산한다.
	 * @param result 현재까지의 계산 결과
	 * @param idx 연산을 수행할 정수
	 * @param op 연산자
	 * @return 연산자에 맞는 계산 결과
	 */
	public static int Calculate(int result, int idx, int op) {
		switch (op) {
		case 0:
			return result + arr[idx];
		case 1:
			return result - arr[idx];
		case 2:
			return result * arr[idx];
		default:
			return result / arr[idx];
		}
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 양의 정수 n의 각 자리수의 제곱의 합을 계산한다.
 * 위와 같은 과정을 반복했을 때 1이 나오는 수를 상근수라고 한다.
 * 이때 소수이면서 상근수인 수를 모두 찾는 문제
 * @author Rave
 *
 */
public class Main {

	static int[] visited = new int[1000001];

	/**
	 * n부터 시작하여 7까지 역순으로 탐색하며 소수이면서 상근수인 경우를 찾는다.
	 * n부터 시작해서 소수상근수인 수와 아닌 수를 탐색한다.
	 * 탐색한 결과는 visited에 저장되고 탐색이 끝난 수를 찾게되면 결과를 바로 알 수 있다.
	 * (정순보다 역순이 더 빠르네..?)
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = n; i >= 7; i--) {
			if (isPrime(i) && isValidNumber(i) == 1)
				arr.add(i);
		}
		for (int i = arr.size() - 1; i >= 0; i--)
			answer.append(arr.get(i)).append('\n');
		System.out.println(answer);
	}

	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i * i <= n; i++)
			if (n % i == 0)
				return false;
		return true;
	}

	/**
	 * @param n 양의 정수
	 * @return 소수상근수이면 1 아니면 -1
	 */
	public static int isValidNumber(int n) {
		if (n == 1)
			return 1;
		else if (visited[n] == -1)
			return -1;
		else if (visited[n] == 1)
			return 1;
		// 기본은 소수상근수가 아닌걸로 세팅
		visited[n] = -1;
		int next = 0;
		String number = Integer.toString(n);
		for (char ch : number.toCharArray())
			next += Math.pow(ch - '0', 2);
		return visited[n] = isValidNumber(next);
	}
}
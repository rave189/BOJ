package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1부터 N까지의 수열이 있다.
 * 여기에 +, -, ' '을 숫자 사이에 삽입하여 만든 식이 0이 되도록 하려고 한다.
 * 공백은 두 수를 이어 붙인다는 뜻이다.
 * N이 주어졌을 때 0이 될 수 있는 수식을 모두 찾는 문제
 * @author Rave
 *
 */
public class Main {

	static StringBuilder answer = new StringBuilder();
	static int n;

	/**
	 * 브루트포스로 모든 경우의 수를 탐색하여 찾는다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			n = Integer.parseInt(br.readLine());
			findAll("1", 2);
			answer.append("\n");
		}
		System.out.print(answer);
	}

	public static void findAll(String result, int cur) {
		if (cur > n) {
			if (calc(result) == 0)
				answer.append(result).append("\n");
			return;
		}
		findAll(result + " " + cur, cur + 1);
		findAll(result + "+" + cur, cur + 1);
		findAll(result + "-" + cur, cur + 1);
	}

	public static int calc(String result) {
		result = result.replaceAll(" ", "");
		Queue<Integer> arr = new LinkedList<>();
		Queue<Character> op = new LinkedList<>();
		for (int i = 0; i < result.length(); i++) {
			char ch = result.charAt(i);
			if (ch == '+' || ch == '-') {
				op.add(ch);
				arr.add(Integer.parseInt(result.substring(0, i)));
				result = result.substring(i + 1);
				i = -1;
			}
		}
		arr.add(Integer.parseInt(result));

		int sum = arr.poll();
		while (!op.isEmpty()) {
			char operator = op.poll();
			int right = arr.poll();
			if (operator == '+')
				sum += right;
			else
				sum -= right;
		}

		return sum;
	}
}
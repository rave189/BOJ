package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 3개의 칵테일이 주어질 때, 가장 맛있는 칵테일을 만드는 문제
 * 칵테일은 각각 고유 번호가 주어지고, 칵테일을 섞으면 고유 번호의 곱이 된다.
 * 칵테일은 무조건 홀수인 칵테일이 가장 맛있다.
 * 또한, 똑같이 홀수이거나 짝수인 칵테일 중에서는 맛이 더 큰 칵테일을 더 맛있다고 느낀다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * 일단 홀수가 있으면 무조건 홀수를 곱한게 더 맛있다.
	 * 짝수만 있다면 수가 큰 칵테일이 맛있으므로 전부다 곱한게 제일 맛있다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 1, evenAnswer = 1;
		boolean isOdd = false;
		for (int i = 0; i < 3; i++) {
			int v = Integer.parseInt(st.nextToken());
			if (v % 2 != 0) {
				isOdd = true;
				answer *= v;
			}
			evenAnswer *= v;
		}
		System.out.println(isOdd ? answer : evenAnswer);
	}
}
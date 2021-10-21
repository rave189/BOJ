package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 알파벳 대문자가 입력으로 주어진다.
 * 각 문자를 획수로 변환한다.
 * 이후 두 개씩 짝을 지어 더해준다. 만약 하나가 남는다면 그대로 다음 단계로 진행한다.
 * 다음 단계는 이전 단계와 마찬가지로 두 개씩 짝을 지어 더해주는 작업을 반복한다.
 * 만약 더한 값이 10을 넘어가면 10으로 나눈 나머지로 바꾸어준다.
 * 최종적으로 더한 값이 홀수이면 I'm a winner!를 아니라면 You're the winner?를 출력하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[] alphabet = { 3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1 };

	/**
	 * 결국 마지막까지 더해야 하는 문제이므로 짝을 지어 더하지 않고 전부 더한 값이 홀수인지 아닌지만 비교한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int answer = 0;
		for (char ch : input.toCharArray())
			answer += alphabet[ch - 'A'];
		System.out.println(answer % 2 == 1 ? "I'm a winner!" : "You're the winner?");
	}
}
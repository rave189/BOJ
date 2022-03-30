package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * N자리 이진수 K가 있다.
 * K = K-(K&(~K)+1))을 적용하여 K가 0이 되도록 하려고 한다.
 * 연산의 몇 번 수행하는지를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 식 자체가 맨 마지막 1을 빼주는 식이다.
	 * 따라서 1의 개수를 세어 해결할 수 있다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int answer = 0;
		for (char ch : input.toCharArray())
			if (ch == '1')
				answer++;
		System.out.println(answer);
	}
}
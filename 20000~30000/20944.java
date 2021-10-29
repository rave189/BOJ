package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 팰린드롬은 뒤집어도 똑같은 문자열을 뜻한다.
 * 수미상관은 앞쪽 절반과 뒤쪽 절반이 같은 문자열을 뜻한다.
 * 팰린드롬이면서 수미상관인 문자열을 아무거나 출력하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 같은 문자만 출력하면 팰린드롬이면서 수미상관이 된다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < n; i++)
			answer.append('a');
		System.out.println(answer);
	}
}
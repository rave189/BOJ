package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 알파벳으로 이루어진 문자열이 주어진다.
 * 소문자는 대문자로, 대문자는 소문자로 바꾸어 출력하는 문제
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuilder answer = new StringBuilder();
		for (char ch : input.toCharArray())
			answer.append(ch <= 90 ? (char) (ch + 32) : (char) (ch - 32));
		System.out.println(answer);
	}
}
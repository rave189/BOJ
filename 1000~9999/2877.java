package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 창영이는 4와 7로 이루어진 수를 좋아한다.
 * 창영이가 좋아하는 수 중에서 K번째 작은 수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 이 문제는 이진수를 4와 7로 표현하는 문제이다.
	 * K번째 수를 구하기 위해서는 K+1의 이진수를 구하고 첫 번째 자리를 지워주어 구할 수 있다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer answer = new StringBuffer();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()) + 1;
		// reverse까지 2진수를 구하는 과정이다.
		while (n > 0) {
			sb.append((n % 2));
			n /= 2;
		}
		sb = sb.reverse();
		sb.deleteCharAt(0);
		for (int i = 0; i < sb.length(); i++)
			answer.append(sb.charAt(i) == '1' ? "7" : "4");
		System.out.println(answer);
	}
}
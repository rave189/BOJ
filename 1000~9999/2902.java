package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 사람이름-사람이름-사람이름.... 과같은 형식이 주어진다.
 * 사람 이름의 첫 글자만 출력하는 문제
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringBuilder answer = new StringBuilder(line.charAt(0) + "");
		for (int i = 0; i < line.length(); i++)
			if (line.charAt(i) == '-')
				answer.append(line.charAt(i + 1));
		System.out.println(answer);
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 어느 사이트에 회원가입으로 하려고 한다.
 * 아이디를 입력했지만 이미 있는 아이디라고 나와 놀람을 표현하려고 한다.
 * 아이디 뒤에 ??!를 붙이는 문제
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(br.readLine() + "??!");
	}
}
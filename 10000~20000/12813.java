package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 10만개의 비트로 이루어진 두 이진수 A, B가 주어진다.
 * 이 두 이진수의 A & B, A | B, A ^ B, ~A, ~B를 구하는 문제
 * 비트수가 10만이기 때문에 파싱을 하지 않고 String 상태에서 연산을 수행한다.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		System.out.println(andOperator(a, b));
		System.out.println(orOperator(a, b));
		System.out.println(xorOperator(a, b));
		System.out.println(notOperator(a));
		System.out.println(notOperator(b));
	}

	public static String andOperator(String a, String b) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length(); i++) {
			char chA = a.charAt(i);
			char chB = b.charAt(i);
			if (chA == '1' && chB == '1')
				sb.append(1);
			else
				sb.append(0);
		}
		return sb.toString();
	}

	public static String orOperator(String a, String b) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length(); i++) {
			char chA = a.charAt(i);
			char chB = b.charAt(i);
			if (chA == '0' && chB == '0')
				sb.append(0);
			else
				sb.append(1);
		}
		return sb.toString();
	}

	public static String xorOperator(String a, String b) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length(); i++) {
			char chA = a.charAt(i);
			char chB = b.charAt(i);
			if ((chA == '1' && chB == '0') || (chA == '0' && chB == '1'))
				sb.append(1);
			else
				sb.append(0);
		}
		return sb.toString();
	}

	public static String notOperator(String s) {
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (ch == '1')
				sb.append(0);
			else
				sb.append(1);
		}
		return sb.toString();
	}
}
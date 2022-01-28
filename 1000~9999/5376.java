package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 소수를 기약분수로 바꾸는 문제
 * 출력은 분자/분모로 출력한다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * 순환소수의 자릿수는 9를 순환소수가 아닌 부분에는 0을 채워 분모를 구한다.
	 * 내가 짜니까 안됨
	 * 문제 개 더러웡...
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			String num = br.readLine();
			int idx = 2;
			long numerator = 0;
			// 비순환소수 구하기
			for (; idx < num.length(); idx++) {
				if (num.charAt(idx) == '(')
					break;
				numerator = numerator * 10 + (num.charAt(idx) - '0');
			}
			int noCircleLength = idx - 2;
			int circleLength = 0;
			// 전체에서 순환소수의 개수를 구한다. 
			long noCircle = numerator;
			for (; idx < num.length(); idx++) {
				if (num.charAt(idx) == '(' || num.charAt(idx) == ')')
					continue;
				numerator = numerator * 10 + (num.charAt(idx) - '0');
				circleLength++;
			}
			// 순환소수가 있으면 전체에서 순환소수 부분을 빼준다.
			if (numerator != noCircle)
				numerator -= noCircle;
			long denominator = 0;
			// 순환소수 자리만큼 9 채우기
			while (circleLength-- > 0)
				denominator = denominator * 10 + 9;
			// 순환소수가 없으면 1로 다시 초기화 해주기
			if (denominator == 0)
				denominator = 1;
			// 비순환소수 자리만큼 0 채우기
			while (noCircleLength-- > 0)
				denominator = denominator * 10;
			long gcd = gcd(numerator, denominator);
			answer.append(String.format("%d/%d", numerator / gcd, denominator / gcd)).append('\n');
		}
		System.out.print(answer);
	}

	public static long gcd(long a, long b) {
		while (a % b > 0) {
			long r = a % b;
			a = b;
			b = r;
		}
		return b;
	}
}
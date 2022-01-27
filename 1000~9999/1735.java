package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 두 분수가 주어진다.
 * 두 분수의 합을 기약분수로 출력하는 문제
 * 입력은 분자 분모 순으로 주어진다.
 * 
 * @author Rave
 *
 */
public class Main {

	/**
	 * 두 분수를 약분 없이 단순 통분한다.
	 * 분자와 분모의 최대 공약수를 구하고 최대 공약수로 나눈 수를 출력한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int y1 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		int r2 = x2 * y2;
		int r1 = x1 * y2 + y1 * x2;
		int gcd = gcd(r1, r2);
		System.out.printf("%d %d", r1 / gcd, r2 / gcd);
	}

	public static int gcd(int a, int b) {
		while (a % b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return b;
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가로 x, 세로 y 길이의 타일이 있다.
 * 이 타일에 대각선을 그었을 때, 대각선이 그어진 1x1타일이 몇 개인지 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 대각선 구하는 공식 구하다가 의미없는 짓인거같아서 그냥 답 봄
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int gcd = gcd(x, y);
		System.out.println(x + y - gcd);
	}

	public static int gcd(int a, int b) {
		while (b > 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
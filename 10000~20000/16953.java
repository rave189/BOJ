package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 정수 A에 2를 곱하거나 오른쪽에 1을 추가하여 B를 만들려고한다.
 * 이때, A를 B로 바꾸는데 필요한 연산의 최솟값 + 1을 구하는 문제 B로 바꿀 수 없다면 -1을 출력한다.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		Search(a, b, 1);
		System.out.println(-1);
	}

	/**
	 * 가지치기 방식으로 B가 될 수 있는지 구하는 문제
	 * @param a   정수 A
	 * @param b   정수 B
	 * @param cnt 연산의 횟수
	 */
	public static void Search(long a, int b, int cnt) {
		if (a == b) {
			System.out.println(cnt);
			System.exit(0);
		} else if (a > b)
			return;
		Search(a * 2, b, cnt + 1);
		Search(Long.parseLong(Long.toString(a) + "1"), b, cnt + 1);
	}
}
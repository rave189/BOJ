package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 두 학생이 같은 방향으로 멀리뛰기를 한다.
 * A 학생은 한 번에 X 미터를, B 학생은 Y 미터를 뛴다.
 * 두 학생의 시작 지점과 X, Y가 주어졌을 때
 * 두 학생이 공통으로 만나게 되는 지점 중 가장 가까운 지점을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 두 학생이 같은 지점을 밟을 때까지 뒤처진 학생을 멀리뛰기 시킨다.
	 * 최소 100번 안에는 만나야 하므로 100번까지만 돌려본다. (이 100번이란 숫자를 알아야 빨리 해결되넹.. 모르면 걍 돌려볼 수 밖에)
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		long p1 = Integer.parseInt(st.nextToken());
		long p2 = Integer.parseInt(st.nextToken());
		int cnt = 100;
		while (cnt-- > 0) {
			if (p1 == p2)
				break;
			if (p1 < p2)
				p1 += x;
			else
				p2 += y;
		}
		System.out.println(p1 == p2 ? p1 : -1);
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 물감 N개의 RGB값이 주어진다.
 * 이 물감들을 혼합할 수 있는데 다음과 같이 섞을 수 있다.
 * (R1 + R2 .. Rn)/n, (G1 + G2 .. Gn)/n, (B1 + B2 .. Bn)/n
 * 섞은 물감의 RGB를 전부 더한 후 개수로 나누어줄 수 있다.
 * 이 물감들로 곰두리 색을 만들려고 한다.
 * 곰두리 색과 차이가 가장 작은 색을 문두리 색이라고 할 때
 * 곰두리 색과 문두리 색의 차이를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static RGB[] rgbs;
	static RGB gomduri;
	static int answer = Integer.MAX_VALUE;

	/**
	 * 브루트포스와 백트래킹을 사용하여 물감의 조합을 모두 시도해본다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		rgbs = new RGB[n];
		for (int i = 0; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (i == n)
				gomduri = new RGB(r, g, b);
			else
				rgbs[i] = new RGB(r, g, b);
		}
		backTracking(0, 0, 0, 0, 0);
		System.out.println(answer);
	}

	public static void backTracking(int cur, int cnt, int r, int g, int b) {
		if (cur >= rgbs.length) {
			if (cnt < 2 || cnt > 7)
				return;
			int result = Math.abs(gomduri.r - r / cnt) + Math.abs(gomduri.g - g / cnt) + Math.abs(gomduri.b - b / cnt);
			answer = Math.min(answer, result);
			return;
		}

		// n의 최댓값이 30이기 때문에 무작정 들어가면 시간 초과가 난다.
		// 선택한 물감이 7개 미만일 때만 들어가도록 한다.
		if (cnt < 7)
			backTracking(cur + 1, cnt + 1, r + rgbs[cur].r, g + rgbs[cur].g, b + rgbs[cur].b);
		backTracking(cur + 1, cnt, r, g, b);
	}
}

class RGB {
	int r, g, b;

	public RGB(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
}
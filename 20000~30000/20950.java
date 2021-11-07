package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ���� N���� RGB���� �־�����.
 * �� �������� ȥ���� �� �ִµ� ������ ���� ���� �� �ִ�.
 * (R1 + R2 .. Rn)/n, (G1 + G2 .. Gn)/n, (B1 + B2 .. Bn)/n
 * ���� ������ RGB�� ���� ���� �� ������ �������� �� �ִ�.
 * �� ������� ���θ� ���� ������� �Ѵ�.
 * ���θ� ���� ���̰� ���� ���� ���� ���θ� ���̶�� �� ��
 * ���θ� ���� ���θ� ���� ���̸� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static RGB[] rgbs;
	static RGB gomduri;
	static int answer = Integer.MAX_VALUE;

	/**
	 * ���Ʈ������ ��Ʈ��ŷ�� ����Ͽ� ������ ������ ��� �õ��غ���.
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

		// n�� �ִ��� 30�̱� ������ ������ ���� �ð� �ʰ��� ����.
		// ������ ������ 7�� �̸��� ���� ������ �Ѵ�.
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
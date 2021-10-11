package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �����̴� ���� PC�濡 ����.
 * �ֱ� ����� �Ϻ� ������ ħ���Ǿ� ħ���� �������� �̵��� �Ұ����ϴ�.
 * �����̴� ��, ��, ��, ��� �̵��ϸ�, �� �� �̵��� �� �̵� �Ÿ��� 1�̴�.
 * ���� ���� PC�濡 �����ϹǷ� �ִܰŸ��� �����δ�.
 * �������� �� ��ǥ (H, H), PC���� ��ǥ (N, N)�� �־��� ��
 * �����̰� PC�濡 �� �� �ִ� ����� ���� ���ϴ� ����
 * ��ǥ��� �� (x, y)���� (y > x)�� ���� ��� ħ���Ǿ��ٰ� �Ѵ�.
 * ���� PC���� ��ǥ�� ���� ��� 1���� ��찡 �ִٰ� �Ѵ�.
 * @author Rave
 *
 */
public class Main {

	/**
	 * h�� n�� ��� ��ǥ�� ū�� �������� start�� end�� �����صд�. (�׻� ������ �Ʒ� �������θ� Ž���ϱ� ���ؼ�)
	 * ���� (start, start-1)�� 1�� ���� �� Ž���� �����ϵ��� �Ѵ�.
	 * Ž���� ��ȭ�� dp[i][j] = dp[i-1][j] + dp[i][j-1]�� ����Ͽ� Ž���Ѵ�.
	 * ����� ���� int�� ��� �� �����Ƿ� long���� map�� �����Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken()) + 1;
		int n = Integer.parseInt(st.nextToken()) + 1;
		long[][] map = new long[32][32];
		int start = Math.min(h, n);
		int end = Math.max(h, n);
		map[start][start - 1] = 1;
		for (int i = start; i <= end; i++) {
			for (int j = start; j <= end; j++) {
				if (j > i)
					break;
				map[i][j] = map[i - 1][j] + map[i][j - 1];
			}
		}
		System.out.println(map[end][end]);
	}
}
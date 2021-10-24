package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ��ٸ� ������ �����Ͽ� i�� ���μ��� ����� i������ ������ �Ϸ��� �Ѵ�.
 * �̷��� �ϱ� ���� �߰��ؾ� �ϴ� ���μ��� �ּ� ������ ���ϴ� ����
 * ��, ���μ��� �����ϰų� ���ӵ��� �ʾƾ� �Ѵ�.
 * ���� �߰��ؾ��ϴ� ���μ��� ������ 3�� �Ѱų� �Ұ����ϴٸ� -1�� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	static boolean[][] ladder;
	static int answer = Integer.MAX_VALUE;

	/**
	 * ���� ���� �ذ� ����� �����Ѵ�.
	 * ���Ʈ������ ���� ���μ��� �߰��ذ��� ������ �� �ִ��� Ȯ���غ���.
	 * ��ٸ��� ���� �� 1���� ���� �ȵȴٸ� 2��, 3���� ���ƺ��� ����̴�.
	 * ���� ���ʿ� 1���� ����, �߰��� 1�� �Ǵ� 2���� �� ���Ƽ� ������ Ǯ���ٸ� �� ���� �����Ѵ�.
	 * ������ �Ʒ��ʿ� 1���� ���� ������ ������ �ٷ� �ذ�� ���� �ִ�.
	 * �׷��� Ž���� ������ �� �������� ���� �ּڰ��� ����ϵ��� ������.
	 * �� �κ��� �����ϸ� �ð��� ���� ���������..?
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		ladder = new boolean[h][n + 1];
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken());
			ladder[a][b] = true;
		}
		bruteforce(0, 0);
		System.out.println(0 <= answer && answer <= 3 ? answer : -1);
	}

	public static void bruteforce(int lineCnt, int start) {
		if (isValid()) {
			answer = Math.min(answer, lineCnt);
			return;
		} else if (lineCnt >= 3)
			return;

		for (int i = start; i < ladder.length; i++) {
			for (int j = 1; j < ladder[0].length - 1; j++) {
				if (ladder[i][j] || ladder[i][j - 1] || ladder[i][j + 1])
					continue;
				ladder[i][j] = true;
				bruteforce(lineCnt + 1, start);
				ladder[i][j] = false;
			}
		}
	}

	public static boolean isValid() {
		for (int i = 1; i < ladder[0].length; i++)
			if (!down(i))
				return false;
		return true;
	}

	public static boolean down(int n) {
		int cur = n;
		for (int i = 0; i < ladder.length; i++) {
			if (ladder[i][cur - 1])
				cur--;
			else if (ladder[i][cur])
				cur++;
		}
		return cur == n;
	}
}
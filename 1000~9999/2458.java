package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N���� �л��� �ִ�.
 * �� �� �� ���� �л��� Ű�� ���ϴ� �ൿ�� M�� �ߴ�.
 * Ű �� ������ ������ �ڽ��� Ű�� �� ��°���� ��Ȯ�� �� �� �ִ� �л��� ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * �÷��̵� �ͼ��� Ǫ�� ����
	 * �켱 ���� ������ ��� ���� �÷��̵� �ͼ��� üũ�صд�.
	 * ���� i���� j�� �� �� �ִٸ� j���� i�ε� �� �� �ִٴ� üũ�� �Ѵ�.
	 * �׷��� �ڱ� �ڽ��� ������ ��� ��尡 true�� ������ �ִ�.
	 * �� ������ ������ �ڽ��� Ű�� ��Ȯ�� �� �� �ִ� �л��� ���̴�.
	 * 
	 * ó���� ���� ������ �� �˾Ҵµ�, �з����� �÷��̵� �ͼ��ΰ� �˰Ե�
	 * ���������δ� �� �������� �� �� ������ ��Ȯ�� ������ ����
	 * �÷��̵� �ͼ��� ��� ���鼭 �����غ��ϱ� i���� j���°� true�̸� j���� i�� true�� �ٲ��ָ�
	 * �ڱ� �ڽ� ���� �� true�� ���� �� ���Ƽ� �غôµ� ����
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[][] compare = new boolean[n + 1][n + 1];
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			compare[first][second] = true;
		}
		for (int k = 1; k <= n; k++)
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++)
					if (compare[i][k] && compare[k][j])
						compare[i][j] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				compare[i][j] = compare[i][j] || compare[j][i];
				compare[j][i] = compare[i][j] || compare[j][i];
			}
		}
		int answer = 0;
		loop: for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				if (!compare[i][j])
					continue loop;
			}
			answer++;
		}
		System.out.println(answer);
	}
}
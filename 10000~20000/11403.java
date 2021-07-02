package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ����ġ ���� ���� �׷��� G�� �־�����.
 * ��� ���� (i, j)�� ���ؼ� i���� j�� ���� ���� �����ϴ��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int[][] map;

	/**
	 * �÷��̵� �ͼ� �˰����� ����Ͽ� i���� m�� ���� j�� ���� ����� �ִ��� Ž���Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		Solve();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				sb.append(map[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	/**
	 * �÷��̵� �ͼ� �˰������� ��� ������ ���� i���� j�� �� �� �ִ��� ���ϴ� �޼ҵ�
	 * �׻� �߰� ���� m�� ù for������ ���;� �ϰ�
	 * ���� ���� ������ i, j ������ ���;� �Ѵ�.
	 */
	public static void Solve() {
		// �߰� ���� m
		for (int m = 0; m < map.length; m++)
			// (i, j)
			for (int i = 0; i < map.length; i++)
				for (int j = 0; j < map.length; j++)
					// i���� m���� �� �� �ְ�, m���� j�� �� �� �ִٸ� i���� j�� �� �� �ִ�.
					if (map[i][m] == 1 && map[m][j] == 1)
						map[i][j] = 1;
	}
}
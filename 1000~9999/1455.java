package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N*M�� ���簢���� ������ N*M�� �����ִ�.
 * ������ �ո��� 0�̶�� �ϰ�, �޸��� 1�̶�� �Ѵ�.
 * �����̴� ������ ��� �ո����� �ٲٷ��� �Ѵ�.
 * �̶�, (x, y)ĭ�� ������ �������� (i, j)(1 <= i <= a, 1 <= j <= b)�� ������ �����ϴ� x*y���� ������ ��� ��������.
 * ������� �ϴ� ������ ������ ���ϴ� ����
 * (x, y)�� �������ٸ� ������ Ƚ���� x*y�� �ƴ϶� 1�̴�.
 * @author Rave
 *
 */
public class Main {

	static int[][] map;

	/**
	 * (x, y) ������ ��� ������ �������Ƿ� (N, M)���� (1, 1)���� �������� ������ ���� ��������
	 * ��� ������ �ո����� �ٲ� �� �ִ�. 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++)
				map[i][j] = input.charAt(j) - '0';
		}
		int answer = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				if (map[i][j] == 1) {
					changeMap(i, j);
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

	public static void changeMap(int x, int y) {
		for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				if (map[i][j] == 0)
					map[i][j] = 1;
				else
					map[i][j] = 0;
			}
		}
	}
}
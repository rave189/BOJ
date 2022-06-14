package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ������ N���� �ִ�.
 * �� �������� �����ϴ� ���ο� ����� �־�����.
 * �̶� �� �����忡�� �ٸ� ���������� �ִܰŸ��� ������ �Ѵ�.
 * �̶� ó�� �鷯���ϴ� �������� �׷����� ����ϴ� ����
 * graph[i][i]���� -�� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	static final int MAX = 1000000000;

	/**
	 * �÷��̵�ͼ��� Ǫ�� ����
	 * result[i][j] = k�� �ߴٰ� Ʋ����.
	 * �׷��� result[i][k]�� i���� k�ΰ��� ���� ��ȴ� ���� �־��ִ� ������� �ٲ�.
	 * �߰��� �׽�Ʈ�Ѵٰ� answer.append('\n')�� ����־ ���� �� �����µ� ��� Ʋ����.
	 * �������� 20������ �����ٰ� �� �ڵ� ã��.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n + 1][n + 1];
		int[][] result = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++)
			Arrays.fill(map[i], MAX);
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[first][second] = map[second][first] = cost;
			result[first][second] = second;
			result[second][first] = first;
		}
		for (int k = 1; k <= n; k++)
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++)
					if (map[i][k] + map[k][j] < map[i][j]) {
						map[i][j] = map[i][k] + map[k][j];
						result[i][j] = result[i][k];
					}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++)
				answer.append(i == j ? "-" : result[i][j]).append(' ');
			answer.append('\n');
		}
		System.out.print(answer);
	}
}
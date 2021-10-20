package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 4-4-2 ���̾Ƹ�� ������ �౸�������� �����Ϸ��� �Ѵ�.
 * �� �������� ������ �����ǿ��� �ɷ�ġ�� ������ �־�����.
 * �������� ��� �� �����ǿ� ��ġ���� ���� �ɷ�ġ�� �ִ��� ���ϴ� ����
 * �ɷ�ġ�� 0�� ��� �ش� �����ǿ� ���� �ʴ� �����̹Ƿ� ��ġ�� �� ����.
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static boolean[] visited;
	static int answer;

	/**
	 * ���Ʈ������ Ž���� �ϸ� ������ �������� ��� �����ǿ� ��ġ�غ���.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			map = new int[11][11];
			visited = new boolean[11];
			answer = 0;
			for (int i = 0; i < map.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[0].length; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			BruteForce(0, 0);
			sb.append(answer).append('\n');
		}
		System.out.println(sb);
	}

	public static void BruteForce(int cur, int sum) {
		if (cur >= map.length) {
			answer = Math.max(answer, sum);
			return;
		}
		for (int i = 0; i < map.length; i++) {
			if (visited[i] || map[i][cur] == 0)
				continue;
			visited[i] = true;
			BruteForce(cur + 1, sum + map[i][cur]);
			visited[i] = false;
		}
	}
}
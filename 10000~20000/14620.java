package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �ĸ��Ͽ� NxN ���� ����� ȭ�ܿ� ���� �������� �Ѵ�.
 * ���� �ǰԵǸ� ��, ��, ��, ��, �߾��� ��� �����Ѵ�.
 * ����, ���� ���� ��ġ�� �Ǹ� �� �� ��� �״´�.
 * ȭ���� ������ ����Ʈ���� �뿩�ᰡ �ٸ���.
 * ȭ�ܿ� 3���� ������ �ɾ� ���� �ǿ���� �� ��, ȭ�� �뿩���� �ּڰ��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static int answer = Integer.MAX_VALUE;
	static boolean[][] visited;

	/**
	 * ���Ʈ������ �̿��Ͽ� 3���� ���� ���� �ɾ��.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		bruteforce(0, 3, 0);
		System.out.println(answer);
	}

	public static void bruteforce(int next, int remainSeedCnt, int result) {
		if (remainSeedCnt == 0) {
			answer = Math.min(answer, result);
			return;
		}

		for (int i = next; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				try {
					if (visited[i][j] || visited[i - 1][j] || visited[i][j - 1] || visited[i + 1][j] || visited[i][j + 1])
						continue;
					int sum = map[i][j] + map[i - 1][j] + map[i + 1][j] + map[i][j - 1] + map[i][j + 1];
					visited[i][j] = visited[i - 1][j] = visited[i + 1][j] = visited[i][j - 1] = visited[i][j + 1] = true;
					bruteforce(i, remainSeedCnt - 1, result + sum);
					visited[i][j] = visited[i - 1][j] = visited[i + 1][j] = visited[i][j - 1] = visited[i][j + 1] = false;
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		}
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ���忡 1~9 ������ ���� �Ǵ� H�� �����ִ�.
 * H�� �������� ������ ������ ����ȴ�.
 * ���带 ����� ������ ����ȴ�.
 * �� ����ȿ��� (0, 0)���� �����Ͽ� ��, ��, ��, ��� �ٴڿ� �����ִ� ���ڸ�ŭ �̵��� �� �ִ�.
 * ���� �ȿ��� �ִ� �� �� ������ �� �ִ��� ���ϴ� ����
 * ���� ������ ������ �� �ִٸ� -1�� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	static char[][] map;
	static boolean[][] visited;
	static int[][] dp;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	/**
	 * dfs�� dp�� ���� Ž���ϴ� ����
	 * dfs�� ���鼭 ����ģ ���� �ٽ� �� �� �ִٸ� ������ ������ ������ �� �����Ƿ� -1�� ����Ѵ�.
	 * �ƴ϶�� dfs�� ���鼭 ������ �� ���� �� ������ �� �ִ����� �����Ѵ�.
	 * 
	 * ����ϰ� § �� ������ �����ִ� 10�� Ʋ���� ������ �� ���� �³�
	 * ���� �ڵ尡 �� �� § �� �����ѵ� �ѹ濡 �����ϱ� ���� �㹫�ϳ�
	 * 10���̳� Ʋ�ȴµ�
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m];
		dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++)
				map[i][j] = line.charAt(j);
		}
		dfs(0, 0);
		System.out.println(dp[0][0]);
	}

	public static int dfs(int x, int y) {
		if (dp[x][y] > 0)
			return dp[x][y];
		visited[x][y] = true;
		int step = map[x][y] - '0';
		for (int i = 0; i < dx.length; i++) {
			int nextX = x + dx[i] * step;
			int nextY = y + dy[i] * step;
			try {
				if (visited[nextX][nextY]) {
					System.out.println(-1);
					System.exit(0);
				} else if (map[nextX][nextY] == 'H')
					continue;
				dp[x][y] = Math.max(dp[x][y], dfs(nextX, nextY));
			} catch (ArrayIndexOutOfBoundsException e) {
			}
		}
		visited[x][y] = false;
		// �⺻�� 0�����̰�, ���⿡�� ��򰡷� ������ �������� �״� +1 �ؼ� ��ȯ�Ѵ�. 
		return ++dp[x][y];
	}
}
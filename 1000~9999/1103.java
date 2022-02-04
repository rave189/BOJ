package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 보드에 1~9 사이의 숫자 또는 H가 쓰여있다.
 * H는 구멍으로 빠지면 게임이 종료된다.
 * 보드를 벗어나도 게임이 종료된다.
 * 이 보드안에서 (0, 0)에서 시작하여 상, 하, 좌, 우로 바닥에 쓰여있는 숫자만큼 이동할 수 있다.
 * 보드 안에서 최대 몇 번 움직일 수 있는지 구하는 문제
 * 만약 무한정 움직일 수 있다면 -1을 출력한다.
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
	 * dfs와 dp를 통해 탐색하는 문제
	 * dfs로 돌면서 지나친 길을 다시 갈 수 있다면 무조건 무한정 움직일 수 있으므로 -1을 출력한다.
	 * 아니라면 dfs를 돌면서 앞으로 몇 걸음 더 움직일 수 있는지를 저장한다.
	 * 
	 * 비슷하게 짠 거 같은데 저번주는 10번 틀리고 오늘은 한 번에 맞네
	 * 오늘 코드가 좀 잘 짠 거 같긴한데 한방에 맞으니까 뭔가 허무하네
	 * 10번이나 틀렸는데
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
		// 기본은 0걸음이고, 여기에서 어딘가로 무조건 움직였을 테니 +1 해서 반환한다. 
		return ++dp[x][y];
	}
}
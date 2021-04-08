import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int answer = Integer.MIN_VALUE;
	static int[] drtX = { 1, -1, 0, 0 };
	static int[] drtY = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		boolean[][] check = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		BruteForce(map, check, k, 0);
		System.out.println(answer);
	}

	public static void BruteForce(int[][] map, boolean[][] check, int k, int sum) {
		if (k == 0) {
			answer = Math.max(answer, sum);
			return;
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (!check[i][j] && FourPointCheck(check, i, j)) {
					check[i][j] = true;
					BruteForce(map, check, k - 1, sum + map[i][j]);
					check[i][j] = false;
				}
			}
		}
	}

	public static boolean FourPointCheck(boolean[][] check, int x, int y) {
		for (int t = 0; t < 4; t++) {
			try {
				int nextX = x + drtX[t];
				int nextY = y + drtY[t];
				if (check[nextX][nextY])
					return false;
			} catch (Exception e) {
			}
		}
		return true;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int answer = 1;
	static int[] drtX = { 1, -1, 0, 0 };
	static int[] drtY = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int height = Integer.parseInt(st.nextToken());
				map[i][j] = height;
				max = Math.max(max, height);
				min = Math.min(min, height);
			}
		}
		for (int rain = max - 1; rain >= min; rain--) {
			visited = new boolean[n][n];
			Search(rain);
		}
		System.out.println(answer);
	}

	public static void Search(int rainAmount) {
		int safeArea = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (visited[i][j] || map[i][j] <= rainAmount)
					continue;
				safeArea++;
				findArea(rainAmount, i, j);
			}
		}
		answer = Math.max(answer, safeArea);
	}

	public static void findArea(int rainAmount, int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nextX = x + drtX[i];
			int nextY = y + drtY[i];
			try {
				int check = map[nextX][nextY];
				if (!visited[nextX][nextY] && map[nextX][nextY] > rainAmount)
					findArea(rainAmount, nextX, nextY);
			} catch (Exception e) {
			}
		}
	}
}

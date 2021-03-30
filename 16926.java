import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0, j = 0; j < Math.min(n, m) / 2; i++, j++) {
			int rotate = r % (((n - 2 * i) * 2 + (m - 2 * j) * 2) - 4);
			for (int t = 0; t < rotate; t++)
				Rotation(i, j);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
	}

	public static void Rotation(int x, int y) {
		int savePoint = map[x][y];
		Top(x, y);
		Right(x, map[0].length - y - 1);
		Bottom(map.length - x - 1, y);
		Left(x, y);
		map[x + 1][y] = savePoint;
	}

	public static void Top(int x, int y) {
		for (int i = y; i < map[0].length - y - 1; i++)
			map[x][i] = map[x][i + 1];
	}

	public static void Right(int x, int y) {
		for (int i = x; i < map.length - x - 1; i++)
			map[i][y] = map[i + 1][y];
	}

	public static void Bottom(int x, int y) {
		for (int i = map[0].length - y - 1; i > y; i--)
			map[x][i] = map[x][i - 1];
	}

	public static void Left(int x, int y) {
		for (int i = map.length - x - 1; i > x + 1; i--)
			map[i][y] = map[i - 1][y];
	}
}

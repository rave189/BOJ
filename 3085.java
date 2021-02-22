import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] map = new char[n][n];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n - 1; j++)
				BruteForce(map, i, j);

		System.out.println(answer);
	}

	public static void BruteForce(char[][] map, int x, int y) {
		RowSearch(map, x);
		ColSearch(map, y);
		if (map[x][y] != map[x][y + 1]) {
			Swap(map, x, y, x, y + 1);
			RowSearch(map, x);
			ColSearch(map, y);
			ColSearch(map, y + 1);
			Swap(map, x, y, x, y + 1);
		}
		try {
			if (map[x][y] != map[x + 1][y]) {
				Swap(map, x, y, x + 1, y);
				RowSearch(map, x);
				RowSearch(map, x + 1);
				ColSearch(map, y);
				Swap(map, x, y, x + 1, y);
			}
		} catch (Exception e) {
		}
	}

	public static void RowSearch(char[][] map, int x) {
		int max = 1;
		char prev = map[x][0];
		int count = 1;
		for (int i = 1; i < map.length; i++)
			if (prev == map[x][i]) {
				count++;
				max = Math.max(max, count);
			} else {
				prev = map[x][i];
				count = 1;
			}
		answer = Math.max(max, answer);
	}

	public static void ColSearch(char[][] map, int y) {
		int max = 1;
		char prev = map[0][y];
		int count = 1;
		for (int i = 1; i < map.length; i++)
			if (prev == map[i][y]) {
				count++;
				max = Math.max(max, count);
			} else {
				prev = map[i][y];
				count = 1;
			}
		answer = Math.max(max, answer);
	}

	public static void Swap(char[][] map, int x1, int y1, int x2, int y2) {
		char ch = map[x1][y1];
		map[x1][y1] = map[x2][y2];
		map[x2][y2] = ch;
	}
}

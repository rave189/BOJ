import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		Point[][] tetromino = { { new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(0, 3) },
				{ new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(3, 0) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(2, 1) },
				{ new Point(0, 0), new Point(1, 0), new Point(0, 1), new Point(0, 2) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(-1, 2) },
				{ new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(2, -1) },
				{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(1, 2) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(2, 0) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(2, 0) },
				{ new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(1, 2) },
				{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, -1) },
				{ new Point(0, 0), new Point(0, 1), new Point(-1, 1), new Point(1, 0) },
				{ new Point(0, 0), new Point(0, -1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(-1, 1), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(-1, 1), new Point(0, 2) },
				{ new Point(0, 0), new Point(-1, 0), new Point(1, 0), new Point(0, 1) } };
		int answer = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				for (int t = 0; t < tetromino.length; t++) {
					Point[] tet = tetromino[t];
					int sum = 0;
					for (int k = 0; k < tet.length; k++) {
						Point cur = tet[k];
						if ((0 <= i + cur.x && i + cur.x < n) && (0 <= j + cur.y && j + cur.y < m))
							sum += map[i + cur.x][j + cur.y];
						else {
							sum = -1;
							break;
						}
					}
					answer = Math.max(answer, sum);
				}
		System.out.println(answer);
	}
}

class Point {
	int x;
	int y;

	public Point(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}
}

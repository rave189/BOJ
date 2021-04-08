import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int r;
	static int c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[][] map = new int[r][c];
		Queue<Dust> dust = new LinkedList<Dust>();
		Dust[] cleaner = new Dust[2];
		int cnt = 0;
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] >= 5)
					dust.add(new Dust(i, j, map[i][j]));
				else if (map[i][j] < 0)
					cleaner[cnt++] = new Dust(i, j, -1);
			}
		}
		int[] drtX = { 1, -1, 0, 0 };
		int[] drtY = { 0, 0, 1, -1 };
		for (int i = 0; i < t; i++) {
			while (!dust.isEmpty()) {
				Dust cur = dust.poll();
				for (int j = 0; j < 4; j++) {
					int nextX = cur.x + drtX[j];
					int nextY = cur.y + drtY[j];
					if ((0 <= nextX && nextX < r) && (0 <= nextY && nextY < c))
						if (map[nextX][nextY] >= 0) {
							int diffuse = cur.value / 5;
							map[nextX][nextY] += diffuse;
							map[cur.x][cur.y] -= diffuse;
						}
				}
			}
			StartTopClean(map, cleaner[0]);
			StartBottomClean(map, cleaner[1]);
			for (int a = 0; a < r; a++)
				for (int b = 0; b < c; b++)
					if (map[a][b] >= 5)
						dust.add(new Dust(a, b, map[a][b]));
		}
		int answer = 0;
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				if (map[i][j] > 0)
					answer += map[i][j];
		System.out.println(answer);
	}

	public static void StartTopClean(int[][] map, Dust cleaner) {
		for (int i = cleaner.x - 1; i > 0; i--)
			map[i][0] = map[i - 1][0];
		for (int i = 0; i < c - 1; i++)
			map[0][i] = map[0][i + 1];
		for (int i = 0; i < cleaner.x; i++)
			map[i][c - 1] = map[i + 1][c - 1];
		for (int i = c - 1; i > 1; i--)
			map[cleaner.x][i] = map[cleaner.x][i - 1];
		map[cleaner.x][1] = 0;
	}

	public static void StartBottomClean(int[][] map, Dust cleaner) {
		for (int i = cleaner.x + 1; i < r - 1; i++)
			map[i][0] = map[i + 1][0];
		for (int i = 0; i < c - 1; i++)
			map[r - 1][i] = map[r - 1][i + 1];
		for (int i = r - 1; i > cleaner.x; i--)
			map[i][c - 1] = map[i - 1][c - 1];
		for (int i = c - 1; i > 1; i--)
			map[cleaner.x][i] = map[cleaner.x][i - 1];
		map[cleaner.x][1] = 0;
	}
}

class Dust {
	int x;
	int y;
	int value;

	public Dust(int _x, int _y, int _value) {
		this.x = _x;
		this.y = _y;
		this.value = _value;
	}
}

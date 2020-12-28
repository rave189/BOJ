import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static ArrayList<Point> virus = new ArrayList<Point>();
	static int totalZeroCnt;
	static int[] drtX = { 0, 0, 1, -1 };
	static int[] drtY = { 1, -1, 0, 0 };
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virus.add(new Point(i, j));
				else if (map[i][j] == 0)
					totalZeroCnt++;
			}
		}
		Search(0);
		System.out.println(answer - 3);
	}

	public static void Search(int depth) {
		if (depth == 3) {
			Check();
		} else
			for (int i = 0; i < map.length; i++)
				for (int j = 0; j < map[0].length; j++)
					if (map[i][j] == 0) {
						map[i][j] = 1;
						Search(depth + 1);
						map[i][j] = 0;
					}
	}

	public static void Check() {
		int[][] tmp = copyArr();
		Queue<Point> q = new LinkedList<Point>();
		for (int i = 0; i < virus.size(); i++)
			q.add(virus.get(i));
		int totalZero = totalZeroCnt;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + drtX[i];
				int nextY = cur.y + drtY[i];
				if ((0 <= nextX && nextX < tmp.length) && (0 <= nextY && nextY < tmp[0].length))
					if (tmp[nextX][nextY] == 0) {
						q.add(new Point(nextX, nextY));
						tmp[nextX][nextY] = 2;
						totalZero--;
					}
			}
		}
		answer = Math.max(answer, totalZero);
	}

	public static int[][] copyArr() {
		int[][] copy = new int[map.length][map[0].length];
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map[0].length; j++)
				copy[i][j] = map[i][j];
		return copy;
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

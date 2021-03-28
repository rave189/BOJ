import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int answer = Integer.MAX_VALUE;
	static int[] drtX = { 1, -1, 0, 0 };
	static int[] drtY = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++)
				map[i][j] = line.charAt(j) - '0';
		}
		PriorityQueue<Point> q = new PriorityQueue<>();
		Point end = new Point(n - 1, m - 1, 0);
		q.add(new Point(0, 0, 0));
        visited[0][0] = true;
		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (cur.equals(end)) {
				System.out.println(cur.breakCnt);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + drtX[i];
				int nextY = cur.y + drtY[i];
				try {
					if (!visited[nextX][nextY]) {
						int isbreak = map[nextX][nextY] == 1 ? cur.breakCnt + 1 : cur.breakCnt;
						q.add(new Point(nextX, nextY, isbreak));
                        visited[nextX][nextY] = true;
					}
				} catch (Exception e) {
				}
			}
		}
	}
}

class Point implements Comparable<Point> {
	int x;
	int y;
	int breakCnt;

	public Point(int _x, int _y, int _breakCnt) {
		this.x = _x;
		this.y = _y;
		this.breakCnt = _breakCnt;
	}

	public boolean equals(Point o) {
		return x == o.x && y == o.y;
	}

	@Override
	public int compareTo(Point o) {
		return breakCnt - o.breakCnt;
	}
}

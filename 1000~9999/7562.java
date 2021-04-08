import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int answer;
	static boolean[][] map;
	static int[] drtX = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] drtY = { 2, 1, -1, -2, -2, -1, 1, 2 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testCase; t++) {
			int l = Integer.parseInt(br.readLine());
			map = new boolean[l][l];
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			BFS(start, end);
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}

	public static void BFS(Point start, Point end) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point cur = q.poll();
				if (cur.equals(end))
					return;
				if (map[cur.x][cur.y])
					continue;
				map[cur.x][cur.y] = true;
				for (int j = 0; j < 8; j++) {
					int nextX = cur.x + drtX[j];
					int nextY = cur.y + drtY[j];
					try {
						if (!map[nextX][nextY])
							q.add(new Point(nextX, nextY));
					} catch (Exception e) {
					}
				}
			}
			answer++;
		}
	}
}

class Point {
	int x;
	int y;

	public Point(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}

	public boolean equals(Point other) {
		if (x == other.x && y == other.y)
			return true;
		return false;
	}
}

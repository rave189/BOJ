import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		boolean[][] check = new boolean[n][n];
		Point shark = null;
		int sharkSize = 2;
		int[] drtX = { 1, -1, 0, 0 };
		int[] drtY = { 0, 0, 1, -1 };
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Point(i, j);
					map[i][j] = 0;
				}
			}
		}
		check[shark.x][shark.y] = true;
		Queue<Point> q = new LinkedList<Point>();
		PriorityQueue<Point> fish = new PriorityQueue<Point>();
		Queue<Point> next;
		q.add(shark);
		int answer = 0;
		int count = 0;
		int eat = 0;
		while (!q.isEmpty()) {
			next = new LinkedList<Point>();
			while (!q.isEmpty()) {
				Point cur = q.poll();
				for (int i = 0; i < 4; i++) {
					int nextX = cur.x + drtX[i];
					int nextY = cur.y + drtY[i];
					if ((0 <= nextX && nextX < n) && (0 <= nextY && nextY < n))
						if (!check[nextX][nextY]) {
							if (map[nextX][nextY] == 0 || map[nextX][nextY] == sharkSize) {
								next.add(new Point(nextX, nextY));
								check[nextX][nextY] = true;
							} else if (map[nextX][nextY] < sharkSize) {
								fish.add(new Point(nextX, nextY));
								check[nextX][nextY] = true;
							}

						}
				}
			}
			count++;
			if (fish.size() != 0) {
				q.add(fish.poll());
				CheckReset(check);
				check[q.peek().x][q.peek().y] = true;
				map[q.peek().x][q.peek().y] = 0;
				if (++eat == sharkSize) {
					sharkSize++;
					eat = 0;
				}
				answer += count;
				count = 0;
				fish.clear();
			} else
				q = next;
		}
		System.out.println(answer);
	}

	public static void CheckReset(boolean[][] check) {
		for (int i = 0; i < check.length; i++)
			for (int j = 0; j < check[0].length; j++)
				check[i][j] = false;
	}
}

class Point implements Comparable<Point> {
	int x;
	int y;

	public Point(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}

	@Override
	public int compareTo(Point o) {
		if (x < o.x)
			return -1;
		else if (x == o.x) {
			if (y < o.y)
				return -1;
			else if (y == o.y)
				return 0;
			else
				return 1;
		} else
			return 1;
	}
}

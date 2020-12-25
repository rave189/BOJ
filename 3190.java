import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[y - 1][x - 1] = 1;
		}
		ArrayList<Direction> arr = new ArrayList<Direction>();
		int l = Integer.parseInt(br.readLine());
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int second = Integer.parseInt(st.nextToken());
			String direction = st.nextToken();
			arr.add(new Direction(second, direction));
		}
		int[] drtX = { 1, 0, -1, 0 };
		int[] drtY = { 0, 1, 0, -1 };
		int drtIdx = 0;
		Deque<Point> snake = new ArrayDeque<Point>();
		snake.add(new Point(0, 0));
		for (int i = 1;; i++) {
			Point next = new Point(snake.getLast().x + drtX[drtIdx], snake.getLast().y + drtY[drtIdx]);
			boolean aroundCheck = (next.x < 0 || next.x >= n) || (next.y < 0 || next.y >= n);
			if (ContainPoint(snake.iterator(), next) || aroundCheck) {
				System.out.println(i);
				return;
			} else {
				snake.addLast(next);
				if (map[next.x][next.y] != 1)
					snake.removeFirst();
				else
					map[next.x][next.y] = 0;
			}
			if (arr.size() != 0 && i == arr.get(0).second) {
				Direction cur = arr.remove(0);
				if (cur.direction.equals("D"))
					drtIdx = ++drtIdx % 4;
				else {
					if (drtIdx == 0)
						drtIdx = 3;
					else
						drtIdx--;
				}
			}
		}
	}

	public static boolean ContainPoint(Iterator<Point> it, Point p) {
		while (it.hasNext()) {
			Point cur = it.next();
			if (cur.x == p.x && cur.y == p.y)
				return true;
		}
		return false;
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

class Direction {
	int second;
	String direction;

	public Direction(int _second, String _direction) {
		this.second = _second;
		this.direction = _direction;
	}
}

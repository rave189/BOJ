import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] map;
	static ArrayList<Point> dragonCurve = new ArrayList<Point>();
	static int generation = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		map = new boolean[101][101];
		for (int i = 0; i < t; i++) {
			dragonCurve.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			generation = Integer.parseInt(st.nextToken());
			Point start = NextPoint(x, y, direction);
			dragonCurve.add(start);
			map[y][x] = true;
			map[start.y2][start.x2] = true;
			if (generation > 0)
				DragonCurve(1);
		}
		int answer = 0;
		for (int i = 0; i < 100; i++)
			for (int j = 0; j < 100; j++)
				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1])
					answer++;
		System.out.println(answer);
	}

	public static void DragonCurve(int curGeneration) {
		int size = dragonCurve.size();
		for (int i = size - 1; i >= 0; i--) {
			Point point = dragonCurve.get(i);
			Point lastPoint = dragonCurve.get(dragonCurve.size() - 1);
			Point next = NextPoint(lastPoint.x2, lastPoint.y2, (point.direction + 1) % 4);
			map[next.y2][next.x2] = true;
			dragonCurve.add(next);
		}
		if (generation != curGeneration)
			DragonCurve(curGeneration + 1);
	}

	public static Point NextPoint(int x, int y, int direction) {
		Point next = null;
		switch (direction) {
		case 0:
			next = new Point(x, y, x + 1, y, direction);
			break;
		case 1:
			next = new Point(x, y, x, y - 1, direction);
			break;
		case 2:
			next = new Point(x, y, x - 1, y, direction);
			break;
		case 3:
			next = new Point(x, y, x, y + 1, direction);
		}
		return next;
	}
}

class Point {
	int x1;
	int y1;
	int x2;
	int y2;
	int direction;

	public Point(int _x1, int _y1, int _x2, int _y2, int _direction) {
		this.x1 = _x1;
		this.y1 = _y1;
		this.x2 = _x2;
		this.y2 = _y2;
		this.direction = _direction;
	}
}

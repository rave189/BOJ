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
		st = new StringTokenizer(br.readLine());
		Point cur = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		int direction = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int cleanCnt = 0;
		clean: while (true) {
			cleanCnt++;
			map[cur.x][cur.y] = 2;
			for (int i = 0; i < 4; i++) {
				Point next = LeftPoint(cur, direction);
				direction = direction - 1 < 0 ? 3 : direction - 1;
				if (map[next.x][next.y] == 0) {
					cur = next;
					break;
				}
				if (i == 3) {
					Point back = BackPoint(cur, direction);
					if (map[back.x][back.y] == 1)
						break clean;
					else {
						cur = back;
						i = -1;
					}
				}
			}
		}
		System.out.println(cleanCnt);
	}

	public static Point BackPoint(Point cur, int direction) {
		Point back = null;
		switch (direction) {
		case 0:
			back = new Point(cur.x + 1, cur.y);
			break;
		case 1:
			back = new Point(cur.x, cur.y - 1);
			break;
		case 2:
			back = new Point(cur.x - 1, cur.y);
			break;
		default:
			back = new Point(cur.x, cur.y + 1);
		}
		return back;
	}

	public static Point LeftPoint(Point cur, int direction) {
		Point next = null;
		switch (direction) {
		case 0:
			next = new Point(cur.x, cur.y - 1);
			break;
		case 1:
			next = new Point(cur.x - 1, cur.y);
			break;
		case 2:
			next = new Point(cur.x, cur.y + 1);
			break;
		default:
			next = new Point(cur.x + 1, cur.y);
		}
		return next;
	}
}

class Point {
	int x;
	int y;

	public Point(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}

	public String toString() {
		return x + " " + y;
	}
}

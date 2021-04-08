import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Point cur = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		int k = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int[] drtX = { 0, 0, 0, -1, 1 };
		int[] drtY = { 0, 1, -1, 0, 0 };
		int[] dice = { 0, 0, 0, 0, 0, 0 }; // 상, 하, 좌, 우, 앞, 뒤
		for (int i = 0; i < k; i++) {
			int direction = Integer.parseInt(st.nextToken());
			Point next = new Point(cur.x + drtX[direction], cur.y + drtY[direction]);
			boolean borderCheck = (0 <= next.x && next.x < n) && (0 <= next.y && next.y < m);
			if (borderCheck) {
				cur = next;
				dice = Rotation(dice, direction);
				if (map[cur.x][cur.y] == 0)
					map[cur.x][cur.y] = dice[1];
				else {
					dice[1] = map[cur.x][cur.y];
					map[cur.x][cur.y] = 0;
				}
				sb.append(dice[0] + "\n");
			}
		}
		System.out.println(sb);
	}

	public static int[] Rotation(int[] dice, int direction) {
		switch (direction) {
		case 1:
			int[] east = { dice[2], dice[3], dice[1], dice[0], dice[4], dice[5] };
			return east;
		case 2:
			int[] west = { dice[3], dice[2], dice[0], dice[1], dice[4], dice[5] };
			return west;
		case 3:
			int[] north = { dice[5], dice[4], dice[2], dice[3], dice[0], dice[1] };
			return north;
		default:
			int[] south = { dice[4], dice[5], dice[2], dice[3], dice[1], dice[0] };
			return south;
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
}

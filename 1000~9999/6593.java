package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * ��� ������ ���� Ż���Ϸ��� �Ѵ�.
 * ��� ������ L���� ���� �ְ�, �� ���� RxC�� �̷���� �ִ�.
 * �̵��� ��, ��, ��, ��, ��, �Ϸ� �̵��� �� �ִ�.
 * Ż���ϴµ� �ʿ��� �ִ� �ð��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

    // ������ L���� ���� ���� RxC�� �̷���� �ִ�.
	static char[][][] building;
	static boolean[][][] visited;
	static Queue<Point> q;
	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, 1, -1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		while (true) {
			q = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
            // �Է��� 0�̸� �����Ѵ�.
			if (l == 0 && r == 0 && c == 0)
				break;
			building = new char[l][r][c];
			visited = new boolean[l][r][c];
			for (int h = 0; h < l; h++) {
				for (int x = 0; x < r; x++) {
					String line = br.readLine();
					for (int y = 0; y < c; y++) {
						building[h][x][y] = line.charAt(y);
                        // ���� ������ �� �� �����Ƿ� �Է� ���� �� �̸� ť�� �־�д�.
						if (building[h][x][y] == 'S') {
							q.add(new Point(x, y, h));
							visited[h][x][y] = true;
						}
					}
				}
                // �� �� ���̿� �� ���� �ϳ��� �ִ�.
				br.readLine();
			}
			int result = BFS();
			if (result > 0)
				sb.append(String.format("Escaped in %d minute(s).", result));
			else
				sb.append("Trapped!");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	/**
	 * ������������ �������� ���� �ʺ� �켱 Ž���� �����ϴ� �޼ҵ�
	 * ��, ��, ��, ��, ��, �Ϸ� �����δ�.
	 * @return �ɸ� �ð�, Ż������ ���ϸ� -1
	 */
	public static int BFS() {
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Point cur = q.poll();
				if (building[cur.h][cur.x][cur.y] == 'E')
					return time;
				for (int i = 0; i < 6; i++) {
					int nextX = cur.x + dx[i];
					int nextY = cur.y + dy[i];
					int nextH = cur.h + dh[i];
					try {
						if (building[nextH][nextX][nextY] != '#' && !visited[nextH][nextX][nextY]) {
							q.add(new Point(nextX, nextY, nextH));
							visited[nextH][nextX][nextY] = true;
						}
					} catch (Exception e) {
					}
				}
			}
			time++;
		}
		return -1;
	}
}

class Point {
	int x, y, h;

	public Point(int _x, int _y, int _h) {
		this.x = _x;
		this.y = _y;
		this.h = _h;
	}
}
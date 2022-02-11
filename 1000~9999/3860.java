package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ����������� ������������ ���� ���� ���� �ð��� ���ϴ� ����
 * �� �������� �ͽ� ������ �ְ�, �ͽ� ���ۿ� ������ �ٸ� �������� t��(-10000 <= t <= 10000)�� ���� �ڿ� ������ �ȴ�.
 * �׸��� ���� �ִµ� �� �����δ� ���� ���Ѵ�.
 * ���� ��� ���ŷ� ���� �ȴٸ� Never��, ���� �������� ���� ���Ѵٸ� Impossible��, ������ ���� ���� ���� �ð��� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int INF = 1000000000;

	/**
	 * ���� ���带 Ȱ���Ͽ� ���� �� �ִ�.
	 * ���� ����Ŭ�� ������ ��� �ٷ� Never�� ����Ѵ�.
	 * ���� ����Ŭ�� ������ ���� ������ ���� INF�̸� Impossible�� ����Ѵ�.
	 * ������ ���� �ٷ� ����Ѵ�.
	 * 
	 * ���� ���带 ����� �� INF - a�� �ϰ� �Ǹ� ���� Ž���� ���� ���� �������� Ž���� �߻��� �� �ִ�.
	 * ���� cost[][] != INF�� �ٿ��ش�.
	 * ����� isBlock�� ����, �ͽ� ������ �̸� Edge�� �־��� �� isUsed�� �߰��Ͽ� ������ �߻����� �ʵ��� �Ѵ�.
	 * 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0)
				break;
			boolean[][] isBlock = new boolean[w][h];
			int[][] cost = new int[w][h];
			for (int i = 0; i < w; i++)
				Arrays.fill(cost[i], INF);
			int g = Integer.parseInt(br.readLine());
			while (g-- > 0) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				isBlock[x][y] = true;
			}
			boolean[][] isUsed = new boolean[w][h];
			ArrayList<Edge> edges = new ArrayList<>();
			int e = Integer.parseInt(br.readLine());
			while (e-- > 0) {
				st = new StringTokenizer(br.readLine());
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				edges.add(new Edge(x1, y1, x2, y2, t));
				isUsed[x1][y1] = true;
			}
			for (int i = 0; i < w; i++)
				for (int j = 0; j < h; j++) {
					if (isUsed[i][j] || (i == w - 1 && j == h - 1) || isBlock[i][j])
						continue;
					for (int t = 0; t < dx.length; t++) {
						int nextX = i + dx[t];
						int nextY = j + dy[t];
						try {
							if (isBlock[nextX][nextY])
								continue;
							edges.add(new Edge(i, j, nextX, nextY, 1));
						} catch (ArrayIndexOutOfBoundsException idxException) {
						}
					}
				}
			cost[0][0] = 0;
			boolean isCycle = false;
			for (int i = 1; i <= w * h; i++) {
				for (Edge cur : edges) {
					if (cost[cur.x1][cur.y1] != INF && cost[cur.x1][cur.y1] + cur.t < cost[cur.x2][cur.y2]) {
						cost[cur.x2][cur.y2] = cost[cur.x1][cur.y1] + cur.t;
						if (i == w * h)
							isCycle = true;
					}
				}
			}
			if (isCycle)
				answer.append("Never");
			else if (cost[w - 1][h - 1] == INF)
				answer.append("Impossible");
			else
				answer.append(cost[w - 1][h - 1]);
			answer.append('\n');
		}
		System.out.print(answer);
	}
}

class Edge {
	int x1, y1, x2, y2, t;

	public Edge(int x1, int y1, int x2, int y2, int t) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.t = t;
	}
}
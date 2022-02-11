package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출발지점에서 도착지점까지 가는 가장 빠른 시간을 구하는 문제
 * 이 지도에는 귀신 구멍이 있고, 귀신 구멍에 빠지면 다른 지점으로 t초(-10000 <= t <= 10000)가 지난 뒤에 나오게 된다.
 * 그리고 묘비가 있는데 이 곳으로는 가지 못한다.
 * 만약 계속 과거로 가게 된다면 Never를, 도착 지점으로 가지 못한다면 Impossible을, 나머지 경우는 가장 빠른 시간을 출력한다.
 * @author Rave
 *
 */
public class Main {

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int INF = 1000000000;

	/**
	 * 벨만 포드를 활용하여 구할 수 있다.
	 * 음수 사이클이 나오는 경우 바로 Never를 출력한다.
	 * 음수 사이클이 없지만 도착 지점의 값이 INF이면 Impossible을 출력한다.
	 * 나머지 경우는 바로 출력한다.
	 * 
	 * 벨만 포드를 사용할 때 INF - a를 하게 되면 아직 탐색이 되지 않은 곳에서도 탐색이 발생할 수 있다.
	 * 따라서 cost[][] != INF를 붙여준다.
	 * 묘비는 isBlock에 저장, 귀신 구멍은 미리 Edge를 넣어준 후 isUsed에 추가하여 간선이 발생하지 않도록 한다.
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
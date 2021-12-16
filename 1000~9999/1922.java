package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 모든 컴퓨터를 연결하는 네트워크를 구축하려고 한다.
 * 각각의 컴퓨터를 연결하는 비용은 다를 수 있다.
 * 모든 컴퓨터를 연결하는 네트워크의 최소비용을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static boolean[] visited;

	/**
	 * 최소 스패닝 트리 문제
	 * 프림 알고리즘을 사용하여 문제를 푼다.
	 * 
	 * 시작 정점을 하나 두고 시작한다.
	 * 연결된 모든 간선 중 가장 비용이 낮은 간선을 하나 택한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		visited = new boolean[n];
		map = new int[n][n];
		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			map[start][end] = weight;
			map[end][start] = weight;
		}
		PriorityQueue<Point> pq = new PriorityQueue<>();
		int answer = 0;
		pq.add(new Point(0, 0));
		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			if (visited[cur.x])
				continue;
			visited[cur.x] = true;
			answer += cur.weight;
			for (int idx = 0; idx < n; idx++) {
				if (visited[idx] || map[cur.x][idx] == 0)
					continue;
				pq.add(new Point(idx, map[cur.x][idx]));
			}
		}
		System.out.println(answer);
	}
}

class Point implements Comparable<Point> {
	int x, weight;

	public Point(int x, int weight) {
		this.x = x;
		this.weight = weight;
	}

	@Override
	public int compareTo(Point o) {
		return weight - o.weight;
	}
}
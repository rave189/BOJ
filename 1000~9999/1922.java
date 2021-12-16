package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * ��� ��ǻ�͸� �����ϴ� ��Ʈ��ũ�� �����Ϸ��� �Ѵ�.
 * ������ ��ǻ�͸� �����ϴ� ����� �ٸ� �� �ִ�.
 * ��� ��ǻ�͸� �����ϴ� ��Ʈ��ũ�� �ּҺ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static boolean[] visited;

	/**
	 * �ּ� ���д� Ʈ�� ����
	 * ���� �˰����� ����Ͽ� ������ Ǭ��.
	 * 
	 * ���� ������ �ϳ� �ΰ� �����Ѵ�.
	 * ����� ��� ���� �� ���� ����� ���� ������ �ϳ� ���Ѵ�.
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
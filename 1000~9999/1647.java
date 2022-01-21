package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 마을에는 N개의 집과 M개의 길이 있다.
 * 이 마을을 두 개의 분리된 마을로 분할하려고 한다.
 * 이때, M개의 길은 유지비가 너무 많이 나와 최소한의 길을 제외한 모든 길을 없애려고 한다.
 * 분리된 마을 사이에는 길이 필요 없으므로 모두 지우고,
 * 각 마을 안의 집 사이에도 최소한의 길을 제외한 모든 길을 지운다.
 * 이때, 길을 유지하는 비용의 최솟값을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[] unionFind;

	/**
	 * 크루스칼 알고리즘을 사용하여 풀 수 있다.
	 * 집을 연결하는 도로를 n-2개만 구한다.
	 * 나머지 n-1번째 도로가 마을을 분할하는 도로이다.
	 * 따라서 n-2까지의 유지비의 합이 최솟값이다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		unionFind = new int[n];
		for (int i = 1; i < n; i++)
			unionFind[i] = i;
		PriorityQueue<Road> pq = new PriorityQueue<>();
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			pq.add(new Road(x, y, cost));
			pq.add(new Road(y, x, cost));
		}
		int answer = 0;
		while (n > 2) {
			Road cur = pq.poll();
			if (union(cur.x, cur.y)) {
				answer += cur.cost;
				n--;
			}
		}
		System.out.println(answer);
	}

	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			unionFind[y] = x;
			return true;
		}
		return false;
	}

	public static int find(int x) {
		if (x == unionFind[x])
			return x;
		return unionFind[x] = find(unionFind[x]);
	}
}

class Road implements Comparable<Road> {
	int x, y, cost;

	public Road(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	@Override
	public int compareTo(Road o) {
		return cost - o.cost;
	}
}
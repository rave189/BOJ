package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * N개의 도시가 있다.
 * 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다.
 * A도시에서 B도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다.
 * 최소 비용을 구하는 문제
 * 버스는 단방향이다.
 * 그리고 정답이 있는 경우만 입력으로 주어진다.
 * @author Rave
 *
 */
public class Main {

	static int[] answer;
	// i번에서 Bus가 도착하는 도시와 비용을 저장한다.
	static HashSet<Bus>[] routes;
	// 기본 값을 설정해둔다.
	static int INF = 100000001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		answer = new int[n + 1];
		routes = new HashSet[n + 1];
		for (int i = 1; i <= n; i++) {
			answer[i] = INF;
			routes[i] = new HashSet<>();
		}
		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int busStart = Integer.parseInt(st.nextToken());
			int busEnd = Integer.parseInt(st.nextToken());
			int busCost = Integer.parseInt(st.nextToken());
			routes[busStart].add(new Bus(busEnd, busCost));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		Diijkstra(start);
		System.out.println(answer[end]);
	}

	/**
	 * 각각의 도시들을 탐색하며 더 적은 비용이 드는 경로를 answer에 저장한다.
	 * 탐색은 너비 우선 탐색을 이용하여 구현한다.
	 */
	public static void Diijkstra(int start) {
		answer[start] = 0;
		Queue<Bus> q = new LinkedList<>();
		q.add(new Bus(start, 0));
		while (!q.isEmpty()) {
			Bus cur = q.poll();
			for (Bus next : routes[cur.end]) {
				int nextCost = cur.cost + next.cost;
				if (nextCost < answer[next.end]) {
					answer[next.end] = nextCost;
					q.add(new Bus(next.end, nextCost));
				}
			}
		}
	}
}

class Bus {
	int end, cost;

	public Bus(int _end, int _cost) {
		this.end = _end;
		this.cost = _cost;
	}
}
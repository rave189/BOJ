package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 그래프가 주어질 때, 1번 정점에서 N번 정점까지 최단 거리로 이동하려고 한다.
 * 이 때, 임의로 주어지는 두 정점을 반드시 지나면서 갈 수 있는 최단 거리를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static List<Node>[] map;

	/**
	 * 어느 정점도 못 지나간 경우 0번 배열
	 * 첫 번째 정점을 지나간 경우 1번 배열
	 * 두 번째 정점을 지나간 경우 2번 배열
	 * 두 정점을 모두 지나간 경우 3번 배열에 최단경로를 저장한다.
	 * 이 때 첫 번째 정점이 1번 정점이어서 첫 번째 정점을 방문했다고 체크하면서 시작해야하는 경우가 있다.
	 * 그렇기에 첫 번째 정점이 1번 정점인지 아닌지에 따라 큐에 넣는 첫 값이 달라진다.
	 * 
	 * 위 방법으로는 조금 느리고 1번 -> v1 -> v2 -> V 또는 1번 -> v2 -> v1 -> V 두 가지 경우 중 최솟값을 출력하는게 빠르다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		map = new List[n];
		for (int i = 0; i < n; i++)
			map[i] = new LinkedList<>();
		while (e-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			map[a].add(new Node(b, c));
			map[b].add(new Node(a, c));
		}
		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken()) - 1;
		int second = Integer.parseInt(st.nextToken()) - 1;
		int[][] distance = new int[n][4];
		for (int i = 0; i < n; i++)
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		distance[0][0] = 0;
		if (first == 0)
			distance[0][1] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>((v1, v2) -> v1.cost - v2.cost);
		if (first == 0)
			pq.add(new Node(0, 0, true, false));
		else
			pq.add(new Node(0, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			for (Node next : map[cur.p]) {
				Node newNode;
				if (next.p == first)
					newNode = new Node(next.p, cur.cost + next.cost, true, cur.second);
				else if (next.p == second)
					newNode = new Node(next.p, cur.cost + next.cost, cur.first, true);
				else
					newNode = new Node(next.p, cur.cost + next.cost, cur.first, cur.second);

				if (newNode.first && newNode.second) {
					if (newNode.cost < distance[newNode.p][3]) {
						distance[newNode.p][3] = newNode.cost;
						pq.add(newNode);
					}
				} else if (newNode.second) {
					if (newNode.cost < distance[newNode.p][2]) {
						distance[newNode.p][2] = newNode.cost;
						pq.add(newNode);
					}
				} else if (newNode.first) {
					if (newNode.cost < distance[newNode.p][1]) {
						distance[newNode.p][1] = newNode.cost;
						pq.add(newNode);
					}
				} else {
					if (newNode.cost < distance[newNode.p][0]) {
						distance[newNode.p][0] = newNode.cost;
						pq.add(newNode);
					}
				}
			}
		}
		System.out.println(distance[n - 1][3] == Integer.MAX_VALUE ? -1 : distance[n - 1][3]);
	}
}

class Node {
	int p, cost;
	boolean first = false, second = false;

	public Node(int p, int cost) {
		this.p = p;
		this.cost = cost;
	}

	public Node(int p, int cost, boolean first, boolean second) {
		this.p = p;
		this.cost = cost;
		this.first = first;
		this.second = second;
	}
}
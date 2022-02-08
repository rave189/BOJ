package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 도시에서 도시로 이동하는 비용이 주어진다. (단방향)
 * 1번 도시에서 각 도시로 가는 K번째 최단 경로를 찾는 문제
 * @author Rave
 *
 */
public class Main {

	static HashSet<Node>[] map;
	static PriorityQueue<Integer>[] distance;

	/**
	 * 각 도시로의 최단거리를 저장할 우선순위 큐들을 생성한다.
	 * 큐에 K개 까지의 최단거리를 넣고, K개의 최단 거리를 구했다면 더 작은 값이 들어올 때만 넣고, 가장 큰 최단 거리를 제거한다.
	 * 1번 도시로의 거리 0이 꼭 필요하다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new HashSet[n + 1];
		distance = new PriorityQueue[n + 1];
		for (int i = 1; i <= n; i++) {
			map[i] = new HashSet<>();
			distance[i] = new PriorityQueue<>((v1, v2) -> v2 - v1);
		}
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			map[first].add(new Node(second, weight));
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		distance[1].add(0);
		pq.add(new Node(1, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			for (Node next : map[cur.point]) {
				int curWeight = cur.weight + next.weight;
				if (distance[next.point].size() < k) {
					distance[next.point].add(curWeight);
					pq.add(new Node(next.point, curWeight));
				} else if (distance[next.point].size() == k && curWeight < distance[next.point].peek()) {
					distance[next.point].add(curWeight);
					pq.add(new Node(next.point, curWeight));
					distance[next.point].poll();
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			if (distance[i].size() == k)
				answer.append(distance[i].poll());
			else
				answer.append(-1);
			answer.append('\n');
		}
		System.out.print(answer);
	}
}

class Node implements Comparable<Node> {
	int point, weight;

	public Node(int point, int weight) {
		this.point = point;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}
}
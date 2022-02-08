package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * ���ÿ��� ���÷� �̵��ϴ� ����� �־�����. (�ܹ���)
 * 1�� ���ÿ��� �� ���÷� ���� K��° �ִ� ��θ� ã�� ����
 * @author Rave
 *
 */
public class Main {

	static HashSet<Node>[] map;
	static PriorityQueue<Integer>[] distance;

	/**
	 * �� ���÷��� �ִܰŸ��� ������ �켱���� ť���� �����Ѵ�.
	 * ť�� K�� ������ �ִܰŸ��� �ְ�, K���� �ִ� �Ÿ��� ���ߴٸ� �� ���� ���� ���� ���� �ְ�, ���� ū �ִ� �Ÿ��� �����Ѵ�.
	 * 1�� ���÷��� �Ÿ� 0�� �� �ʿ��ϴ�.
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
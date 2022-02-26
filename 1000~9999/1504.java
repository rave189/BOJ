package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * �׷����� �־��� ��, 1�� �������� N�� �������� �ִ� �Ÿ��� �̵��Ϸ��� �Ѵ�.
 * �� ��, ���Ƿ� �־����� �� ������ �ݵ�� �����鼭 �� �� �ִ� �ִ� �Ÿ��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static List<Node>[] map;

	/**
	 * ��� ������ �� ������ ��� 0�� �迭
	 * ù ��° ������ ������ ��� 1�� �迭
	 * �� ��° ������ ������ ��� 2�� �迭
	 * �� ������ ��� ������ ��� 3�� �迭�� �ִܰ�θ� �����Ѵ�.
	 * �� �� ù ��° ������ 1�� �����̾ ù ��° ������ �湮�ߴٰ� üũ�ϸ鼭 �����ؾ��ϴ� ��찡 �ִ�.
	 * �׷��⿡ ù ��° ������ 1�� �������� �ƴ����� ���� ť�� �ִ� ù ���� �޶�����.
	 * 
	 * �� ������δ� ���� ������ 1�� -> v1 -> v2 -> V �Ǵ� 1�� -> v2 -> v1 -> V �� ���� ��� �� �ּڰ��� ����ϴ°� ������.
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
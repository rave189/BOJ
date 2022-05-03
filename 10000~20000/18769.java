package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * RxC 배열이 있다.
 * 각 지점에는 서버가 있고, 네트워크로 연결되어 있다.
 * 각 네트워크의 비용이 주어질때, 최소 스패닝 트리를 만드는 문제
 * @author Rave
 *
 */
public class Main {

	static int r, c;
	static PriorityQueue<Node> pq = new PriorityQueue<>((v1, v2) -> v1.cost - v2.cost);
	static int[] unionFind;

	/**
	 * 크루스칼 프림 둘다 똑같은 시간이 걸림
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			pq.clear();
			unionFind = new int[r * c];
			for (int i = 1; i < unionFind.length; i++)
				unionFind[i] = i;
			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < c - 1; j++) {
					int cost = Integer.parseInt(st.nextToken());
					int cur = i * c + j;
					pq.add(new Node(cur, cur + 1, cost));
					pq.add(new Node(cur + 1, cur, cost));
				}
			}
			for (int i = 0; i < r - 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < c; j++) {
					int cost = Integer.parseInt(st.nextToken());
					int cur = i * c + j;
					pq.add(new Node(cur, cur + c, cost));
					pq.add(new Node(cur + c, cur, cost));
				}
			}
			answer.append(kruskal()).append('\n');
		}
		System.out.println(answer);
	}

	public static int kruskal() {
		int sum = 0;
		int selected = unionFind.length;
		while (selected > 1) {
			while (!isValid(pq.peek()))
				pq.poll();
			sum += pq.poll().cost;
			selected--;
		}
		return sum;
	}

	public static boolean isValid(Node n) {
		int parentA = find(n.start);
		int parentB = find(n.end);
		if (parentA != parentB) {
			unionFind[parentA] = parentB;
			return true;
		}
		return false;
	}

	public static int find(int n) {
		if (n == unionFind[n])
			return n;
		return unionFind[n] = find(unionFind[n]);
	}
}

class Node {
	int start, end, cost;

	public Node(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Node [start=" + start + ", end=" + end + ", cost=" + cost + "]";
	}
}
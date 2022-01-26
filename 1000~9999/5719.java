package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 그래프가 주어질 때, 거의 최단 경로를 구하는 문제
 * 거의 최단 경로는 최단 경로에 포함되지 않는 도로로만 이루어진 경로 중 가장 짧은 것을 말한다.
 * 거의 최단 경로가 없는 경우 -1을 출력한다.
 * 
 * @author Rave
 *
 */
public class Main {

	static Set<Node>[] map;
	static Set<Integer>[] shortest;
	static int start, end, INF = 10000000;
	static int[] distance;
	static boolean[][] isShortestPath;

	/**
	 * 최단 경로를 한 번 구하고, 그에 사용되는 간선을 모두 사용하지 않도록 처리해준다.
	 * 이후 다시 한 번 최단 경로를 구한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if (n == 0 && m == 0)
				break;
			map = new Set[n];
			shortest = new Set[n];
			distance = new int[n];
			isShortestPath = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				map[i] = new HashSet<>();
				shortest[i] = new HashSet<>();
				distance[i] = INF;
			}
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			while (m-- > 0) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				map[u].add(new Node(v, p));
			}

			findShortestPath();
			removeShortestPath(end);
			Arrays.fill(distance, INF);
			findAlmostShortestPath();
			answer.append(distance[end] == INF ? -1 : distance[end]).append('\n');
		}
		System.out.print(answer);
	}

	public static void findShortestPath() {
		PriorityQueue<Node> pq = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight);
		pq.add(new Node(start, 0));
		distance[start] = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (cur.weight > distance[cur.point])
				continue;
			for (Node next : map[cur.point]) {
				int sum = distance[cur.point] + next.weight;
				if (sum < distance[next.point]) {
					shortest[next.point].clear();
					shortest[next.point].add(cur.point);
					distance[next.point] = sum;
					pq.add(new Node(next.point, distance[next.point]));
				} else if (sum == distance[next.point])
					shortest[next.point].add(cur.point);
			}
		}
	}

	/**
	 * 재귀를 돌 때, 최단 경로 중 같은 간선을 쓰는 경우가 있다.
	 * 이러한 경우가 많다면 시간 초과가 날 수 있다.
	 */
	public static void removeShortestPath(int cur) {
		for (int prev : shortest[cur]) {
			if (!isShortestPath[prev][cur]) {
				isShortestPath[prev][cur] = true;
				removeShortestPath(prev);
			}
		}
	}

	public static void findAlmostShortestPath() {
		PriorityQueue<Node> pq = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight);
		pq.add(new Node(start, 0));
		distance[start] = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (cur.weight > distance[cur.point])
				continue;
			for (Node next : map[cur.point]) {
				if (isShortestPath[cur.point][next.point])
					continue;
				if (distance[cur.point] + next.weight < distance[next.point]) {
					distance[next.point] = distance[cur.point] + next.weight;
					pq.add(new Node(next.point, distance[next.point]));
				}
			}
		}
	}
}

class Node {
	int point, weight;

	public Node(int point, int weight) {
		this.point = point;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Node [point=" + point + ", weight=" + weight + "]";
	}
}
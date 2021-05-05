package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 트리에서 어떤 두 노드를 선택하여 양쪽으로 잡아 당길 때, 가장 길게 늘어나는 경우의 길이를 트리의 지름이라고 한다.
 * 트리의 지름을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	// 노드의 연결관계를 저장한다.
	static HashMap<Integer, HashSet<Node>> hash = new HashMap<>();
	// 방문 체크를 한다.
	static boolean[] visited;
	static int answer = 0;
	// 가장 먼 노드를 저장한다.
	static int longestNode = 0;

	/**
	 * 루트에서 가장 먼 노드를 찾고, 찾은 가장 먼 노드에서 다시 가장 먼 노드를 찾는 방법으로 지름을 구할 수 있다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			hash.putIfAbsent(first, new HashSet<>());
			hash.putIfAbsent(second, new HashSet<>());
			hash.get(first).add(new Node(second, weight));
			hash.get(second).add(new Node(first, weight));
		}
		// 루트에서 가장 먼 노드 찾기
		visited[1] = true;
		DFS(1, 0);
		visited = new boolean[n + 1];
		// 가장 먼 노드에서 가장 먼 노드 찾기
		visited[longestNode] = true;
		DFS(longestNode, 0);
		System.out.println(answer);
	}

	public static void DFS(int cur, int length) {
		if (length > answer) {
			answer = length;
			longestNode = cur;
		}
		for (Node next : hash.getOrDefault(cur, new HashSet<>())) {
			if (!visited[next.vertex]) {
				visited[next.vertex] = true;
				DFS(next.vertex, length + next.weight);
			}
		}
	}
}

class Node {
	int vertex, weight;

	public Node(int _vertex, int _weight) {
		this.vertex = _vertex;
		this.weight = _weight;
	}

	public String toString() {
		return vertex + " " + weight;
	}
}
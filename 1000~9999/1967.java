package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Ʈ������ � �� ��带 �����Ͽ� �������� ��� ��� ��, ���� ��� �þ�� ����� ���̸� Ʈ���� �����̶�� �Ѵ�.
 * Ʈ���� ������ ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	// ����� ������踦 �����Ѵ�.
	static HashMap<Integer, HashSet<Node>> hash = new HashMap<>();
	// �湮 üũ�� �Ѵ�.
	static boolean[] visited;
	static int answer = 0;
	// ���� �� ��带 �����Ѵ�.
	static int longestNode = 0;

	/**
	 * ��Ʈ���� ���� �� ��带 ã��, ã�� ���� �� ��忡�� �ٽ� ���� �� ��带 ã�� ������� ������ ���� �� �ִ�.
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
		// ��Ʈ���� ���� �� ��� ã��
		visited[1] = true;
		DFS(1, 0);
		visited = new boolean[n + 1];
		// ���� �� ��忡�� ���� �� ��� ã��
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
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 완전 이진 트리로 이루어진 도시를 방문한다.
 * 이 도시의 방문 순서가 주어질 때, 완전 이진 트리를 구하는 문제
 * 도시는 중위 순회 방법으로 방문했다.
 * @author Rave
 *
 */
public class Main {

	// 트리를 저장할 ArrayList
	static ArrayList<Integer>[] tree;
	static StringTokenizer st;
	// 트리의 최대 깊이
	static int k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		k = Integer.parseInt(br.readLine());
		tree = new ArrayList[k];
		for (int i = 0; i < k; i++)
			tree[i] = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		traversal(0);
		for (ArrayList<Integer> line : tree) {
			for (int node : line)
				sb.append(node + " ");
			sb.append("\n");
		}
		System.out.print(sb);
	}

	public static void traversal(int depth) {
		if (depth >= k)
			return;
		// 왼쪽 탐색
		traversal(depth + 1);
		// 현재 노드를 트리에 추가
		tree[depth].add(Integer.parseInt(st.nextToken()));
		// 오른쪽 탐색
		traversal(depth + 1);
	}
}
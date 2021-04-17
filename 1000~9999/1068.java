package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 트리가 주어지고 노드를 하나 지웠을 때 리프 노드의 개수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	// 트리를 저장할 배열
	static ArrayList<Integer>[] tree;
	// 지우는 노드
	static int remover;
	// 리프 노드의 개수
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		tree = new ArrayList[n];
		for (int i = 0; i < n; i++)
			tree[i] = new ArrayList<>();
		// 시작 지점을 모르기 때문에 저장한다.
		int start = 0;
		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(st.nextToken());
			if (value == -1)
				start = i;
			else
				tree[value].add(i);
		}
		remover = Integer.parseInt(br.readLine());
		// 지우는 노드의 자식 개수를 없애 탐색을 진행하지 못하도록 한다.
		tree[remover].clear();
		DFS(start);
		System.out.println(answer);
	}

	/**
	 * 트리의 리프 노드의 개수를 깊이 우선 탐색으로 구하는 메소드
	 * @param next 다음 노드
	 */
	public static void DFS(int next) {
		if (next == remover)
			return;
		// 자식 노드의 개수가 없으면 리프 노드의 개수 1 증가
		else if (tree[next].size() == 0) {
			answer++;
			return;
		}
		for (int value : tree[next])
			// remover의 부모노드가 자식을 remover만 가지고 있다면 1 증가시킨다.
			if (value == remover && tree[next].size() == 1)
				answer++;
			else
				DFS(value);
	}
}
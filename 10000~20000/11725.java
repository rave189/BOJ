package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 트리의 루트를 1이라고 할 때, 각 트리의 부모를 찾는 문제
 * 입력은 각 트리 상 연결된 두 정점이 주어진다.
 * 입력의 시작은 1부터가 아니고, 왼쪽이 부모일 수도, 오른쪽이 부모 일 수도 있다.
 * @author Rave
 *
 */
public class Main {

	// 입력이 10만이기 때문에 이차원 배열로 선언 시 메모리 초과
	static ArrayList<Integer>[] treeMap;
	// 각 트리의 부모를 저장할 배열
	static int[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력이 10만이기 때문에 버퍼를 사용해서 출력한다.
        StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		treeMap = new ArrayList[n + 1];
		tree = new int[n + 1];
		for (int i = 1; i <= n; i++)
			treeMap[i] = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			treeMap[first].add(second);
			treeMap[second].add(first);
		}
		DFS(1);
		for (int i = 2; i <= n; i++)
			sb.append(tree[i]+"\n");
        System.out.println(sb);
	}

	/**
	 * 각 트리의 자식들을 깊이 우선 탐색으로 탐색한다.
	 * 깊이 우선 탐색이 너비 우선 탐색보다 속도가 빠르다.
	 * @param next 시작 트리 1
	 */
	public static void DFS(int next) {
		for (int item : treeMap[next])
			if (tree[item] == 0) {
				// 부모 노드를 설정해준다.
				tree[item] = next;
				DFS(item);
			}
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 트리틑 사이클이 없는 연결 요소이다.
 * 그래프가 주어졌을 때, 트리의 개수를 구하는 문제
 */
public class Main {

	static boolean[][] tree;
	static int[] unionFind;
	static boolean[] isCycle;

	/**
	 * 입력이 주어질 때마다 유니온 파인드를 사용하여 루트 노드를 탐색한다.
	 * 만약 두 루트 노드를 이어야 한다면 사이클이 형성되는 것이므로 isCycle을 true로 만들어준다.
	 * 입력이 종료되면 isCycle의 값이 false인 트리의 개수를 센다.
	 * 같은 트리를 연속해서 세면 안되므로 한 번 센 트리는 isCycle을 true로 바꾸어 세지 않도록 한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int caseNumber = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if (n == 0 && m == 0)
				break;
			tree = new boolean[n][n];
			unionFind = new int[n];
			isCycle = new boolean[n];
			for (int i = 1; i < unionFind.length; i++)
				unionFind[i] = i;
			while (m-- > 0) {
				st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken()) - 1;
				int second = Integer.parseInt(st.nextToken()) - 1;
				int firstParent = find(first);
				int secondParent = find(second);
				// 두 트리를 이으려고 하면 isCycle을 true로
				if (unionFind[firstParent] == unionFind[secondParent])
					isCycle[firstParent] = true;
				else
					unionFind[firstParent] = unionFind[secondParent];
			}
			int count = 0;
			for (int i = 0; i < isCycle.length; i++) {
				int parent = find(i);
				if (!isCycle[parent]) {
					isCycle[parent] = true;
					count++;
				}
			}
			answer.append("Case " + caseNumber++ + ": ");
			if (count == 0)
				answer.append("No trees.");
			else if (count == 1)
				answer.append("There is one tree.");
			else
				answer.append("A forest of " + count + " trees.");
			answer.append('\n');
		}
		System.out.println(answer);
	}

	public static int find(int cur) {
		if (cur == unionFind[cur])
			return cur;
		unionFind[cur] = find(unionFind[cur]);
		if (isCycle[cur] || isCycle[unionFind[cur]]) {
			isCycle[cur] = true;
			isCycle[unionFind[cur]] = true;
		}
		return unionFind[cur];
	}
}
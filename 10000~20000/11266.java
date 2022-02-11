package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 그래프가 주어질 때, 단절점의 개수와 단절점인 정점의 번호를 출력하는 문제
 * 그래프는 연결 그래프가 아닐 수도 있다.
 * @author Rave
 *
 */
public class Main {

	static HashSet<Integer>[] map;
	static int[] order;
	static int orderCnt = 1;
	static boolean[] isCutNode;

	/**
	 * 공식
	 * 시작 정점인 경우
	 * - 자식 트리의 개수가 2개 이상이면 단절점, 아니라면 단절점이 아니다.
	 * 시작 정점이 아닌 경우
	 * - 자신의 다음 방문 정점들 중에서 자신을 거치지 않고 자신보다 탐색 순서가 앞선 정점을 방문할 수 없다면 단절점
	 * (우회 경로가 존재한다면 더 작은 순서의 정점을 반환해야 한다.)
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new HashSet[n + 1];
		order = new int[n + 1];
		isCutNode = new boolean[n + 1];
		for (int i = 0; i <= n; i++)
			map[i] = new HashSet<>();
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			map[first].add(second);
			map[second].add(first);
		}

		for (int i = 1; i <= n; i++)
			if (order[i] == 0)
				dfs(i, true);
		int count = 0;
		for (int i = 1; i <= n; i++)
			if (isCutNode[i]) {
				count++;
				answer.append(i).append(' ');
			}
		System.out.println(count);
		System.out.print(answer);
	}

	public static int dfs(int cur, boolean isRoot) {
		order[cur] = orderCnt;
		int rtn = orderCnt++;
		int child = 0;
		for (int next : map[cur]) {
			if (order[next] == 0) {
				child++;
				int low = dfs(next, false);
				// 시작 정점이 아니면서 cur보다 방문 순서가 크다면 단절점
				if (!isRoot && low >= order[cur])
					isCutNode[cur] = true;
				rtn = Math.min(rtn, low);
			} else
				rtn = Math.min(rtn, order[next]);
		}
		// 첫 재귀만 해당
		// 시작 정점의 경우 자식 트리가 두 개 이상이라면 단절점
		if (isRoot && child >= 2)
			isCutNode[cur] = true;
		return rtn;
	}
}
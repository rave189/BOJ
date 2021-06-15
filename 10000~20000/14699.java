package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 관악산에는 N개의 쉼터와 M개의 길들로 이루어져 있다.
 * 이 때, 최대한 많은 쉼터를 방문하며 최상단까지 올라가려고 한다.
 * 각각의 쉼터에서 최대 몇 개의 쉼터를 방문할 수 있는지 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static HashSet<Integer>[] hash;
	// i번째 위에 가장 많이 방문할 수 있는 쉼터의 개수를 저장한다.
	static int[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] height = new int[n];
		visited = new int[n];
		hash = new HashSet[n];
		for (int i = 0; i < n; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			hash[i] = new HashSet<>();
		}
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken()) - 1;
			int second = Integer.parseInt(st.nextToken()) - 1;
			// 큰 쉼터만 방문하며 지나가야 하므로 큰 경우만 hash에 저장한다.
			if (height[first] > height[second])
				hash[second].add(first);
			else if (height[second] > height[first])
				hash[first].add(second);
		}
		for (int i = 0; i < n; i++)
			sb.append(getMaxRestArea(0, i) + 1 + "\n");
		System.out.println(sb);
	}

	/**
	 * 각각의 쉼터에서 가장 많이 방문할 수 있는 쉼터의 개수를 구하는 메소드
	 * 메모이제이션 DFS를 사용하여 시간을 줄이며 탐색한다.
	 * @param depth 현재 방문한 쉼터의 개수
	 * @param cur 현재 쉼터의 번호
	 * @return 가장 많이 방문할 수 있는 쉼터의 개수
	 */
	public static int getMaxRestArea(int depth, int cur) {
		// 기본을 depth로 초기화 한다.
		int max = depth;
		for (int next : hash[cur])
			// 방문한 적이 있다면 그 값 + depth와 max를 비교한다.
			if (visited[next] != 0)
				max = Math.max(max, visited[next] + depth);
			// 방문하지 않았다면 DFS로 다음 지점을 탐색한다.
			else
				max = Math.max(max, getMaxRestArea(depth + 1, next));
		// 최대 방문 개수와 현재까지의 방문 개수를 빼 cur 위에 방문할 수 있는 최대 노드의 개수를 구한다.
		// 거기에 +1을 하여 cur 지점도 포함한 값을 visited에 저장한다.
		visited[cur] = max - depth + 1;
		return max;
	}
}
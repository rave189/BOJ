package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 서울 지하철 2호선은 1개의 순환선과 2개의 지선으로 이루어져 있다.
 * 이 때, 각 역들과 순환선 사이의 거리를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static HashSet<Integer>[] hash;
	static boolean[] visited;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		hash = new HashSet[n + 1];
		answer = new int[n + 1];
		for (int i = 1; i <= n; i++)
			hash[i] = new HashSet<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			hash[first].add(second);
			hash[second].add(first);
		}
		// 순환선을 찾는다.
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			if (isCycle(i, i, -1))
				break;
		}
		// 각 역들과 순환선 사이의 거리를 구한다.
		for (int i = 1; i <= n; i++) {
			if (visited[i])
				continue;
			answer[i] = BFS(i);
		}
		for (int i = 1; i < answer.length; i++)
			sb.append(answer[i] + " ");
		System.out.println(sb);
	}

	/**
	 * start부터 시작하여 DFS 탐색을 수행하였을 때, 사이클을 이룰 수 있는지 구하는 메소드
	 * start 바로 다음 역에는 start에 대한 정보를 포함하고 있기 때문에
	 * before변수를 두어 이전 역과 다르면서 start역을 만났는지 확인한다.
	 * @param start 처음 시작 역
	 * @param cur 현재 역
	 * @param before 이전 역
	 * @return 사이클을 이룬다면 true, 아니라면 false
	 */
	public static boolean isCycle(int start, int cur, int before) {
		visited[cur] = true;
		for (int next : hash[cur]) {
			// 이전 역과 start가 같지 않으면서 다음 역이 start인 경우 사이클을 이룬다.
			if (before != start && next == start)
				return true;
			else if (visited[next])
				continue;
			// 사이클을 이루었다면 그대로 return한다.
			if (isCycle(start, next, cur))
				return true;
		}
		// 순환선이 아닌 부분은 false로 바꾸어주며 반환하여
		// 순환선 부분만 true를 형성하도록 한다.
		return visited[cur] = false;
	}

	/**
	 * start역에서 순환선까지의 거리를 구하는 메소드
	 * 너비 우선 탐색을 통해 탐색한다.
	 * @param start 시작 역
	 * @return start역부터 순환선까지의 거리
	 */
	public static int BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] bfsVisited = new boolean[answer.length];
		int count = 0;
		q.add(start);
		bfsVisited[start] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int cur = q.poll();
				// 순환선과 만나면 거리를 반환한다.
				if (visited[cur])
					return count;
				for (int next : hash[cur]) {
					if (bfsVisited[next])
						continue;
					bfsVisited[next] = true;
					q.add(next);
				}
			}
			count++;
		}
		return 0;
	}
}
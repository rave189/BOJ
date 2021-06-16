package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 각 도시의 연결 정보가 주어지고 여행 계획이 주어졌을 때
 * 여행 계획대로 할 수 있는지 구하는 문제
 * 도시는 여러 번 방문해도 된다.
 * @author Rave
 *
 */
public class Main {

	static HashSet<Integer>[] hash;

	/**
	 * 입력이 작아 직접 다 찾아도 가능하다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		hash = new HashSet[n];
		for (int i = 0; i < n; i++)
			hash[i] = new HashSet<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 1인 경우만 hash에 넣는다.
			for (int j = 0; j < n; j++)
				if (Integer.parseInt(st.nextToken()) == 1)
					hash[i].add(j);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;
		while (--m > 0) {
			int next = Integer.parseInt(st.nextToken()) - 1;
			// 다음 도시가 start와 같은 경우 넘어간다.
			if (start == next)
				continue;
			// 아닌 경우 도달할 수 있는지 확인한다.
			if (!isReach(start, next)) {
				System.out.println("NO");
				return;
			}
			start = next;
		}
		System.out.println("YES");
	}

	/**
	 * start에서 end까지 도달할 수 있는지 구하는 메소드
	 * @param start 시작 도시
	 * @param end 도착 도시
	 * @return end에 도착할 수 있다면 true, 아니라면 false
	 */
	public static boolean isReach(int start, int end) {
		boolean[] visited = new boolean[hash.length];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : hash[cur]) {
				if (next == end)
					return true;
				if (visited[next])
					continue;
				q.add(next);
				visited[next] = true;
			}
		}
		return false;
	}
}
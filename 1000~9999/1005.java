package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 건물과 건물을 짓는데 걸리는 시간이 주어진다.
 * 각 건물은 선행 관계가 있어서 선행 건물을 지어야 후행 건물을 지을 수 있다.
 * 게임을 승리하기위해서는 특정 건물을 빨리 지어야 한다.
 * 특정 건물을 짓는데 걸리는 최소 시간을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[] time, degree, totalTime;
	static List<Integer>[] map;

	/**
	 * 위상정렬 문제
	 * dfs가 좀 더 빠른 것 같음
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			time = new int[n];
			degree = new int[n];
			totalTime = new int[n];
			map = new List[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				time[i] = Integer.parseInt(st.nextToken());
				map[i] = new ArrayList<>();
			}
			while (k-- > 0) {
				st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken()) - 1;
				int second = Integer.parseInt(st.nextToken()) - 1;
				degree[second]++;
				map[first].add(second);
			}
			int goal = Integer.parseInt(br.readLine()) - 1;
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < n; i++)
				if (degree[i] == 0)
					q.add(i);
			while (!q.isEmpty()) {
				int cur = q.poll();
				totalTime[cur] += time[cur];
				if (cur == goal)
					break;
				for (int next : map[cur]) {
					if (--degree[next] == 0)
						q.add(next);
					totalTime[next] = Math.max(totalTime[next], totalTime[cur]);
				}
			}
			answer.append(totalTime[goal]).append('\n');
		}
		System.out.print(answer);
	}
}
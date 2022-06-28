package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * �ǹ��� �ǹ��� ���µ� �ɸ��� �ð��� �־�����.
 * �� �ǹ��� ���� ���谡 �־ ���� �ǹ��� ����� ���� �ǹ��� ���� �� �ִ�.
 * ������ �¸��ϱ����ؼ��� Ư�� �ǹ��� ���� ����� �Ѵ�.
 * Ư�� �ǹ��� ���µ� �ɸ��� �ּ� �ð��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int[] time, degree, totalTime;
	static List<Integer>[] map;

	/**
	 * �������� ����
	 * dfs�� �� �� ���� �� ����
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
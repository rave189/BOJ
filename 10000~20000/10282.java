package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * n개의 컴퓨터가 있다.
 * 이 중 한 컴퓨터가 해킹당하여 이 컴퓨터를 의존하는 다른 컴퓨터도 전염되기 시작한다.
 * 이 때, 감염된 컴퓨터의 총 개수와 마지막 컴퓨터가 감염되기까지 걸리는 시간을 구하는 문제
 * a컴퓨터가 감염되었다면 s초 후 b컴퓨터도 감염된다.
 * @author Rave
 *
 */
public class Main {

	static List<Computer>[] relation;
	static int[] visit;
	static int INF = Integer.MAX_VALUE;

	/**
	 * 음수 간선이 없고 가중치가 다르므로 BFS가 아니라 다익스트라를 사용해야 한다.
	 * 다익스트라를 사용하여 연결된 모든 컴퓨터까지의 최단 거리를 구하고 그 중 가장 높은 값을 출력한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			relation = new ArrayList[n + 1];
			visit = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				relation[i] = new ArrayList<>();
				visit[i] = INF;
			}
			while (d-- > 0) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				relation[b].add(new Computer(a, s));
			}
			BFS(c);
			int count = 0, time = 0;
			for (int i = 1; i <= n; i++) {
				if (visit[i] == INF)
					continue;
				count++;
				time = Math.max(visit[i], time);
			}
			answer.append(count + " " + time).append('\n');
		}
		System.out.println(answer);
	}

	public static void BFS(int start) {
		PriorityQueue<Computer> pq = new PriorityQueue<>();
		pq.add(new Computer(start, 0));
		visit[start] = 0;
		while (!pq.isEmpty()) {
			int size = pq.size();
			while (size-- > 0) {
				Computer cur = pq.poll();
				for (Computer next : relation[cur.point]) {
					int time = cur.time + next.time;
					if (time < visit[next.point]) {
						visit[next.point] = time;
						pq.add(new Computer(next.point, time));
					}
				}
			}
		}
	}
}

class Computer implements Comparable<Computer> {
	int point, time;

	public Computer(int next, int time) {
		this.point = next;
		this.time = time;
	}

	@Override
	public int compareTo(Computer o) {
		return time - o.time;
	}
}
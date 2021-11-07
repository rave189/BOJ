package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * n���� ��ǻ�Ͱ� �ִ�.
 * �� �� �� ��ǻ�Ͱ� ��ŷ���Ͽ� �� ��ǻ�͸� �����ϴ� �ٸ� ��ǻ�͵� �����Ǳ� �����Ѵ�.
 * �� ��, ������ ��ǻ���� �� ������ ������ ��ǻ�Ͱ� �����Ǳ���� �ɸ��� �ð��� ���ϴ� ����
 * a��ǻ�Ͱ� �����Ǿ��ٸ� s�� �� b��ǻ�͵� �����ȴ�.
 * @author Rave
 *
 */
public class Main {

	static List<Computer>[] relation;
	static int[] visit;
	static int INF = Integer.MAX_VALUE;

	/**
	 * ���� ������ ���� ����ġ�� �ٸ��Ƿ� BFS�� �ƴ϶� ���ͽ�Ʈ�� ����ؾ� �Ѵ�.
	 * ���ͽ�Ʈ�� ����Ͽ� ����� ��� ��ǻ�ͱ����� �ִ� �Ÿ��� ���ϰ� �� �� ���� ���� ���� ����Ѵ�.
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
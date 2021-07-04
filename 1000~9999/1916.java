package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * N���� ���ð� �ִ�.
 * �� ���ÿ��� ����Ͽ� �ٸ� ���ÿ� �����ϴ� M���� ������ �ִ�.
 * A���ÿ��� B���ñ��� ���µ� ��� ���� ����� �ּ�ȭ ��Ű���� �Ѵ�.
 * �ּ� ����� ���ϴ� ����
 * ������ �ܹ����̴�.
 * �׸��� ������ �ִ� ��츸 �Է����� �־�����.
 * @author Rave
 *
 */
public class Main {

	static int[] answer;
	// i������ Bus�� �����ϴ� ���ÿ� ����� �����Ѵ�.
	static HashSet<Bus>[] routes;
	// �⺻ ���� �����صд�.
	static int INF = 100000001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		answer = new int[n + 1];
		routes = new HashSet[n + 1];
		for (int i = 1; i <= n; i++) {
			answer[i] = INF;
			routes[i] = new HashSet<>();
		}
		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int busStart = Integer.parseInt(st.nextToken());
			int busEnd = Integer.parseInt(st.nextToken());
			int busCost = Integer.parseInt(st.nextToken());
			routes[busStart].add(new Bus(busEnd, busCost));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		Diijkstra(start);
		System.out.println(answer[end]);
	}

	/**
	 * ������ ���õ��� Ž���ϸ� �� ���� ����� ��� ��θ� answer�� �����Ѵ�.
	 * Ž���� �ʺ� �켱 Ž���� �̿��Ͽ� �����Ѵ�.
	 */
	public static void Diijkstra(int start) {
		answer[start] = 0;
		Queue<Bus> q = new LinkedList<>();
		q.add(new Bus(start, 0));
		while (!q.isEmpty()) {
			Bus cur = q.poll();
			for (Bus next : routes[cur.end]) {
				int nextCost = cur.cost + next.cost;
				if (nextCost < answer[next.end]) {
					answer[next.end] = nextCost;
					q.add(new Bus(next.end, nextCost));
				}
			}
		}
	}
}

class Bus {
	int end, cost;

	public Bus(int _end, int _cost) {
		this.end = _end;
		this.cost = _cost;
	}
}
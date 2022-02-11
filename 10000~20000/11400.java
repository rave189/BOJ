package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * �׷����� �־�����.
 * �׷������� �������� ������ �������� ���� ������ �� �پ� ��� ����ϴ� ����
 * ���� ������ �� ���� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	static HashSet<Integer>[] map;
	static int[] order;
	static int orderCnt = 1;
	static PriorityQueue<Line> pq = new PriorityQueue<>();

	/**
	 * �������� �ſ� ������ ����
	 * ������ó�� ��Ʈ���� �ƴ����� ����� ����.
	 * ��� ������ ������ �������� �ٽ� ���� �����鼭 ���� ������ �湮 ������ ���� �湮 �������� ū ��� �������̴�.
	 * �� ���������� x < y�� �������� ���϶�� �����Ƿ� y < x�� �Ųٷ��ؼ� �־��ش�.
	 * 
	 * ���� �� �Ȱ����� x < y�� ��츸 ������ y < x�� �־����� �� �˰� ó�������� �ʾҴٰ� Ʋ�ȴ�.
	 * prev ����, ������ ������ �������� �ٽ� �Ȱ��� continue�� �־���µ�...
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new HashSet[n + 1];
		order = new int[n + 1];
		for (int i = 0; i <= n; i++)
			map[i] = new HashSet<>();
		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			map[first].add(second);
			map[second].add(first);
		}
		for (int i = 1; i <= n; i++) {
			if (order[i] == 0)
				dfs(-1, 1);
		}
		System.out.println(pq.size());
		while (!pq.isEmpty()) {
			Line cur = pq.poll();
			answer.append(cur.x).append(' ').append(cur.y).append('\n');
		}
		System.out.println(answer);
	}

	public static int dfs(int prev, int cur) {
		order[cur] = orderCnt;
		int rtn = orderCnt++;
		for (int next : map[cur]) {
			if (prev == next)
				continue;
			if (order[next] == 0) {
				int low = dfs(cur, next);
				if (low > order[cur]) {
					if (cur < next)
						pq.add(new Line(cur, next));
					else
						pq.add(new Line(next, cur));
				}
				rtn = Math.min(rtn, low);
			} else
				rtn = Math.min(rtn, order[next]);
		}
		return rtn;
	}
}

class Line implements Comparable<Line> {
	int x, y;

	public Line(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Line o) {
		if (x < o.x)
			return -1;
		else if (x == o.x)
			return y - o.y;
		return 1;
	}
}
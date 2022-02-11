package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 그래프가 주어진다.
 * 그래프에서 단절선의 개수와 단절선을 사전 순으로 한 줄씩 모두 출력하는 문제
 * 같은 간선은 한 번만 출력한다.
 * @author Rave
 *
 */
public class Main {

	static HashSet<Integer>[] map;
	static int[] order;
	static int orderCnt = 1;
	static PriorityQueue<Line> pq = new PriorityQueue<>();

	/**
	 * 단절점과 매우 유사한 문제
	 * 단절점처럼 루트인지 아닌지는 상관이 없다.
	 * 대신 이전에 지나온 간선으로 다시 가지 않으면서 이후 정점의 방문 순서가 현재 방문 순서보다 큰 경우 단절선이다.
	 * 이 문제에서는 x < y인 단절선만 구하라고 했으므로 y < x는 거꾸로해서 넣어준다.
	 * 
	 * 거의 다 똑같은데 x < y인 경우만 넣으면 y < x도 넣어지는 줄 알고 처리해주지 않았다가 틀렸다.
	 * prev 쓰고, 이전에 지나온 간선으로 다시 안가게 continue도 넣어줬는데...
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
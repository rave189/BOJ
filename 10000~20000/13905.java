package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * N���� ���� �� ���� �����ϴ� �ٸ��� �ִ�.
 * ���̴� ��� ������ �����̰� �����ϴ� ������ ���� �ִ��� ���� ���������� �Ѵ�.
 * ������ ��, �������� ��ġ, �ٸ��� �������� �־��� �� ������ �� �ִ� ���� �ִ� ������ ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int n;
	static int s;
	static int e;
	static boolean[] visited;
	// �ٸ��� ����
	static ArrayList<Bridge>[] map;

	/**
	 * �߷����Ѱ� ���� �����̴�.
	 * �ű� �� �ִ� �ּ����� ���Ը� mid�� ������ �� mid���� ū ���������� ���� �ٸ����� �ǳʺ���.
	 * �ǳ� �� �ִٸ� ���� �ִ����� Ȯ���Ѵ�.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		map = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			map[i] = new ArrayList<>();
		int left = 0, right = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			map[first].add(new Bridge(second, weight));
			map[second].add(new Bridge(first, weight));
			right = Math.max(right, weight);
		}
		int answer = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			boolean isMove = BFS(mid);
			if (isMove) {
				left = mid + 1;
				answer = Math.max(answer, mid);
			} else
				right = mid - 1;
		}
		System.out.println(answer);
	}

	/**
	 * ������ ��ġ s���� �������� ��ġ e���� ������ �� �ִ��� Ȯ���ϴ� �޼ҵ�
	 * Ž���� BFS�� Ž���Ѵ�.
	 * @param minWeight ���� ������ �ּ� ����
	 * @return �������� ��ġ�� ������ �� �ִٸ� true, �ƴ϶�� false
	 */
	public static boolean BFS(int minWeight) {
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[n + 1];
		q.add(s);
		visited[s] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == e)
				return true;
			for (Bridge next : map[cur]) {
				// �̹� �湮�߰ų� �ٸ��� ���������� minWeight���� ���� ��� �ǳʶڴ�.
				if (visited[next.island] || next.weight < minWeight)
					continue;
				visited[next.island] = true;
				q.add(next.island);
			}
		}
		return false;
	}
}

class Bridge {
	int island, weight;

	public Bridge(int _island, int _weight) {
		this.island = _island;
		this.weight = _weight;
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * N���� ������ �̷���� ���� �ִ�.
 * �� ����� ������ �ٸ��� �־� �ٸ��� �̿��Ͽ� ������ �ű��.
 * ������ �ٸ��� �߷� ������ �־� ������ ������� �ű��� ���Ѵ�.
 * �ٸ��� ����Ǿ� �ִ� ���� ������ �־�����, �� ���� �־��� ��,
 * �� �� ���̿� �� ���� �̵����� �ű� �� �ִ� ������ �ִ� �߷��� ���ϴ� ����
 * �ٸ��� ��� ������̴�.
 * @author Rave
 *
 */
public class Main {

	static ArrayList<Island>[] map;
	static int n;
	static int start;
	static int end;
	static boolean[] visited;

	/**
	 * �̺� Ž���� ���� minWeight�� �����Ѵ�.
	 * minWeight���� �߷��� ū �ٸ����� �̵� �Ͽ��� �� �� �� ���̸� �̵��� �� �ִ��� Ȯ���Ѵ�.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			map[i] = new ArrayList<>();
		int left = 0, right = 0;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			map[first].add(new Island(second, weight));
			map[second].add(new Island(first, weight));
			right = Math.max(right, weight);
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		while (left <= right) {
			// minWeight�� �����Ѵ�.
			int mid = (left + right) / 2;
			// �� �� ���̸� �̵��� �� �ִ��� Ȯ���Ѵ�.
			boolean isMove = BFS(mid);
			// �̵��� �� �ִٸ� minWeight�� ��������.
			if (isMove)
				left = mid + 1;
			// �ƴ϶�� minWeight�� ���纻��.
			else
				right = mid - 1;
		}
		System.out.println(left - 1);
	}

	/**
	 * minWeight���� ���� �߷��� �ߵ� �� �ִ� �ٸ����� �ǳ� �� �� ���̸� �̵��� �� �ִ��� Ȯ���ϴ� �޼ҵ�
	 * 
	 * @param minWeight �ּ� �߷�
	 * @return �� �� ���̸� �̵��� �� �ִٸ� true, �ƴ϶�� false
	 */
	public static boolean BFS(int minWeight) {
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[n + 1];
		q.add(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == end)
				return true;
			for (Island next : map[cur]) {
				if (next.weight < minWeight || visited[next.island])
					continue;
				visited[next.island] = true;
				q.add(next.island);
			}
		}
		return false;
	}
}

class Island {
	int island, weight;

	public Island(int _island, int _weight) {
		this.island = _island;
		this.weight = _weight;
	}
}
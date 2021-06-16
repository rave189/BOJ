package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * �� ������ ���� ������ �־����� ���� ��ȹ�� �־����� ��
 * ���� ��ȹ��� �� �� �ִ��� ���ϴ� ����
 * ���ô� ���� �� �湮�ص� �ȴ�.
 * @author Rave
 *
 */
public class Main {

	static HashSet<Integer>[] hash;

	/**
	 * �Է��� �۾� ���� �� ã�Ƶ� �����ϴ�.
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
			// 1�� ��츸 hash�� �ִ´�.
			for (int j = 0; j < n; j++)
				if (Integer.parseInt(st.nextToken()) == 1)
					hash[i].add(j);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;
		while (--m > 0) {
			int next = Integer.parseInt(st.nextToken()) - 1;
			// ���� ���ð� start�� ���� ��� �Ѿ��.
			if (start == next)
				continue;
			// �ƴ� ��� ������ �� �ִ��� Ȯ���Ѵ�.
			if (!isReach(start, next)) {
				System.out.println("NO");
				return;
			}
			start = next;
		}
		System.out.println("YES");
	}

	/**
	 * start���� end���� ������ �� �ִ��� ���ϴ� �޼ҵ�
	 * @param start ���� ����
	 * @param end ���� ����
	 * @return end�� ������ �� �ִٸ� true, �ƴ϶�� false
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
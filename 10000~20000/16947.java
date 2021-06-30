package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * ���� ����ö 2ȣ���� 1���� ��ȯ���� 2���� �������� �̷���� �ִ�.
 * �� ��, �� ����� ��ȯ�� ������ �Ÿ��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static HashSet<Integer>[] hash;
	static boolean[] visited;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		hash = new HashSet[n + 1];
		answer = new int[n + 1];
		for (int i = 1; i <= n; i++)
			hash[i] = new HashSet<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			hash[first].add(second);
			hash[second].add(first);
		}
		// ��ȯ���� ã�´�.
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			if (isCycle(i, i, -1))
				break;
		}
		// �� ����� ��ȯ�� ������ �Ÿ��� ���Ѵ�.
		for (int i = 1; i <= n; i++) {
			if (visited[i])
				continue;
			answer[i] = BFS(i);
		}
		for (int i = 1; i < answer.length; i++)
			sb.append(answer[i] + " ");
		System.out.println(sb);
	}

	/**
	 * start���� �����Ͽ� DFS Ž���� �����Ͽ��� ��, ����Ŭ�� �̷� �� �ִ��� ���ϴ� �޼ҵ�
	 * start �ٷ� ���� ������ start�� ���� ������ �����ϰ� �ֱ� ������
	 * before������ �ξ� ���� ���� �ٸ��鼭 start���� �������� Ȯ���Ѵ�.
	 * @param start ó�� ���� ��
	 * @param cur ���� ��
	 * @param before ���� ��
	 * @return ����Ŭ�� �̷�ٸ� true, �ƴ϶�� false
	 */
	public static boolean isCycle(int start, int cur, int before) {
		visited[cur] = true;
		for (int next : hash[cur]) {
			// ���� ���� start�� ���� �����鼭 ���� ���� start�� ��� ����Ŭ�� �̷��.
			if (before != start && next == start)
				return true;
			else if (visited[next])
				continue;
			// ����Ŭ�� �̷���ٸ� �״�� return�Ѵ�.
			if (isCycle(start, next, cur))
				return true;
		}
		// ��ȯ���� �ƴ� �κ��� false�� �ٲپ��ָ� ��ȯ�Ͽ�
		// ��ȯ�� �κи� true�� �����ϵ��� �Ѵ�.
		return visited[cur] = false;
	}

	/**
	 * start������ ��ȯ�������� �Ÿ��� ���ϴ� �޼ҵ�
	 * �ʺ� �켱 Ž���� ���� Ž���Ѵ�.
	 * @param start ���� ��
	 * @return start������ ��ȯ�������� �Ÿ�
	 */
	public static int BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] bfsVisited = new boolean[answer.length];
		int count = 0;
		q.add(start);
		bfsVisited[start] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int cur = q.poll();
				// ��ȯ���� ������ �Ÿ��� ��ȯ�Ѵ�.
				if (visited[cur])
					return count;
				for (int next : hash[cur]) {
					if (bfsVisited[next])
						continue;
					bfsVisited[next] = true;
					q.add(next);
				}
			}
			count++;
		}
		return 0;
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * �׷����� �־��� ��, �������� ������ �������� ������ ��ȣ�� ����ϴ� ����
 * �׷����� ���� �׷����� �ƴ� ���� �ִ�.
 * @author Rave
 *
 */
public class Main {

	static HashSet<Integer>[] map;
	static int[] order;
	static int orderCnt = 1;
	static boolean[] isCutNode;

	/**
	 * ����
	 * ���� ������ ���
	 * - �ڽ� Ʈ���� ������ 2�� �̻��̸� ������, �ƴ϶�� �������� �ƴϴ�.
	 * ���� ������ �ƴ� ���
	 * - �ڽ��� ���� �湮 ������ �߿��� �ڽ��� ��ġ�� �ʰ� �ڽź��� Ž�� ������ �ռ� ������ �湮�� �� ���ٸ� ������
	 * (��ȸ ��ΰ� �����Ѵٸ� �� ���� ������ ������ ��ȯ�ؾ� �Ѵ�.)
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new HashSet[n + 1];
		order = new int[n + 1];
		isCutNode = new boolean[n + 1];
		for (int i = 0; i <= n; i++)
			map[i] = new HashSet<>();
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			map[first].add(second);
			map[second].add(first);
		}

		for (int i = 1; i <= n; i++)
			if (order[i] == 0)
				dfs(i, true);
		int count = 0;
		for (int i = 1; i <= n; i++)
			if (isCutNode[i]) {
				count++;
				answer.append(i).append(' ');
			}
		System.out.println(count);
		System.out.print(answer);
	}

	public static int dfs(int cur, boolean isRoot) {
		order[cur] = orderCnt;
		int rtn = orderCnt++;
		int child = 0;
		for (int next : map[cur]) {
			if (order[next] == 0) {
				child++;
				int low = dfs(next, false);
				// ���� ������ �ƴϸ鼭 cur���� �湮 ������ ũ�ٸ� ������
				if (!isRoot && low >= order[cur])
					isCutNode[cur] = true;
				rtn = Math.min(rtn, low);
			} else
				rtn = Math.min(rtn, order[next]);
		}
		// ù ��͸� �ش�
		// ���� ������ ��� �ڽ� Ʈ���� �� �� �̻��̶�� ������
		if (isRoot && child >= 2)
			isCutNode[cur] = true;
		return rtn;
	}
}
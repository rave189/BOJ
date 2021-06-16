package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * {0}, {1} ... {N}�� ���� N+1�� ������ �̷�� �ִ�.
 * ���� M���� ��ɿ� ���� ������ ���� �۾��� �����Ѵ�.
 * 0 a b�� a�� ���� ���հ� b�� ���� ������ ���� �������� �̷絵�� �Ѵ�.
 * 1 a b�� a�� b�� ���� ���տ� �����ִ��� Ȯ���Ѵ�.
 * 1�� ��ɿ� ���ؼ� ����� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	static int[] unionFind;

	/**
	 * unionFind�� ���� �������� ǥ���ϰ� ���� �������� ���Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		unionFind = new int[n + 1];
		// unionFind �ʱ�ȭ
		for (int i = 1; i < unionFind.length; i++)
			unionFind[i] = i;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			// first�� second�� ��Ʈ ��带 ã�´�.
			int firstParent = find(first);
			int secondParent = find(second);
			// ������ ��Ʈ��带 �ٸ� ������ �����Ѵ�.
			if (command == 0)
				unionFind[firstParent] = unionFind[secondParent];
			// command�� 1�� ���
			// �� ��Ʈ ����� ���� ���ٸ� ���� �����̰�, �ƴ϶�� �ٸ� �����̴�.
			else
				sb.append(firstParent == secondParent ? "YES\n" : "NO\n");
		}
		System.out.println(sb);
	}

	/**
	 * unionFind�� ��Ʈ ��带 ã�� �޼ҵ�
	 * @param cur ���� ���
	 * @return ��Ʈ ���
	 */
	public static int find(int cur) {
		// cur�� unionFind[cur]�� ���ٸ� ��Ʈ ����̴�.
		if (cur == unionFind[cur])
			return cur;
		// �ƴ϶�� unionFind[cur]�� ������Ʈ ���ָ� ��� ȣ���� �����Ѵ�.
		return unionFind[cur] = find(unionFind[cur]);
	}
}
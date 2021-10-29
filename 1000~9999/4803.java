package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Ʈ���z ����Ŭ�� ���� ���� ����̴�.
 * �׷����� �־����� ��, Ʈ���� ������ ���ϴ� ����
 */
public class Main {

	static boolean[][] tree;
	static int[] unionFind;
	static boolean[] isCycle;

	/**
	 * �Է��� �־��� ������ ���Ͽ� ���ε带 ����Ͽ� ��Ʈ ��带 Ž���Ѵ�.
	 * ���� �� ��Ʈ ��带 �̾�� �Ѵٸ� ����Ŭ�� �����Ǵ� ���̹Ƿ� isCycle�� true�� ������ش�.
	 * �Է��� ����Ǹ� isCycle�� ���� false�� Ʈ���� ������ ����.
	 * ���� Ʈ���� �����ؼ� ���� �ȵǹǷ� �� �� �� Ʈ���� isCycle�� true�� �ٲپ� ���� �ʵ��� �Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int caseNumber = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if (n == 0 && m == 0)
				break;
			tree = new boolean[n][n];
			unionFind = new int[n];
			isCycle = new boolean[n];
			for (int i = 1; i < unionFind.length; i++)
				unionFind[i] = i;
			while (m-- > 0) {
				st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken()) - 1;
				int second = Integer.parseInt(st.nextToken()) - 1;
				int firstParent = find(first);
				int secondParent = find(second);
				// �� Ʈ���� �������� �ϸ� isCycle�� true��
				if (unionFind[firstParent] == unionFind[secondParent])
					isCycle[firstParent] = true;
				else
					unionFind[firstParent] = unionFind[secondParent];
			}
			int count = 0;
			for (int i = 0; i < isCycle.length; i++) {
				int parent = find(i);
				if (!isCycle[parent]) {
					isCycle[parent] = true;
					count++;
				}
			}
			answer.append("Case " + caseNumber++ + ": ");
			if (count == 0)
				answer.append("No trees.");
			else if (count == 1)
				answer.append("There is one tree.");
			else
				answer.append("A forest of " + count + " trees.");
			answer.append('\n');
		}
		System.out.println(answer);
	}

	public static int find(int cur) {
		if (cur == unionFind[cur])
			return cur;
		unionFind[cur] = find(unionFind[cur]);
		if (isCycle[cur] || isCycle[unionFind[cur]]) {
			isCycle[cur] = true;
			isCycle[unionFind[cur]] = true;
		}
		return unionFind[cur];
	}
}
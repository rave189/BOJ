package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N���� ���� �� �� ������ ���Ը� ���ϴ� ���� M���� �Ѵ�.
 * ���Ը� ��� ���� �߰� �߰� �������� A�� B�� ���� ���� ������ �����.
 * ���� ���Ը� ���ߴٸ� ����ϰ�, ������ �ʾҴٸ� ������� ���Ѵ�.
 * �����Կ��� �� �� �ִ� ����� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int[] unionFind;
	static int[] weightDiff;

	/**
	 * ���Ͽ� ���ε带 ����Ͽ� ������ Ǯ �� �ִ�.
	 * ���Ը� ���� ���õ��� ���� �׷� ���� �����ϵ��� �Ѵ�.
	 * ���� ������ ������ ��Ʈ�� �ΰ�, �������鼭 ��Ʈ���� �������� �����Ѵ�.
	 * 
	 * ���� ���� �����Ѵٴ� ������ �����, ���̸� �����ϴ� ����� �� ���ذ� ���� �ʴ´�.
	 * �ٽ� �����غ���� �ϸ� ���� ���� ��...
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if (n == 0 && m == 0)
				break;
			unionFind = new int[n];
			weightDiff = new int[n];
			for (int i = 1; i < n; i++)
				unionFind[i] = i;
			while (m-- > 0) {
				st = new StringTokenizer(br.readLine());
				char command = st.nextToken().charAt(0);
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				if (command == '!') {
					int diff = Integer.parseInt(st.nextToken());
					union(a, b, diff);
				} else {
					if (find(a) == find(b))
						answer.append(weightDiff[b] - weightDiff[a]);
					else
						answer.append("UNKNOWN");
					answer.append('\n');
				}
			}
		}
		System.out.println(answer);
	}

	public static void union(int a, int b, int diff) {
		int parentA = find(a);
		int parentB = find(b);
		if (parentA == parentB)
			return;
		weightDiff[parentB] = weightDiff[a] - weightDiff[b] + diff;
		unionFind[parentB] = parentA;
	}

	public static int find(int n) {
		if (n == unionFind[n])
			return n;
		int parent = find(unionFind[n]);
		weightDiff[n] += weightDiff[unionFind[n]];
		return unionFind[n] = parent;
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * N���� ���ÿ� N-1���� ���ΰ� �ִ�.
 * ��� ���� �ֿ��� �� ���ø� �����ϴ� ������ ��ΰ� �ִ�.
 * K���� ���� ���� �־��� ��, �� ���ø� �����ϴ� ��� �󿡼� ���� ª�� ���ο� �� ���θ� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	// Ʈ���� �ִ� ���� ���ϱ�
	static int logN = 1, minAns, maxAns;
	// �ڽ��� 2^n��° �θ���� �����ϰ�, �׶��� ������ �ּڰ��� �ִ��� �����Ѵ�.
	static int[][] sparseTable, minTable, maxTable;
	// �� ������ ���̸� �����Ѵ�.
	static int[] depth;
	// ������ ���� ���¸� �����Ѵ�.
	static HashSet<Node>[] map;

	/**
	 * �� ���� ������ LCA�� ���Ѵ�.
	 * ���ϴ� ���߿� ���� ���� ���ο� ���� ū ���θ� ���� �����صξ� ���� ���� �ּڰ��� �ִ��� ����Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int s = 1; s < n; s *= 2)
			logN++;
		sparseTable = new int[logN + 1][n + 1];
		minTable = new int[logN + 1][n + 1];
		maxTable = new int[logN + 1][n + 1];
		depth = new int[n + 1];
		map = new HashSet[n + 1];
		for (int i = 0; i <= n; i++)
			map[i] = new HashSet<>();
		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			map[first].add(new Node(second, weight));
			map[second].add(new Node(first, weight));
		}
		makeDepth(1);
		makeSparseTable();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			minAns = 1000001;
			maxAns = 0;
			getLCA(first, second);
			answer.append(minAns).append(' ').append(maxAns).append('\n');
		}
		System.out.print(answer);
	}

	/**
	 * ���̴� ���� Ž���Ͽ� ���Ѵ�.
	 * Ž���ϸ鼭 �ڽ��� �θ��� ������ ª�� ����, �� ������ ������ �߰����ش�.
	 * @param start ���� ����
	 */
	public static void makeDepth(int start) {
		Queue<Integer> q = new LinkedList<>();
		depth[start] = 1;
		q.add(start);
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (Node next : map[cur]) {
				if (depth[next.point] != 0)
					continue;
				depth[next.point] = depth[cur] + 1;
				sparseTable[0][next.point] = cur;
				minTable[0][next.point] = next.weight;
				maxTable[0][next.point] = next.weight;
				q.add(next.point);
			}
		}
	}

	/**
	 * 2^n��° �θ��� ������ �߰����ش�.
	 * 0���� makeDepth���� ���س�.
	 */
	public static void makeSparseTable() {
		for (int i = 1; i <= logN; i++) {
			for (int j = 1; j < sparseTable[i].length; j++) {
				sparseTable[i][j] = sparseTable[i - 1][sparseTable[i - 1][j]];
				minTable[i][j] = Math.min(minTable[i - 1][j], minTable[i - 1][sparseTable[i - 1][j]]);
				maxTable[i][j] = Math.max(maxTable[i - 1][j], maxTable[i - 1][sparseTable[i - 1][j]]);
			}
		}
	}

	public static void getLCA(int a, int b) {
		// a�� �� ��ٰ� ����
		if (depth[a] < depth[b]) {
			getLCA(b, a);
			return;
		}
		// ���̰� ������ ������ (and ������ 0�� ������) a�� �÷�����.
		// a�� �ø��鼭 ������ �ּڰ�, �ִ񰪵� ������Ʈ ���ش�.
		for (int i = 0; i <= logN; i++) {
			if (((depth[a] - depth[b]) & (1 << i)) >= 1) {
				minAns = Math.min(minAns, minTable[i][a]);
				maxAns = Math.max(maxAns, maxTable[i][a]);
				a = sparseTable[i][a];
			}
		}
		// ������ ����
		if (a == b)
			return;
		// ���� �� ������ �����Ͽ� �� ��带 �÷�����.
		for (int i = logN; i >= 0; i--) {
			if (sparseTable[i][a] == sparseTable[i][b])
				continue;
			minAns = Math.min(minAns, Math.min(minTable[i][a], minTable[i][b]));
			maxAns = Math.max(maxAns, Math.max(maxTable[i][a], maxTable[i][b]));
			a = sparseTable[i][a];
			b = sparseTable[i][b];
		}
		// lca �ٷ� ������ ��忡�� ���߹Ƿ� �� �� �����ش�.
		minAns = Math.min(minAns, Math.min(minTable[0][a], minTable[0][b]));
		maxAns = Math.max(maxAns, Math.max(maxTable[0][a], maxTable[0][b]));
	}
}

class Node {
	int point, weight;

	public Node(int point, int weight) {
		this.point = point;
		this.weight = weight;
	}
}
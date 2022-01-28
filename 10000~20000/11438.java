package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * N���� �������� �̷���� Ʈ���� �־�����, M���� ���ǰ� �־�����.
 * �� ���Ǹ��� �ּ� ���� ������ �˰���� �� ������ ��ȣ�� �־�����.
 * �� ������ �ּ� ���� ������ ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static List<Integer>[] map;
	static int[] depth;
	static int[][] sparseTable;
	static int logN;

	/**
	 * LCA ���ϱ� ����
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		map = new List[n + 1];
		depth = new int[n + 1];
		for (int i = 1; i <= n; i++)
			map[i] = new ArrayList<>();
		logN = 0;
		for (int i = 1; i < n; i *= 2)
			logN++;
		sparseTable = new int[logN + 1][n + 1];
		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a].add(b);
			map[b].add(a);
		}
		makeDepth(1);
		makeSparseTable();
		int m = Integer.parseInt(br.readLine());
		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			answer.append(getLCA(a, b)).append('\n');
		}
		System.out.print(answer);
	}

	/**
	 * �� ������ ���̸� ���ϴ� �޼ҵ�
	 * �� ���� a�� b�� ���̸� ���� ���̷� ���߱� ���� ���
	 * Ž���ϴ� �迡 �� ������ �θ� ������ sparseTable�� �����صд�.
	 * @param start ���� ����
	 */
	public static void makeDepth(int start) {
		Queue<Integer> q = new LinkedList<>();
		depth[start] = 1;
		q.add(start);
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : map[cur]) {
				if (depth[next] == 0) {
					depth[next] = depth[cur] + 1;
					sparseTable[0][next] = cur;
					q.add(next);
				}
			}
		}
	}

	/**
	 * sparseTable�� ���ϴ� �޼ҵ�
	 */
	public static void makeSparseTable() {
		for (int i = 1; i < sparseTable.length; i++)
			for (int j = 1; j < sparseTable[i].length; j++)
				sparseTable[i][j] = sparseTable[i - 1][sparseTable[i - 1][j]];
	}

	/**
	 * LCA�� ���ϴ� ����
	 * @param a ����
	 * @param b ����
	 * @return LCA
	 */
	public static int getLCA(int a, int b) {
		// a�� �� ���ٰ� ����
		if (depth[a] < depth[b])
			return getLCA(b, a);
		// a�� b�� ���̰� ������ ������ a�� �ø���.
		for (int i = 0; i <= logN; i++)
			if (((depth[a] - depth[b]) & (1 << i)) > 0)
				a = sparseTable[i][a];
		// ������ �̸� ��ȯ
		if (a == b)
			return a;
		//�θ� ���������� �ö󰡺���.
		for (int i = logN; i >= 0; i--) {
			if (sparseTable[i][a] != sparseTable[i][b]) {
				a = sparseTable[i][a];
				b = sparseTable[i][b];
			}
		}
		// �θ� ���������� �ö󰡺������� �θ� ����Ѵ�.
		return sparseTable[0][a];
	}
}
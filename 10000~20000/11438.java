package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * N개의 정점으로 이루어진 트리가 주어지고, M개의 질의가 주어진다.
 * 각 질의마다 최소 공통 조상을 알고싶은 두 정점의 번호가 주어진다.
 * 두 정점의 최소 공통 조상을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static List<Integer>[] map;
	static int[] depth;
	static int[][] sparseTable;
	static int logN;

	/**
	 * LCA 구하기 문제
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
	 * 각 정점의 깊이를 구하는 메소드
	 * 두 정점 a와 b의 높이를 같은 높이로 맞추기 위해 사용
	 * 탐색하는 김에 각 정점의 부모 정점도 sparseTable에 저장해둔다.
	 * @param start 시작 정점
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
	 * sparseTable을 구하는 메소드
	 */
	public static void makeSparseTable() {
		for (int i = 1; i < sparseTable.length; i++)
			for (int j = 1; j < sparseTable[i].length; j++)
				sparseTable[i][j] = sparseTable[i - 1][sparseTable[i - 1][j]];
	}

	/**
	 * LCA를 구하는 문제
	 * @param a 정점
	 * @param b 정점
	 * @return LCA
	 */
	public static int getLCA(int a, int b) {
		// a가 더 높다고 가정
		if (depth[a] < depth[b])
			return getLCA(b, a);
		// a와 b의 높이가 같아질 때까지 a를 올린다.
		for (int i = 0; i <= logN; i++)
			if (((depth[a] - depth[b]) & (1 << i)) > 0)
				a = sparseTable[i][a];
		// 같으면 미리 반환
		if (a == b)
			return a;
		//부모가 같을때까지 올라가본다.
		for (int i = logN; i >= 0; i--) {
			if (sparseTable[i][a] != sparseTable[i][b]) {
				a = sparseTable[i][a];
				b = sparseTable[i][b];
			}
		}
		// 부모가 같을때까지 올라가보았으니 부모를 출력한다.
		return sparseTable[0][a];
	}
}
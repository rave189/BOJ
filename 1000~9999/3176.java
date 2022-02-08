package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * N개의 도시와 N-1개의 도로가 있다.
 * 모든 도시 쌍에는 그 도시를 연결하는 유일한 경로가 있다.
 * K개의 도시 쌍이 주어질 때, 두 도시를 연결하는 경로 상에서 가장 짧은 도로와 긴 도로를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	// 트리의 최대 깊이 구하기
	static int logN = 1, minAns, maxAns;
	// 자신의 2^n번째 부모들을 저장하고, 그때의 도로의 최솟값과 최댓값을 저장한다.
	static int[][] sparseTable, minTable, maxTable;
	// 각 도시의 깊이를 저장한다.
	static int[] depth;
	// 도시의 연결 상태를 저장한다.
	static HashSet<Node>[] map;

	/**
	 * 두 도시 사이의 LCA를 구한다.
	 * 구하는 도중에 가장 작은 도로와 가장 큰 도로를 따로 저장해두어 값들 중의 최솟값과 최댓값을 출력한다.
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
	 * 깊이는 직접 탐색하여 구한다.
	 * 탐색하면서 자신의 부모의 정보와 짧은 도로, 긴 도로의 정보도 추가해준다.
	 * @param start 시작 지점
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
	 * 2^n번째 부모의 정보를 추가해준다.
	 * 0번은 makeDepth에서 구해놈.
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
		// a가 더 깊다고 가정
		if (depth[a] < depth[b]) {
			getLCA(b, a);
			return;
		}
		// 높이가 같아질 때까지 (and 연산이 0일 때까지) a를 올려본다.
		// a를 올리면서 도로의 최솟값, 최댓값도 업데이트 해준다.
		for (int i = 0; i <= logN; i++) {
			if (((depth[a] - depth[b]) & (1 << i)) >= 1) {
				minAns = Math.min(minAns, minTable[i][a]);
				maxAns = Math.max(maxAns, maxTable[i][a]);
				a = sparseTable[i][a];
			}
		}
		// 같으면 종료
		if (a == b)
			return;
		// 가장 먼 노드부터 시작하여 두 노드를 올려본다.
		for (int i = logN; i >= 0; i--) {
			if (sparseTable[i][a] == sparseTable[i][b])
				continue;
			minAns = Math.min(minAns, Math.min(minTable[i][a], minTable[i][b]));
			maxAns = Math.max(maxAns, Math.max(maxTable[i][a], maxTable[i][b]));
			a = sparseTable[i][a];
			b = sparseTable[i][b];
		}
		// lca 바로 직전의 노드에서 멈추므로 한 번 더해준다.
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
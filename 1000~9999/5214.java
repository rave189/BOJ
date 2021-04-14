package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * �̷��� ���߱����� ������ Ʃ��� �� K���� ������ ���̴�.
 * 1�������� N�� ������ ���µ� �湮�ϴ� ���� �ּڰ��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	// i��° ������Ʃ�긦 �����Ѵ�.
	static HashMap<Integer, HashSet<Integer>> hash = new HashMap<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			hash.putIfAbsent(i, new HashSet<>());
			for (int j = 0; j < k; j++)
				hash.get(i).add(Integer.parseInt(st.nextToken()));
		}
		BFS(n);
		System.out.println(-1);
	}

	/**
	 * 1�������� N�������� ���� �ִ� ��θ� BFS�� ã�´�.
	 * @param n
	 */
	public static void BFS(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		int count = 0;
		while (!q.isEmpty()) {
			int qSize = q.size();
			count++;
			// �� ���鿡 ������ ��� ��带 Ž���Ѵ�.
			while (qSize-- > 0) {
				int cur = q.poll();
				if (cur == n) {
					System.out.println(count);
					System.exit(0);
				}
				Search(q, cur);
			}
		}
	}

	/**
	 * ������Ʃ����� Ž���Ͽ� cur���� �̵��� �� �ִ� ������ ť�� �ִ´�.
	 * cur�� ������ ������Ʃ��� Ž���� �Ϸ��� ���̹Ƿ� hash���� �����.
	 * @param q ���� Ž�� ������ ������ ť
	 * @param cur ���� ��
	 */
	public static void Search(Queue<Integer> q, int cur) {
		ArrayList<Integer> removeKey = new ArrayList<>();
		for (int index : hash.keySet()) {
			HashSet<Integer> hyperTube = hash.get(index);
			if (hyperTube.contains(cur)) {
				for (int station : hyperTube)
					if (!visited[station]) {
						q.add(station);
						visited[station] = true;
					}
				removeKey.add(index);
			}
		}
		for (int index : removeKey)
			hash.remove(index);
	}
}
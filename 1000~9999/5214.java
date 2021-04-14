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
 * 미래의 대중교통인 하이퍼 튜브는 역 K개를 연결한 것이다.
 * 1번역에서 N번 역으로 가는데 방문하는 역의 최솟값을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	// i번째 하이퍼튜브를 저장한다.
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
	 * 1번역에서 N번역까지 가는 최단 경로를 BFS로 찾는다.
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
			// 각 노드들에 인접한 모든 노드를 탐색한다.
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
	 * 하이퍼튜브들을 탐색하여 cur에서 이동할 수 있는 역들을 큐에 넣는다.
	 * cur을 포함한 하이퍼튜브는 탐색을 완료한 것이므로 hash에서 지운다.
	 * @param q 다음 탐색 역들을 저장할 큐
	 * @param cur 현재 역
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
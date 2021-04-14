package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 지민이가 파티에서 과장된 이야기를 하려고 한다.
 * 하지만 사실을 알고있는 사람이 있다면 과장된 이야기를 할 수 없다.
 * 과장된 이야기를 할 수 있는 파티의 최대 개수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	// 파티에서 진실을 얘기해야하는지 거짓을 얘기해야 하는지 저장한다.
	static boolean[] isTrue;
	// 각 파티에 오는 사람들을 저장한다.
	static HashMap<Integer, HashSet<Integer>> hash = new HashMap<>();
	// 진실을 알고 있는 사람들을 저장한다.
	static HashSet<Integer> trueKnow = new HashSet<>();
	// 진실을 아는 사람과 듣게 되는 사람들을 저장한다.
	static Queue<Integer> q = new LinkedList<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		isTrue = new boolean[m];
		visited = new boolean[n + 1];
		st = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(st.nextToken());
		while (cnt-- > 0)
			trueKnow.add(Integer.parseInt(st.nextToken()));
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int participate = Integer.parseInt(st.nextToken());
			hash.putIfAbsent(i, new HashSet<>());
			for (int j = 0; j < participate; j++) {
				int people = Integer.parseInt(st.nextToken());
				// 진실을 알고있는 사람이면 파티에서 진실을 얘기한다.
				if (trueKnow.contains(people))
					isTrue[i] = true;
				hash.get(i).add(people);
			}
			// 진실을 듣게 되는 사람들을 큐에 추가한다.
			if (isTrue[i])
				for (int item : hash.get(i))
					if (!visited[item]) {
						q.add(item);
						visited[item] = true;
					}
		}
		BFS();
		// 과장된 이야기를 할 수 있는 파티의 수를 구한다.
		int answer = 0;
		for (boolean item : isTrue)
			if (!item)
				answer++;
		System.out.println(answer);
	}

	/**
	 * 진실을 알고있는 사람들에 대해 BFS 탐색을 한다.
	 */
	public static void BFS() {
		while (!q.isEmpty()) {
			int cur = q.poll();
			// 각 파티에서 진실을 듣게된 사람이 존재하면서 진실을 듣지 않은 사람들을 큐에 추가한다.
			for (int key : hash.keySet()) {
				// 진실을 알고있는 사람이 파티에 있는지 탐색
				if (hash.get(key).contains(cur)) {
					// 진실을 알고있는 사람이 있다면 아직 진실을 모르는 사람들을 큐에 추가
					for (int item : hash.get(key)) {
						if (!visited[item]) {
							visited[item] = true;
							q.add(item);
						}
					}
					// 파티에서 진실을 얘기한다.
					isTrue[key] = true;
				}
			}
		}
	}
}
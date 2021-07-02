package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 큐브러버는 주사위를 조작하여 원하는 수를 나오게 할 수 있다.
 * 100칸으로 이루어진 보드판이 주어진다.
 * 각 칸에는 사다리와 뱀이 최대 한 개까지 있을 수 있다.
 * 사다리를 타면 더 높은 칸으로 이동할 수 있고, 뱀을 타면 낮은 칸으로 내려간다.
 * 1번 칸에서 100번 칸까지 주사위를 최소 몇 번 굴려야 하는지 구하는 문제
 * @author Rave
 *
 */
public class Main {

	// 사다리와 뱀을 저장한다.
	static HashMap<Integer, Integer> ladder = new HashMap<>();
	static HashMap<Integer, Integer> snake = new HashMap<>();
	// 방문 체크를 한다.
	static boolean[] visited = new boolean[101];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			ladder.put(start, end);
		}
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			snake.put(start, end);
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		int answer = 0;
		// 너비 우선 탐색을 한다.
		while (!q.isEmpty()) {
			int size = q.size();
			answer++;
			while (size-- > 0) {
				int cur = q.poll();
				if (cur == 100) {
					System.out.println(answer - 1);
					return;
				}
				for (int i = 1; i <= 6; i++) {
					int next = cur + i;
					if (next >= visited.length || visited[next])
						continue;
					if (ladder.containsKey(next)) {
						q.add(ladder.get(next));
						visited[ladder.get(next)] = true;
					} else if (snake.containsKey(next)) {
						q.add(snake.get(next));
						visited[snake.get(next)] = true;
					} else {
						q.add(next);
						visited[next] = true;
					}
				}
			}
		}
	}
}
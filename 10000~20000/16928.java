package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * ť�귯���� �ֻ����� �����Ͽ� ���ϴ� ���� ������ �� �� �ִ�.
 * 100ĭ���� �̷���� �������� �־�����.
 * �� ĭ���� ��ٸ��� ���� �ִ� �� ������ ���� �� �ִ�.
 * ��ٸ��� Ÿ�� �� ���� ĭ���� �̵��� �� �ְ�, ���� Ÿ�� ���� ĭ���� ��������.
 * 1�� ĭ���� 100�� ĭ���� �ֻ����� �ּ� �� �� ������ �ϴ��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	// ��ٸ��� ���� �����Ѵ�.
	static HashMap<Integer, Integer> ladder = new HashMap<>();
	static HashMap<Integer, Integer> snake = new HashMap<>();
	// �湮 üũ�� �Ѵ�.
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
		// �ʺ� �켱 Ž���� �Ѵ�.
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
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
 * �����̰� ��Ƽ���� ����� �̾߱⸦ �Ϸ��� �Ѵ�.
 * ������ ����� �˰��ִ� ����� �ִٸ� ����� �̾߱⸦ �� �� ����.
 * ����� �̾߱⸦ �� �� �ִ� ��Ƽ�� �ִ� ������ ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	// ��Ƽ���� ������ ����ؾ��ϴ��� ������ ����ؾ� �ϴ��� �����Ѵ�.
	static boolean[] isTrue;
	// �� ��Ƽ�� ���� ������� �����Ѵ�.
	static HashMap<Integer, HashSet<Integer>> hash = new HashMap<>();
	// ������ �˰� �ִ� ������� �����Ѵ�.
	static HashSet<Integer> trueKnow = new HashSet<>();
	// ������ �ƴ� ����� ��� �Ǵ� ������� �����Ѵ�.
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
				// ������ �˰��ִ� ����̸� ��Ƽ���� ������ ����Ѵ�.
				if (trueKnow.contains(people))
					isTrue[i] = true;
				hash.get(i).add(people);
			}
			// ������ ��� �Ǵ� ������� ť�� �߰��Ѵ�.
			if (isTrue[i])
				for (int item : hash.get(i))
					if (!visited[item]) {
						q.add(item);
						visited[item] = true;
					}
		}
		BFS();
		// ����� �̾߱⸦ �� �� �ִ� ��Ƽ�� ���� ���Ѵ�.
		int answer = 0;
		for (boolean item : isTrue)
			if (!item)
				answer++;
		System.out.println(answer);
	}

	/**
	 * ������ �˰��ִ� ����鿡 ���� BFS Ž���� �Ѵ�.
	 */
	public static void BFS() {
		while (!q.isEmpty()) {
			int cur = q.poll();
			// �� ��Ƽ���� ������ ��Ե� ����� �����ϸ鼭 ������ ���� ���� ������� ť�� �߰��Ѵ�.
			for (int key : hash.keySet()) {
				// ������ �˰��ִ� ����� ��Ƽ�� �ִ��� Ž��
				if (hash.get(key).contains(cur)) {
					// ������ �˰��ִ� ����� �ִٸ� ���� ������ �𸣴� ������� ť�� �߰�
					for (int item : hash.get(key)) {
						if (!visited[item]) {
							visited[item] = true;
							q.add(item);
						}
					}
					// ��Ƽ���� ������ ����Ѵ�.
					isTrue[key] = true;
				}
			}
		}
	}
}
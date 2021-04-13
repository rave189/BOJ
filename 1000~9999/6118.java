package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * �缭��� �����ϰ� ���ٲ����� �ϰ� �ִ�.
 * �缭��� ������ �갣�� �� ���� �� �갣�� ����� �Ҷ�,
 * �갣�� ��ȣ(�Ÿ��� ���� �갣�� ��������� ���� ���� ��ȣ�� �갣),
 * �갣������ �Ÿ�, ���� �Ÿ��� �갣�� ������ ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	// �Է��� ���� hash�� ��´�.
	static HashMap<Integer, ArrayList<Integer>> hash = new HashMap<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			hash.putIfAbsent(first, new ArrayList<>());
			hash.putIfAbsent(second, new ArrayList<>());
			hash.get(first).add(second);
			hash.get(second).add(first);
		}
		// ������ 1�� �갣�̴�.
		BFS(1);
	}

	/**
	 * ���� �� �갣���� ������ �˱� ���� �ʺ� �켱 Ž���� �����ϴ� �޼ҵ�
	 * @param start ���� �갣
	 */
	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		int number = 0, distance = 0, count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			int min = Integer.MAX_VALUE;
			count = size;
			distance++;
			while (size-- > 0) {
				int cur = q.poll();
				for (int next : hash.get(cur))
					if (!visited[next]) {
						visited[next] = true;
						q.add(next);
						min = Math.min(min, next);
					}
			}
			// ���� �� �갣�� ��ȣ�� while���� ������-1��° ������ ���� �ּҰ��̴�.
			if (min != Integer.MAX_VALUE)
				number = min;
		}
		System.out.println(number + " " + (distance - 1) + " " + count);
	}
}
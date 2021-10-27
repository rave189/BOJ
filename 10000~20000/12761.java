package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * ���Դ� ���ٸ��� �ǳ� �ִ��� ���� �ֹ̿��� ������ �Ѵ�.
 * ���Դ� ��ī�� ������ �־� ���ٸ��� �ǳʶ� �� �ִ�.
 * ���԰� ������ �� �ִ� ����� +1, -1, +A, -A, +B, -B, *A, *B�� 8���� ����� �ִ�.
 * ���԰� �ֹ̿��� �����ϱ� ���� �ּ����� �̵� Ƚ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int[] stoneBridge = new int[100001];

	/**
	 * �ʺ� �켱 Ž������ Ž���Ͽ� �ּڰ��� ã�´�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		BFS(a, b, n, m);
		System.out.println(stoneBridge[m]);
	}

	public static void BFS(int a, int b, int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		int[] move = { a, b, a, b, -a, -b, 1, -1 };
		q.add(start);
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == end)
				return;
			for (int i = 0; i < move.length; i++) {
				int next = i < 2 ? cur * move[i] : cur + move[i];
				try {
					// �� �� �湮�� ���� �ּڰ��� �ƴϱ� ������ �湮���� �ʴ´�.
					if (stoneBridge[next] != 0)
						continue;
					stoneBridge[next] = stoneBridge[cur] + 1;
					q.add(next);
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		}
	}
}
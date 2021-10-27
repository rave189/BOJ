package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 동규는 돌다리를 건너 최대한 빨리 주미에게 가려고 한다.
 * 동규는 스카이 콩콩이 있어 돌다리를 건너뛸 수 있다.
 * 동규가 움직일 수 있는 방법은 +1, -1, +A, -A, +B, -B, *A, *B의 8가지 방법이 있다.
 * 동규가 주미에게 도달하기 위한 최소한의 이동 횟수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[] stoneBridge = new int[100001];

	/**
	 * 너비 우선 탐색으로 탐색하여 최솟값을 찾는다.
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
					// 한 번 방문한 곳은 최솟값이 아니기 때문에 방문하지 않는다.
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
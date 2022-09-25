package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 3개의 돌 그룹이 주어진다.
 * 각 돌 그룹에는 A, B, C개의 돌이 있다.
 * 이 중 개수가 같지 않은 두 돌 그룹을 선택한다.
 * 개수가 작은 쪽을 X, 큰 쪽을 Y라고 할 때, X+X, Y-X로 만든다.
 * 이 작업을 반복하여 세 돌 그룹의 돌 개수가 모두 같아지도록 만들 수 있으면 1 아니면 0을 출력하는 문제
 * @author Rave
 *
 */
public class Main {

	static boolean[][] visited = new boolean[1501][1501];

	/**
	 * 너비 우선 탐색으로 푸는 문제
	 * 처음에 문제를 잘못 이해해서 세 그룹 중에서 작은게 X, 큰게 Y인줄알고 next가 하나인데 어떻게 너비 우선 탐색이지? 했음
	 * 질문 보고 틀린 걸 발견함
	 * 방법 찾아보다가 결국 답 보고 품.
	 * 답 보고나서도 계속 틀렸습니다가 나와서 아예 새로 짜보니 통과
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] rocks = Arrays.stream(br.readLine().split(" ")).mapToInt(v -> Integer.parseInt(v)).toArray();
		System.out.println(bfs(rocks) ? 1 : 0);
	}

	public static boolean bfs(int[] start) {
		Queue<int[]> q = new LinkedList<>();
		Arrays.sort(start);
		visited[start[0]][start[1]] = true;
		q.add(start);
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == cur[1] && cur[1] == cur[2])
				return true;
			int[][] nextArr = { { cur[0], cur[1], cur[2] }, { cur[0], cur[2], cur[1] }, { cur[1], cur[2], cur[0] } };
			for (int[] next : nextArr) {
				if (next[0] == next[1])
					continue;
				next[1] -= next[0];
				next[0] += next[0];
				Arrays.sort(next);
				if (visited[next[0]][next[1]])
					continue;
				visited[next[0]][next[1]] = true;
				q.add(next);
			}
		}
		return false;
	}
}
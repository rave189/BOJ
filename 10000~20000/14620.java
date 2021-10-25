package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 식목일에 NxN 격자 모양의 화단에 꽃을 심으려고 한다.
 * 꽃은 피게되면 상, 하, 좌, 우, 중앙을 모두 차지한다.
 * 또한, 꽃이 서로 곂치게 되면 두 꽃 모두 죽는다.
 * 화단은 각각의 포인트마다 대여료가 다르다.
 * 화단에 3개의 씨앗을 심어 꽃을 피우려고 할 때, 화단 대여료의 최솟값을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static int answer = Integer.MAX_VALUE;
	static boolean[][] visited;

	/**
	 * 브루트포스를 이용하여 3개의 꽃을 전부 심어본다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		bruteforce(0, 3, 0);
		System.out.println(answer);
	}

	public static void bruteforce(int next, int remainSeedCnt, int result) {
		if (remainSeedCnt == 0) {
			answer = Math.min(answer, result);
			return;
		}

		for (int i = next; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				try {
					if (visited[i][j] || visited[i - 1][j] || visited[i][j - 1] || visited[i + 1][j] || visited[i][j + 1])
						continue;
					int sum = map[i][j] + map[i - 1][j] + map[i + 1][j] + map[i][j - 1] + map[i][j + 1];
					visited[i][j] = visited[i - 1][j] = visited[i + 1][j] = visited[i][j - 1] = visited[i][j + 1] = true;
					bruteforce(i, remainSeedCnt - 1, result + sum);
					visited[i][j] = visited[i - 1][j] = visited[i + 1][j] = visited[i][j - 1] = visited[i][j + 1] = false;
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		}
	}
}
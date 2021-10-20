package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 4-4-2 다이아몬드 전술로 축구선수들을 배정하려고 한다.
 * 각 선수들이 각각의 포지션에서 능력치가 얼마인지 주어진다.
 * 선수들을 모두 각 포지션에 배치했을 때의 능력치의 최댓값을 구하는 문제
 * 능력치가 0인 경우 해당 포지션에 맞지 않는 선수이므로 배치할 수 없다.
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static boolean[] visited;
	static int answer;

	/**
	 * 브루트포스로 탐색을 하며 각각의 선수들을 모두 포지션에 배치해본다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			map = new int[11][11];
			visited = new boolean[11];
			answer = 0;
			for (int i = 0; i < map.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[0].length; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			BruteForce(0, 0);
			sb.append(answer).append('\n');
		}
		System.out.println(sb);
	}

	public static void BruteForce(int cur, int sum) {
		if (cur >= map.length) {
			answer = Math.max(answer, sum);
			return;
		}
		for (int i = 0; i < map.length; i++) {
			if (visited[i] || map[i][cur] == 0)
				continue;
			visited[i] = true;
			BruteForce(cur + 1, sum + map[i][cur]);
			visited[i] = false;
		}
	}
}
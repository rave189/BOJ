package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가중치 없는 방향 그래프 G가 주어진다.
 * 모든 정점 (i, j)에 대해서 i에서 j로 가는 길이 존재하는지 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[][] map;

	/**
	 * 플로이드 와샬 알고리즘을 사용하여 i에서 m을 지나 j로 가는 방법이 있는지 탐색한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		Solve();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				sb.append(map[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	/**
	 * 플로이드 와샬 알고리즘으로 모든 정점에 대해 i에서 j로 갈 수 있는지 구하는 메소드
	 * 항상 중간 지점 m이 첫 for문으로 나와야 하고
	 * 다음 이중 포문은 i, j 순으로 나와야 한다.
	 */
	public static void Solve() {
		// 중간 지점 m
		for (int m = 0; m < map.length; m++)
			// (i, j)
			for (int i = 0; i < map.length; i++)
				for (int j = 0; j < map.length; j++)
					// i에서 m으로 갈 수 있고, m에서 j로 갈 수 있다면 i에서 j로 갈 수 있다.
					if (map[i][m] == 1 && map[m][j] == 1)
						map[i][j] = 1;
	}
}
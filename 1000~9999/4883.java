package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 삼각 그래프는 행이 N개 열이 3개인 그래프이다.
 * 이 그래프의 가장 위쪽 가운데 정점에서 가장 아래쪽 가운데 정점으로 가는 최단 경로를 구하는 문제
 * 각 정점에서 (x, y+1), (x+1, y+1), (x+1, y), (x+1, y-1)의 방향으로 움직일 수 있다.
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static int[][] dp;
	static int[] dx = { 0, 1, 1, 1 };
	static int[] dy = { 1, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int k = 1;
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			map = new int[n][3];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 3; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			Dp();
			sb.append(String.format("%d. %d\n", k++, dp[n - 1][1]));
		}
		System.out.println(sb);
	}

	public static void Dp() {
		// 배열 새로 생성 및 입력이 정수이기 때문에 max_value로 초기화
		dp = new int[map.length][3];
		for (int i = 0; i < map.length; i++)
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		dp[0][1] = map[0][1];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < 3; j++) {
				// 시작 정점이 0, 1이기 때문에 0, 0은 탐색하지 않는다.
				if (i == 0 && j == 0)
					continue;
				// 각 방향에 대해 최단 경로이면 갱신해준다.
				for (int t = 0; t < 4; t++) {
					int nextX = i + dx[t];
					int nextY = j + dy[t];
					try {
						if (dp[i][j] + map[nextX][nextY] < dp[nextX][nextY])
							dp[nextX][nextY] = dp[i][j] + map[nextX][nextY];
					} catch (Exception e) {
					}
				}
			}
		}
	}
}
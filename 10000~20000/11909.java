package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배열을 탈출하려고 한다.
 * 탈출하기위해 최단거리로 오른쪽과 아래쪽으로만 이동할 수 있다.
 * 또한 (a, b)에서 (c, d)로 가려면 A[a][b] > A[c][d]이어야만 한다.
 * 이 조건을 만족하기 위해 비용을 1 지불하고 A[a][b]의 칸의 값을 1 증가시킬 수 있다.
 * 탈출하는데 필요한 최소 비용을 구하는 문제
 * 입력이 2222로 매우매우매우 크다.
 * @author Rave
 *
 */
public class Main {

	static int[][] map, pays;
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };
	static int INF = 100000000;

	/**
	 * dp와 다익스트라로 푸는 방법이 있다.
	 * 다익스트라로는 1400ms 정도이고, dp로 바꾸니 900ms 정도 나온다.
	 * 조건에 맞게 이동하면 쉽게 탈출할 수 있다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		pays = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				pays[i][j] = INF;
			}
		}
		pays[0][0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (pays[i][j] == INF)
					continue;
				int compareValue = map[i][j];
				int comparePay = pays[i][j];
				for (int t = 0; t < dx.length; t++) {
					int nextX = i + dx[t];
					int nextY = j + dy[t];
					try {
						if (compareValue > map[nextX][nextY] && comparePay < pays[nextX][nextY])
							pays[nextX][nextY] = comparePay;
						else if (compareValue <= map[nextX][nextY]
								&& map[nextX][nextY] + 1 - compareValue + comparePay < pays[nextX][nextY])
							pays[nextX][nextY] = map[nextX][nextY] + 1 - compareValue + comparePay;
					} catch (ArrayIndexOutOfBoundsException e) {
					}
				}
			}
		}
		System.out.println(pays[n - 1][n - 1]);
	}
}
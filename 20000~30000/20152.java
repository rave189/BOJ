package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 강산이는 매일 PC방에 간다.
 * 최근 폭우로 일부 지역이 침수되어 침수된 지역으로 이동이 불가능하다.
 * 강산이는 상, 하, 좌, 우로 이동하며, 한 번 이동할 때 이동 거리는 1이다.
 * 또한 빨리 PC방에 가야하므로 최단거리로 움직인다.
 * 강산이의 집 좌표 (H, H), PC방의 좌표 (N, N)이 주어질 때
 * 강산이가 PC방에 갈 수 있는 경로의 수를 구하는 문제
 * 좌표평면 위 (x, y)에서 (y > x)인 곳은 모두 침수되었다고 한다.
 * 집과 PC방의 좌표가 같은 경우 1가지 경우가 있다고 한다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * h와 n중 어느 좌표가 큰지 작은지를 start와 end에 저장해둔다. (항상 오른쪽 아래 방향으로만 탐색하기 위해서)
	 * 이후 (start, start-1)을 1로 설정 후 탐색을 시작하도록 한다.
	 * 탐색은 점화식 dp[i][j] = dp[i-1][j] + dp[i][j-1]을 사용하여 탐색한다.
	 * 경로의 수가 int를 벗어날 수 있으므로 long으로 map을 설정한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken()) + 1;
		int n = Integer.parseInt(st.nextToken()) + 1;
		long[][] map = new long[32][32];
		int start = Math.min(h, n);
		int end = Math.max(h, n);
		map[start][start - 1] = 1;
		for (int i = start; i <= end; i++) {
			for (int j = start; j <= end; j++) {
				if (j > i)
					break;
				map[i][j] = map[i - 1][j] + map[i][j - 1];
			}
		}
		System.out.println(map[end][end]);
	}
}
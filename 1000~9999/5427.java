package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 건물에 불이나 상근이가 도망치려고 한다.
 * 건물은 빈공간인 '.', 벽인 '#', 상근이의 위치인 '@', 불의 위치인 '*' 으로 이루어져 있다.
 * 불과 상근이 모두 매초마다 동서남북으로 이동한다.
 * 상근이는 벽을 통과할 수 없고, 불이 옮겨진 칸 또는 이제 불이 옮기려는 칸에는 이동할 수 없다.
 * 상근이는 불이 옮겨옴과 동시에 다른 칸으로 이동할 수 있다.
 * 상근이가 탈출을 할 수 있다면 걸리는 최소 시간을 출력하고, 탈출하지 못한다면 IMPOSSIBLE을 출력한다.
 * @author Rave
 *
 */
public class Main {

	// 건물 지도
	static char[][] map;
	// 상근이가 방문을 했는지 검사한다.
	static boolean[][] visited;
	// 불의 BFS
	static Queue<int[]> fire = new LinkedList<>();
	// 상근이의 BFS
	static Queue<int[]> sanggeun = new LinkedList<>();
	static StringBuffer sb = new StringBuffer();
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			fire.clear();
			sanggeun.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			map = new char[n][m];
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				for (int j = 0; j < m; j++) {
					map[i][j] = line.charAt(j);
					// 상근이인 경우 상근 BFS에 추가하며 visited를 true로 설정한다.
					if (map[i][j] == '@') {
						sanggeun.add(new int[] { i, j });
						visited[i][j] = true;
					}
					// 불인 경우 불 BFS에 추가
					else if (map[i][j] == '*')
						fire.add(new int[] { i, j });
				}
			}
			Escape();
		}
		System.out.println(sb);
	}

	/**
	 * 상근이가 도망칠 수 있는지 구하는 메소드
	 * 상근이가 도망칠 수 있다면 버퍼에 최소 시간을 넣고,
	 * 도망치지 못했다면 IMPOSSIBLE을 넣는다.
	 */
	public static void Escape() {
		boolean isRun = false;
		int count = 0;
		// 상근이의 위치가 존재할 때까지 반복한다.
		while (!sanggeun.isEmpty()) {
			count++;
			// 불을 먼저 옮겨 불이 옮겨질 칸을 미리 선점한다.
			BFS(fire, '*');
			// 이후 상근이를 움직인다.
			isRun = BFS(sanggeun, '@');
			// 상근이가 도망쳤다면 반복문을 종료한다.
			if (isRun)
				break;
		}
		if (isRun)
			sb.append(count + "\n");
		else
			sb.append("IMPOSSIBLE\n");
	}

	/**
	 * 큐를 입력으로 받아 불과 상근이의 BFS를 수행한다.
	 * BFS는 1초 동안만 움직여야 하므로 인자로 들어온 큐의 사이즈 만큼만 수행한다.
	 * @param q 불의 큐 혹은 상근이의 큐
	 * @param ch 불이라면 '*', 상근이라면 '@'
	 * @return 상근이가 탈출한다면 true, 아니라면 false
	 */
	public static boolean BFS(Queue<int[]> q, char ch) {
		int size = q.size();
		while (size-- > 0) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = cur[0] + dx[i];
				int nextY = cur[1] + dy[i];
				try {
					// 벽과 불이 아니라면 전진한다.
					if (map[nextX][nextY] != '#' && map[nextX][nextY] != '*') {
						// 상근이의 경우
						if (ch == '@') {
							// 이미 방문한 지점이라면 큐에 넣지 않는다.
							if (visited[nextX][nextY])
								continue;
							// 방문하지 않은 지점이라면 방문 체크를 한다.
							else
								visited[nextX][nextY] = true;
						}
						// 불과 상근이 모두 다음 지점으로 전진할 수 있으므로 전진한다.
						q.add(new int[] { nextX, nextY });
						map[nextX][nextY] = ch;
					}
				} catch (Exception e) {
					// 상근이가 배열의 범위를 벗어났으므로 탈출에 성공
					if (ch == '@')
						return true;
				}
			}
		}
		// 탈출에 실패
		return false;
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * �ǹ��� ���̳� ����̰� ����ġ���� �Ѵ�.
 * �ǹ��� ������� '.', ���� '#', ������� ��ġ�� '@', ���� ��ġ�� '*' ���� �̷���� �ִ�.
 * �Ұ� ����� ��� ���ʸ��� ������������ �̵��Ѵ�.
 * ����̴� ���� ����� �� ����, ���� �Ű��� ĭ �Ǵ� ���� ���� �ű���� ĭ���� �̵��� �� ����.
 * ����̴� ���� �ŰܿȰ� ���ÿ� �ٸ� ĭ���� �̵��� �� �ִ�.
 * ����̰� Ż���� �� �� �ִٸ� �ɸ��� �ּ� �ð��� ����ϰ�, Ż������ ���Ѵٸ� IMPOSSIBLE�� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	// �ǹ� ����
	static char[][] map;
	// ����̰� �湮�� �ߴ��� �˻��Ѵ�.
	static boolean[][] visited;
	// ���� BFS
	static Queue<int[]> fire = new LinkedList<>();
	// ������� BFS
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
					// ������� ��� ��� BFS�� �߰��ϸ� visited�� true�� �����Ѵ�.
					if (map[i][j] == '@') {
						sanggeun.add(new int[] { i, j });
						visited[i][j] = true;
					}
					// ���� ��� �� BFS�� �߰�
					else if (map[i][j] == '*')
						fire.add(new int[] { i, j });
				}
			}
			Escape();
		}
		System.out.println(sb);
	}

	/**
	 * ����̰� ����ĥ �� �ִ��� ���ϴ� �޼ҵ�
	 * ����̰� ����ĥ �� �ִٸ� ���ۿ� �ּ� �ð��� �ְ�,
	 * ����ġ�� ���ߴٸ� IMPOSSIBLE�� �ִ´�.
	 */
	public static void Escape() {
		boolean isRun = false;
		int count = 0;
		// ������� ��ġ�� ������ ������ �ݺ��Ѵ�.
		while (!sanggeun.isEmpty()) {
			count++;
			// ���� ���� �Ű� ���� �Ű��� ĭ�� �̸� �����Ѵ�.
			BFS(fire, '*');
			// ���� ����̸� �����δ�.
			isRun = BFS(sanggeun, '@');
			// ����̰� �����ƴٸ� �ݺ����� �����Ѵ�.
			if (isRun)
				break;
		}
		if (isRun)
			sb.append(count + "\n");
		else
			sb.append("IMPOSSIBLE\n");
	}

	/**
	 * ť�� �Է����� �޾� �Ұ� ������� BFS�� �����Ѵ�.
	 * BFS�� 1�� ���ȸ� �������� �ϹǷ� ���ڷ� ���� ť�� ������ ��ŭ�� �����Ѵ�.
	 * @param q ���� ť Ȥ�� ������� ť
	 * @param ch ���̶�� '*', ����̶�� '@'
	 * @return ����̰� Ż���Ѵٸ� true, �ƴ϶�� false
	 */
	public static boolean BFS(Queue<int[]> q, char ch) {
		int size = q.size();
		while (size-- > 0) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = cur[0] + dx[i];
				int nextY = cur[1] + dy[i];
				try {
					// ���� ���� �ƴ϶�� �����Ѵ�.
					if (map[nextX][nextY] != '#' && map[nextX][nextY] != '*') {
						// ������� ���
						if (ch == '@') {
							// �̹� �湮�� �����̶�� ť�� ���� �ʴ´�.
							if (visited[nextX][nextY])
								continue;
							// �湮���� ���� �����̶�� �湮 üũ�� �Ѵ�.
							else
								visited[nextX][nextY] = true;
						}
						// �Ұ� ����� ��� ���� �������� ������ �� �����Ƿ� �����Ѵ�.
						q.add(new int[] { nextX, nextY });
						map[nextX][nextY] = ch;
					}
				} catch (Exception e) {
					// ����̰� �迭�� ������ ������Ƿ� Ż�⿡ ����
					if (ch == '@')
						return true;
				}
			}
		}
		// Ż�⿡ ����
		return false;
	}
}
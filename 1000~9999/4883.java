package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * �ﰢ �׷����� ���� N�� ���� 3���� �׷����̴�.
 * �� �׷����� ���� ���� ��� �������� ���� �Ʒ��� ��� �������� ���� �ִ� ��θ� ���ϴ� ����
 * �� �������� (x, y+1), (x+1, y+1), (x+1, y), (x+1, y-1)�� �������� ������ �� �ִ�.
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
		// �迭 ���� ���� �� �Է��� �����̱� ������ max_value�� �ʱ�ȭ
		dp = new int[map.length][3];
		for (int i = 0; i < map.length; i++)
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		dp[0][1] = map[0][1];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < 3; j++) {
				// ���� ������ 0, 1�̱� ������ 0, 0�� Ž������ �ʴ´�.
				if (i == 0 && j == 0)
					continue;
				// �� ���⿡ ���� �ִ� ����̸� �������ش�.
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
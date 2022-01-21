package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ������ �ٴ��� ���� ����� Ÿ�Ϸ� ä����� �Ѵ�.
 * �� �� �� ĭ�� ������� ������ �Ѵ�.
 * ������ �ٴ��� ��� ��� �� �ƹ��ų� ����ϰ� ���ٸ� -1�� ����ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static int[][] dx = { { 1, 0, 0 }, { 0, 0, 1 }, { 0, 0, -1 }, { -1, 0, 0 } };
	static int[][] dy = { { 0, 0, 1 }, { -1, 0, 0 }, { -1, 0, 0 }, { 0, 0, 1 } };

	/**
	 * ������ �ٴ��� DFS�� ���� ��ƺ���.
	 * �켱 ����� �κ��� -1�� �����صΰ� �������� Ž���ϸ鼭 ��� Ÿ���� �� ��� ����ϰ� ���ٸ� -1�� ����Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int length = (int) Math.pow(2, n);
		map = new int[length][length];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken()) - 1;
		int y = Integer.parseInt(st.nextToken()) - 1;
		map[y][x] = -1;
		tileLay(1, length * length - 1);
	}

	public static void tileLay(int count, int remainTileCnt) {
		if (remainTileCnt == 0) {
			System.out.print(print());
			System.exit(0);
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				for (int t = 0; t < dx.length; t++) {
					try {
						int tile_1 = map[i + dx[t][0]][j + dy[t][0]];
						int tile_2 = map[i + dx[t][1]][j + dy[t][1]];
						int tile_3 = map[i + dx[t][2]][j + dy[t][2]];
						if (tile_1 == 0 && tile_2 == 0 && tile_3 == 0) {
							map[i + dx[t][0]][j + dy[t][0]] = map[i + dx[t][1]][j + dy[t][1]] = map[i + dx[t][2]][j + dy[t][2]] = count;
							tileLay(count + 1, remainTileCnt - 3);
							map[i + dx[t][0]][j + dy[t][0]] = map[i + dx[t][1]][j + dy[t][1]] = map[i + dx[t][2]][j + dy[t][2]] = 0;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
					}
				}
			}
		}
	}

	public static String print() {
		StringBuilder answer = new StringBuilder();
		for (int i = map.length - 1; i >= 0; i--) {
			for (int j = 0; j < map[0].length; j++)
				answer.append(map[i][j]).append(' ');
			answer.append('\n');
		}
		return answer.toString();
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 우주가 있다.
 * 각 우주에는 1번부터 M번까지 숫자가 적힌 행성이 있다.
 * 행성의 크기를 알고 있을 때, 균등한 우주의 쌍이 몇 개인지 구하는 문제
 * 균등한 우주란 1 <= i, j <= M에 대해서 아래와 같은 조건을 만족하는 우주를 의미한다.
 * Ai < Aj -> Bi < Bj
 * Ai = Aj -> Bi = Bj
 * Ai > Aj -> Bi > Bj
 * 구성이 같은 우주인데 순서만 다른 경우는 한 번만 센다.
 * (1번 우주, 2번 우주)와 (2번 우주, 1번 우주)은 한 번만 센다.
 * @author Rave
 *
 */
public class Main {

	static int[][] space;
	static int answer = 0;

	/**
	 * 브루트포스를 사용하여 우주를 2개씩 선택하고 선택한 우주가 균등한지 확인해본다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		space = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				space[i][j] = Integer.parseInt(st.nextToken());
		}
		bruteforce();
		System.out.println(answer);
	}

	/**
	 * 우주를 2개씩 선택한다.
	 */
	public static void bruteforce() {
		for (int i = 0; i < space.length; i++)
			for (int j = i + 1; j < space.length; j++)
				if (isMatching(i, j))
					answer++;
	}

	/**
	 * 두 우주가 균등한지 확인해본다.
	 * @param x 선택한 우주 1
	 * @param y 선택한 우주 2
	 * @return 균등하다면 true, 아니라면 false
	 */
	public static boolean isMatching(int x, int y) {
		for (int i = 0; i < space[0].length; i++) {
			for (int j = i + 1; j < space[0].length; j++) {
				if (space[x][i] < space[x][j] ^ space[y][i] < space[y][j])
					return false;
				else if (space[x][i] == space[x][j] ^ space[y][i] == space[y][j])
					return false;
				else if (space[x][i] > space[x][j] ^ space[y][i] > space[y][j])
					return false;
			}
		}
		return true;
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N*M의 직사각형에 동전이 N*M개 놓여있다.
 * 동전의 앞면을 0이라고 하고, 뒷면을 1이라고 한다.
 * 세준이는 동전을 모두 앞면으로 바꾸려고 한다.
 * 이때, (x, y)칸의 동전을 뒤집으면 (i, j)(1 <= i <= a, 1 <= j <= b)의 조건을 만족하는 x*y개의 동전이 모두 뒤집힌다.
 * 뒤집어야 하는 동전의 개수를 구하는 문제
 * (x, y)를 뒤집었다면 뒤집은 횟수는 x*y가 아니라 1이다.
 * @author Rave
 *
 */
public class Main {

	static int[][] map;

	/**
	 * (x, y) 이하의 모든 점들이 뒤집히므로 (N, M)부터 (1, 1)까지 역순으로 동전을 전부 뒤집으면
	 * 모든 동전을 앞면으로 바꿀 수 있다. 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++)
				map[i][j] = input.charAt(j) - '0';
		}
		int answer = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				if (map[i][j] == 1) {
					changeMap(i, j);
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

	public static void changeMap(int x, int y) {
		for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				if (map[i][j] == 0)
					map[i][j] = 1;
				else
					map[i][j] = 0;
			}
		}
	}
}
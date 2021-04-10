package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 각각의 연산을 통해 배열을 돌리는 문제
 * 연산은 배열을 부분 배열로 나눈 후 연산을 수행한다.
 * 부분 배열은 (2^l)x(2^l)의 크기를 가진다.
 * 1번 연산: 각 부분 배열을 상하 반전시킨다.
 * 2번 연산: 각 부분 배열을 좌우 반전시킨다.
 * 3번 연산: 각 부분 배열을 오른쪽으로 90도 회전시킨다.
 * 4번 연산: 각 부분 배열을 왼쪽으로 90도 회전시킨다.
 * 5번 연산부터는 부분 배열을 한 칸이라고 생각하고 연산을 수행한다.
 * 5번 연산: 배열을 상하 반전시킨다.
 * 6번 연산: 배열을 좌우 반전시킨다.
 * 7번 연산: 배열을 오른쪽으로 90도 회전시킨다.
 * 8번 연산: 배열을 왼쪽으로 90도 회전시킨다.
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static int powL; // 부분 배열의 크기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		// 배열을 2^n의 크기로 생성한다.
		int pow = (int) Math.pow(2, n);
		map = new int[pow][pow];
		for (int i = 0; i < pow; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < pow; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			powL = (int) Math.pow(2, l);
			// 각 연산에 따라 다른 메소드를 수행한다.
			if (k <= 4)
				Op1234(k);
			else if (k == 5)
				Five();
			else if (k == 6)
				Six();
			else if (k == 7)
				Seven();
			else
				Eight();
		}
		print();
	}

	/**
	 * 1,2,3,4번의 연산을 수행하는 메소드
	 * 1,2,3,4번은 각가의 부분 배열 안에서 연산을 수행한다.
	 * @param k 연산을 수행할 번호
	 */
	public static void Op1234(int k) {
		for (int i = 0; i < map.length; i += powL)
			for (int j = 0; j < map.length; j += powL)
				if (k == 1)
					One(i, j);
				else if (k == 2)
					Two(i, j);
				else if (k == 3)
					Three(i, j);
				else
					Four(i, j);
	}

	/**
	 * 1번 연산
	 * 시작점과 인자로 받아 시작점부터 시작점+powL까지의 값을 상하 반전시킨다.
	 * @param startX 시작점 x
	 * @param startY 시작점 y
	 */
	public static void One(int startX, int startY) {
		int endX = startX + powL;
		int endY = startY + powL;
		for (int i = startX, t = 1; i < (startX + endX) / 2; i++, t++)
			for (int j = startY; j < endY; j++) {
				int tmp = map[i][j];
				map[i][j] = map[endX - t][j];
				map[endX - t][j] = tmp;
			}
	}

	/**
	 * 2번 연산
	 * 시작점부터 powL까지의 값을 좌우 반전시킨다.
	 * @param startX 시작점 x
	 * @param startY 시작점 y
	 */
	public static void Two(int startX, int startY) {
		int endX = startX + powL;
		int endY = startY + powL;
		for (int i = startX; i < endX; i++)
			for (int j = startY, t = 1; j < (startY + endY) / 2; j++, t++) {
				int tmp = map[i][j];
				map[i][j] = map[i][endY - t];
				map[i][endY - t] = tmp;
			}
	}

	/**
	 * 3번 연산
	 * 시작점부터 powL까지의 값을 90도 회전시킨다.
	 * @param startX 시작점 x
	 * @param startY 시작점 y
	 */
	public static void Three(int startX, int startY) {
		int[][] tmp = new int[powL][powL];
		int endX = startX + powL;
		int endY = startY + powL;
		// tmp에 값을 복사한다.
		for (int i = 0; i < powL; i++)
			for (int j = 0, t = powL - 1; j < powL; j++, t--)
				tmp[i][j] = map[startX + t][startY + i];
		// 다시 map에 tmp의 값을 붙여넣는다.
		for (int i = startX, a = 0; i < endX; i++, a++)
			for (int j = startY, b = 0; j < endY; j++, b++)
				map[i][j] = tmp[a][b];
	}

	/**
	 * 4번 연산
	 * 시작점부터 powL까지의 값을 왼쪽으로 90도 회전시킨다.
	 * @param startX 시작점 x
	 * @param startY 시작점 y
	 */
	public static void Four(int startX, int startY) {
		int[][] tmp = new int[powL][powL];
		int endX = startX + powL;
		int endY = startY + powL;
		// tmp에 값을 복사한다.
		for (int i = 0, t = powL - 1; i < powL; i++, t--)
			for (int j = 0; j < powL; j++)
				tmp[i][j] = map[startX + j][startY + t];
		// 다시 map에 tmp의 값을 붙여넣는다.
		for (int i = startX, a = 0; i < endX; i++, a++)
			for (int j = startY, b = 0; j < endY; j++, b++)
				map[i][j] = tmp[a][b];
	}

	/**
	 * 5번 연산
	 * 배열을 전체 상하 반전시킨다.
	 * 상하 반전은 부분 배열단위로 이루어져야 한다.
	 */
	public static void Five() {
		for (int i = 0; i < map.length / 2; i += powL)
			for (int j = 0; j < map.length; j += powL)
				Swap(i, j, map.length - powL - i, j);
	}

	/**
	 * 6번 연산
	 * 배열을 전체 좌우 반전시킨다.
	 * 좌우 반전은 부분 배열단위로 이루어져야 한다.
	 */
	public static void Six() {
		for (int i = 0; i < map.length; i += powL)
			for (int j = 0; j < map.length / 2; j += powL)
				Swap(i, j, i, map.length - powL - j);
	}

	/**
	 * 반전은 그룹 단위로 이루어져야 하기 때문에
	 * 1번 그룹의 시작점과 2번 그룹의 시작점을 받아 시작점 + powL까지의 값을 서로 바꾼다.
	 * @param x1 1번 그룹의 시작점 x
	 * @param y1 1번 그룹의 시작점 y
	 * @param x2 2번 그룹의 시작점 x
	 * @param y2 2번 그룹의 시작점 y
	 */
	public static void Swap(int x1, int y1, int x2, int y2) {
		for (int i = x1, a = x2; i < x1 + powL; i++, a++)
			for (int j = y1, b = y2; j < y1 + powL; j++, b++) {
				int tmp = map[i][j];
				map[i][j] = map[a][b];
				map[a][b] = tmp;
			}
	}

	/**
	 * 7번 연산
	 * 전체 배열을 오른쪽으로 90도 회전시킨다.
	 * 회전은 부분 배열 단위로 이루어져야 한다.
	 * 임시 배열 tmp를 만들어 회전한 뒤의 값들을 저장하고 map에 넣는다.
	 */
	public static void Seven() {
		int[][] tmp = new int[map.length][map.length];
		for (int i = 0; i < map.length; i += powL)
			for (int j = 0, t = map.length - powL; j < map.length; j += powL, t -= powL)
				GroupMove(tmp, i, j, t, i);
		map = tmp;
	}

	/**
	 * 8번 연산
	 * 전체 배열을 왼쪽으로 90도 회전시킨다.
	 * 회전은 부분 배열 단위로 이루어져야 한다.
	 * 임시 배열 tmp를 만들어 회전한 뒤의 값들을 저장하고 map에 넣는다.
	 */
	public static void Eight() {
		int[][] tmp = new int[map.length][map.length];
		for (int i = 0, t = map.length - powL; i < map.length; i += powL, t -= powL)
			for (int j = 0; j < map.length; j += powL)
				GroupMove(tmp, i, j, j, t);
		map = tmp;
	}

	/**
	 * 2번 그룹을 1번 그룹으로 옮기는 메소드
	 * 2번 그룹의 시작점을 받아 시작점 + powL까지의 값들을 1번 그룹에 넣는다.
	 * @param tmp 회전을 저장할 배열
	 * @param x1 1번 그룹의 시작점 x
	 * @param y1 1번 그룹의 시작점 y
	 * @param x2 2번 그룹의 시작점 x
	 * @param y2 2번 그룹의 시작점 y
	 */
	public static void GroupMove(int[][] tmp, int x1, int y1, int x2, int y2) {
		for (int i = x1, a = x2; i < x1 + powL; i++, a++)
			for (int j = y1, b = y2; j < y1 + powL; j++, b++)
				tmp[i][j] = map[a][b];
	}

	/**
	 * 배열을 출력하는 메소드
	 */
	public static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
	}
}
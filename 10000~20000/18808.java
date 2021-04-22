package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 대회에 참여하여 스티커 K개를 받았다.
 * 이 스티커를 노트북에 받은 순서대로 붙이려고 한다.
 * 이 때 노트북에 스티커가 붙은 칸 수를 구하는 문제
 * 노트북에 스티커를 붙이는 과정은 다음과 같다.
 * 1.스티커를 회전시키지 않고 모눈종이에서 떼어낸다.
 * 2.다른 스티커와 겹치거나 노트북을 벗어나지 않으면서 스티커를 붙일 수 있는 위치를 찾는다.
 *   혜윤이는 노트북의 위쪽부터 스티커를 채워 나가려고 해서, 스티커를 붙일 수 있는 위치가 여러 곳 있다면 가장 위쪽의 위치를 선택한다.
 *   가장 위쪽에 해당하는 위치도 여러 곳이 있다면 그중에서 가장 왼쪽의 위치를 선택한다.
 * 3.선택한 위치에 스티커를 붙인다. 만약 스티커를 붙일 수 있는 위치가 전혀 없어서 스티커를 붙이지 못했다면,
 *   스티커를 시계 방향으로 90도 회전한 뒤 2번 과정을 반복한다.
 * 4.위의 과정을 네 번 반복해서 스티커를 0도, 90도, 180도, 270도 회전시켜 봤음에도 스티커를 붙이지 못했다면 해당 스티커를 붙이지 않고 버린다.
 * @author Rave
 *
 */
public class Main {

	// 노트북
	static int[][] notebook;
	// 스티커를 저장할 배열
	static int[][][] stickers;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		notebook = new int[n][m];
		stickers = new int[k][][];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			stickers[i] = new int[r][c];
			for (int j = 0; j < r; j++) {
				st = new StringTokenizer(br.readLine());
				for (int t = 0; t < c; t++)
					stickers[i][j][t] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < k; i++) {
			int[][] sticker = stickers[i];
			for (int j = 0; j < 4; j++)
				// 스티커를 붙였다면 종료한다.
				if (isAttach(sticker))
					break;
				// 스티커를 붙일 수 없다면 3번까지 회전을 시켜본다.
				else if (j != 3)
					sticker = Rotation(sticker);
		}
		System.out.println(answer);
	}

	/**
	 * 각 지점마다 스티커를 붙일 수 있는지 확인해본다.
	 * 붙일 수 있다면 스티커를 붙인다.
	 * @param sticker 노트북에 붙일 스티커
	 * @return 스티커를 붙였다면 true, 아니라면 false
	 */
	public static boolean isAttach(int[][] sticker) {
		for (int i = 0; i < notebook.length; i++)
			for (int j = 0; j < notebook[0].length; j++)
				// (i, j) 지점에 스티커를 붙일 수 있는지 확인한다.
				if (isAble(i, j, sticker)) {
					// 스티커를 붙일 수 있다면 붙인다.
					Attach(i, j, sticker);
					return true;
				}
		return false;
	}

	/**
	 * 노트북의 (x, y) 지점에 스티커를 붙일 수 있는지 확인하는 메소드
	 * @param x 노트북의 x좌표
	 * @param y 노트북의 y좌표
	 * @param sticker 붙일 스티커
	 * @return 붙일 수 있다면 true, 아니라면 false
	 */
	public static boolean isAble(int x, int y, int[][] sticker) {
		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j < sticker[0].length; j++) {
				try {
					if (sticker[i][j] == 1 && notebook[i + x][j + y] == 1)
						return false;
				} catch (Exception e) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 노트북에 스티커를 붙인다.
	 * @param x 노트북의 x좌표
	 * @param y 노트북의 y좌표
	 * @param sticker 붙일 스티커
	 */
	public static void Attach(int x, int y, int[][] sticker) {
		for (int i = 0; i < sticker.length; i++)
			for (int j = 0; j < sticker[0].length; j++)
				if (sticker[i][j] == 1) {
					notebook[i + x][j + y] = sticker[i][j];
					answer++;
				}
	}

	/**
	 * 스티커를 시계 방향으로 90도 회전시키는 메소드
	 * @param sticker 회전시킬 스티커
	 * @return 시계 방향으로 90도 회전시킨 스티커
	 */
	public static int[][] Rotation(int[][] sticker) {
		int[][] rotate = new int[sticker[0].length][sticker.length];
		for (int i = 0, t = sticker.length - 1; i < sticker.length; i++, t--)
			for (int j = 0; j < sticker[0].length; j++)
				rotate[j][t] = sticker[i][j];
		return rotate;
	}
}
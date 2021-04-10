package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 6x6 배열에 서로 붙어있는 1이 6개가 있다.	
 * 이 6개의 1이 정육면체의 전개도가 될 수 있는지 구하는 문제
 * 
 * @author Rave
 *
 */
public class Main {

	// 정육면체의 11가지 전개도를 모아놓은 배열
	static int[][][] totalCube = { { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 } },
			{ { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 0, 1, 0, 0 } }, { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } },
			{ { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 0, 0, 0, 1 } }, { { 0, 1, 0, 0 }, { 1, 1, 1, 1 }, { 0, 1, 0, 0 } },
			{ { 0, 1, 0, 0 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } }, { { 1, 0, 0, 0 }, { 1, 1, 1, 0 }, { 0, 0, 1, 1 } },
			{ { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 0, 1, 1 } }, { { 0, 0, 1, 0 }, { 1, 1, 1, 0 }, { 0, 0, 1, 1 } },
			{ { 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1 } }, { { 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 1 } } };
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		for (int t = 0; t < 3; t++) {
			map = new int[6][6];
			for (int i = 0; i < 6; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 6; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			if (isCube())
				sb.append("yes\n");
			else
				sb.append("no\n");
		}
		System.out.print(sb);
	}

	/**
	 * map이 정육면체 전개도가 될 수 있는지 확인하는 메소드
	 * 
	 * @return map이 정육면체이면 true, 아니라면 false
	 */
	public static boolean isCube() {
		for (int t = 0; t < totalCube.length; t++) {
			int[][] cube = totalCube[t];
			int[][] lr_reverseCube = LR_ReverseCube(cube); // 정육면체 전개도를 좌우 반전시킨 배열
			int[][] ud_reverseCube = UD_ReverseCube(cube); // 정육면체 전개도를 상하 반전시킨 배열
			if (Search(cube) || Search(lr_reverseCube) || Search(ud_reverseCube))
				return true;
		}
		return false;
	}

	/**
	 * 전개도를 회전시키며 전개도와 map이 같은지 확인한다.
	 * 
	 * @param cube 전개도
	 * @return 전개도와 map이 같으면 true, 아니라면 false
	 */
	public static boolean Search(int[][] cube) {
		for (int i = 0; i < 4; i++) {
			if (Matching(cube))
				return true;
			cube = RotateCube(cube);
		}
		return false;
	}

	/**
	 * 전개도를 좌우 반전 시킨 배열을 구하는 메소드
	 * 
	 * @param cube 좌우 반전 시킬 전개도
	 * @return 좌우 반전 시킨 전개도
	 */
	public static int[][] LR_ReverseCube(int[][] cube) {
		int[][] reverseCube = new int[cube.length][cube[0].length];
		for (int i = 0; i < cube.length; i++)
			for (int j = 0, t = cube[0].length - 1; j < cube[0].length; j++, t--)
				reverseCube[i][j] = cube[i][t];
		return reverseCube;
	}

	/**
	 * 전개도를 상하 반전시킨 전개도를 구하는 메소드
	 * 
	 * @param cube 상하 반전시킬 전개도
	 * @return 상하 반전시킨 전개도
	 */
	public static int[][] UD_ReverseCube(int[][] cube) {
		int[][] reverseCube = new int[cube.length][cube[0].length];
		for (int i = 0, t = cube.length - 1; i < cube.length; i++, t--)
			for (int j = 0; j < cube[0].length; j++)
				reverseCube[i][j] = cube[t][j];
		return reverseCube;
	}

	/**
	 * 전개도와 map이 같은지 확인해본다.
	 * 
	 * @param cube 비교할 전개도
	 * @return 전개도와 map이 같다면 true, 아니라면 false
	 */
	public static boolean Matching(int[][] cube) {
		for (int i = 0; i + cube.length <= map.length; i++)
			next: for (int j = 0; j + cube[0].length <= map.length; j++) {
				// 전개도와 map이 같은지 확인
				for (int a = 0; a < cube.length; a++)
					for (int b = 0; b < cube[0].length; b++)
						// 전개도와 map이 다르다면 map의 다음 좌표부터 다시 탐색하도록 한다.
						if (cube[a][b] != map[i + a][j + b])
							continue next;
				// 여기까지 실행되었다면 cube와 map이 같다는 의미이므로 true를 반환한다.
				return true;
			}
		return false;
	}

	/**
	 * 전개도를 오른쪽으로 90도 회전시킨다.
	 * 
	 * @param cube 전개도
	 * @return 오른쪽으로 90도 회전시킨 전개도
	 */
	public static int[][] RotateCube(int[][] cube) {
		int[][] rotateCube = new int[cube[0].length][cube.length];
		for (int i = 0; i < cube[0].length; i++)
			for (int j = 0, t = cube.length - 1; j < cube.length; j++, t--)
				rotateCube[i][j] = cube[t][i];
		return rotateCube;
	}
}
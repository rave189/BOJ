package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 6x6 �迭�� ���� �پ��ִ� 1�� 6���� �ִ�.	
 * �� 6���� 1�� ������ü�� �������� �� �� �ִ��� ���ϴ� ����
 * 
 * @author Rave
 *
 */
public class Main {

	// ������ü�� 11���� �������� ��Ƴ��� �迭
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
	 * map�� ������ü �������� �� �� �ִ��� Ȯ���ϴ� �޼ҵ�
	 * 
	 * @return map�� ������ü�̸� true, �ƴ϶�� false
	 */
	public static boolean isCube() {
		for (int t = 0; t < totalCube.length; t++) {
			int[][] cube = totalCube[t];
			int[][] lr_reverseCube = LR_ReverseCube(cube); // ������ü �������� �¿� ������Ų �迭
			int[][] ud_reverseCube = UD_ReverseCube(cube); // ������ü �������� ���� ������Ų �迭
			if (Search(cube) || Search(lr_reverseCube) || Search(ud_reverseCube))
				return true;
		}
		return false;
	}

	/**
	 * �������� ȸ����Ű�� �������� map�� ������ Ȯ���Ѵ�.
	 * 
	 * @param cube ������
	 * @return �������� map�� ������ true, �ƴ϶�� false
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
	 * �������� �¿� ���� ��Ų �迭�� ���ϴ� �޼ҵ�
	 * 
	 * @param cube �¿� ���� ��ų ������
	 * @return �¿� ���� ��Ų ������
	 */
	public static int[][] LR_ReverseCube(int[][] cube) {
		int[][] reverseCube = new int[cube.length][cube[0].length];
		for (int i = 0; i < cube.length; i++)
			for (int j = 0, t = cube[0].length - 1; j < cube[0].length; j++, t--)
				reverseCube[i][j] = cube[i][t];
		return reverseCube;
	}

	/**
	 * �������� ���� ������Ų �������� ���ϴ� �޼ҵ�
	 * 
	 * @param cube ���� ������ų ������
	 * @return ���� ������Ų ������
	 */
	public static int[][] UD_ReverseCube(int[][] cube) {
		int[][] reverseCube = new int[cube.length][cube[0].length];
		for (int i = 0, t = cube.length - 1; i < cube.length; i++, t--)
			for (int j = 0; j < cube[0].length; j++)
				reverseCube[i][j] = cube[t][j];
		return reverseCube;
	}

	/**
	 * �������� map�� ������ Ȯ���غ���.
	 * 
	 * @param cube ���� ������
	 * @return �������� map�� ���ٸ� true, �ƴ϶�� false
	 */
	public static boolean Matching(int[][] cube) {
		for (int i = 0; i + cube.length <= map.length; i++)
			next: for (int j = 0; j + cube[0].length <= map.length; j++) {
				// �������� map�� ������ Ȯ��
				for (int a = 0; a < cube.length; a++)
					for (int b = 0; b < cube[0].length; b++)
						// �������� map�� �ٸ��ٸ� map�� ���� ��ǥ���� �ٽ� Ž���ϵ��� �Ѵ�.
						if (cube[a][b] != map[i + a][j + b])
							continue next;
				// ������� ����Ǿ��ٸ� cube�� map�� ���ٴ� �ǹ��̹Ƿ� true�� ��ȯ�Ѵ�.
				return true;
			}
		return false;
	}

	/**
	 * �������� ���������� 90�� ȸ����Ų��.
	 * 
	 * @param cube ������
	 * @return ���������� 90�� ȸ����Ų ������
	 */
	public static int[][] RotateCube(int[][] cube) {
		int[][] rotateCube = new int[cube[0].length][cube.length];
		for (int i = 0; i < cube[0].length; i++)
			for (int j = 0, t = cube.length - 1; j < cube.length; j++, t--)
				rotateCube[i][j] = cube[t][i];
		return rotateCube;
	}
}
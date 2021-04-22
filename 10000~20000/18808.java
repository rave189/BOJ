package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ��ȸ�� �����Ͽ� ��ƼĿ K���� �޾Ҵ�.
 * �� ��ƼĿ�� ��Ʈ�Ͽ� ���� ������� ���̷��� �Ѵ�.
 * �� �� ��Ʈ�Ͽ� ��ƼĿ�� ���� ĭ ���� ���ϴ� ����
 * ��Ʈ�Ͽ� ��ƼĿ�� ���̴� ������ ������ ����.
 * 1.��ƼĿ�� ȸ����Ű�� �ʰ� �����̿��� �����.
 * 2.�ٸ� ��ƼĿ�� ��ġ�ų� ��Ʈ���� ����� �����鼭 ��ƼĿ�� ���� �� �ִ� ��ġ�� ã�´�.
 *   �����̴� ��Ʈ���� ���ʺ��� ��ƼĿ�� ä�� �������� �ؼ�, ��ƼĿ�� ���� �� �ִ� ��ġ�� ���� �� �ִٸ� ���� ������ ��ġ�� �����Ѵ�.
 *   ���� ���ʿ� �ش��ϴ� ��ġ�� ���� ���� �ִٸ� ���߿��� ���� ������ ��ġ�� �����Ѵ�.
 * 3.������ ��ġ�� ��ƼĿ�� ���δ�. ���� ��ƼĿ�� ���� �� �ִ� ��ġ�� ���� ��� ��ƼĿ�� ������ ���ߴٸ�,
 *   ��ƼĿ�� �ð� �������� 90�� ȸ���� �� 2�� ������ �ݺ��Ѵ�.
 * 4.���� ������ �� �� �ݺ��ؼ� ��ƼĿ�� 0��, 90��, 180��, 270�� ȸ������ �������� ��ƼĿ�� ������ ���ߴٸ� �ش� ��ƼĿ�� ������ �ʰ� ������.
 * @author Rave
 *
 */
public class Main {

	// ��Ʈ��
	static int[][] notebook;
	// ��ƼĿ�� ������ �迭
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
				// ��ƼĿ�� �ٿ��ٸ� �����Ѵ�.
				if (isAttach(sticker))
					break;
				// ��ƼĿ�� ���� �� ���ٸ� 3������ ȸ���� ���Ѻ���.
				else if (j != 3)
					sticker = Rotation(sticker);
		}
		System.out.println(answer);
	}

	/**
	 * �� �������� ��ƼĿ�� ���� �� �ִ��� Ȯ���غ���.
	 * ���� �� �ִٸ� ��ƼĿ�� ���δ�.
	 * @param sticker ��Ʈ�Ͽ� ���� ��ƼĿ
	 * @return ��ƼĿ�� �ٿ��ٸ� true, �ƴ϶�� false
	 */
	public static boolean isAttach(int[][] sticker) {
		for (int i = 0; i < notebook.length; i++)
			for (int j = 0; j < notebook[0].length; j++)
				// (i, j) ������ ��ƼĿ�� ���� �� �ִ��� Ȯ���Ѵ�.
				if (isAble(i, j, sticker)) {
					// ��ƼĿ�� ���� �� �ִٸ� ���δ�.
					Attach(i, j, sticker);
					return true;
				}
		return false;
	}

	/**
	 * ��Ʈ���� (x, y) ������ ��ƼĿ�� ���� �� �ִ��� Ȯ���ϴ� �޼ҵ�
	 * @param x ��Ʈ���� x��ǥ
	 * @param y ��Ʈ���� y��ǥ
	 * @param sticker ���� ��ƼĿ
	 * @return ���� �� �ִٸ� true, �ƴ϶�� false
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
	 * ��Ʈ�Ͽ� ��ƼĿ�� ���δ�.
	 * @param x ��Ʈ���� x��ǥ
	 * @param y ��Ʈ���� y��ǥ
	 * @param sticker ���� ��ƼĿ
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
	 * ��ƼĿ�� �ð� �������� 90�� ȸ����Ű�� �޼ҵ�
	 * @param sticker ȸ����ų ��ƼĿ
	 * @return �ð� �������� 90�� ȸ����Ų ��ƼĿ
	 */
	public static int[][] Rotation(int[][] sticker) {
		int[][] rotate = new int[sticker[0].length][sticker.length];
		for (int i = 0, t = sticker.length - 1; i < sticker.length; i++, t--)
			for (int j = 0; j < sticker[0].length; j++)
				rotate[j][t] = sticker[i][j];
		return rotate;
	}
}
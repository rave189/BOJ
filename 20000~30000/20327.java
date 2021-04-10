package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ������ ������ ���� �迭�� ������ ����
 * ������ �迭�� �κ� �迭�� ���� �� ������ �����Ѵ�.
 * �κ� �迭�� (2^l)x(2^l)�� ũ�⸦ ������.
 * 1�� ����: �� �κ� �迭�� ���� ������Ų��.
 * 2�� ����: �� �κ� �迭�� �¿� ������Ų��.
 * 3�� ����: �� �κ� �迭�� ���������� 90�� ȸ����Ų��.
 * 4�� ����: �� �κ� �迭�� �������� 90�� ȸ����Ų��.
 * 5�� ������ʹ� �κ� �迭�� �� ĭ�̶�� �����ϰ� ������ �����Ѵ�.
 * 5�� ����: �迭�� ���� ������Ų��.
 * 6�� ����: �迭�� �¿� ������Ų��.
 * 7�� ����: �迭�� ���������� 90�� ȸ����Ų��.
 * 8�� ����: �迭�� �������� 90�� ȸ����Ų��.
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static int powL; // �κ� �迭�� ũ��

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		// �迭�� 2^n�� ũ��� �����Ѵ�.
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
			// �� ���꿡 ���� �ٸ� �޼ҵ带 �����Ѵ�.
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
	 * 1,2,3,4���� ������ �����ϴ� �޼ҵ�
	 * 1,2,3,4���� ������ �κ� �迭 �ȿ��� ������ �����Ѵ�.
	 * @param k ������ ������ ��ȣ
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
	 * 1�� ����
	 * �������� ���ڷ� �޾� ���������� ������+powL������ ���� ���� ������Ų��.
	 * @param startX ������ x
	 * @param startY ������ y
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
	 * 2�� ����
	 * ���������� powL������ ���� �¿� ������Ų��.
	 * @param startX ������ x
	 * @param startY ������ y
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
	 * 3�� ����
	 * ���������� powL������ ���� 90�� ȸ����Ų��.
	 * @param startX ������ x
	 * @param startY ������ y
	 */
	public static void Three(int startX, int startY) {
		int[][] tmp = new int[powL][powL];
		int endX = startX + powL;
		int endY = startY + powL;
		// tmp�� ���� �����Ѵ�.
		for (int i = 0; i < powL; i++)
			for (int j = 0, t = powL - 1; j < powL; j++, t--)
				tmp[i][j] = map[startX + t][startY + i];
		// �ٽ� map�� tmp�� ���� �ٿ��ִ´�.
		for (int i = startX, a = 0; i < endX; i++, a++)
			for (int j = startY, b = 0; j < endY; j++, b++)
				map[i][j] = tmp[a][b];
	}

	/**
	 * 4�� ����
	 * ���������� powL������ ���� �������� 90�� ȸ����Ų��.
	 * @param startX ������ x
	 * @param startY ������ y
	 */
	public static void Four(int startX, int startY) {
		int[][] tmp = new int[powL][powL];
		int endX = startX + powL;
		int endY = startY + powL;
		// tmp�� ���� �����Ѵ�.
		for (int i = 0, t = powL - 1; i < powL; i++, t--)
			for (int j = 0; j < powL; j++)
				tmp[i][j] = map[startX + j][startY + t];
		// �ٽ� map�� tmp�� ���� �ٿ��ִ´�.
		for (int i = startX, a = 0; i < endX; i++, a++)
			for (int j = startY, b = 0; j < endY; j++, b++)
				map[i][j] = tmp[a][b];
	}

	/**
	 * 5�� ����
	 * �迭�� ��ü ���� ������Ų��.
	 * ���� ������ �κ� �迭������ �̷������ �Ѵ�.
	 */
	public static void Five() {
		for (int i = 0; i < map.length / 2; i += powL)
			for (int j = 0; j < map.length; j += powL)
				Swap(i, j, map.length - powL - i, j);
	}

	/**
	 * 6�� ����
	 * �迭�� ��ü �¿� ������Ų��.
	 * �¿� ������ �κ� �迭������ �̷������ �Ѵ�.
	 */
	public static void Six() {
		for (int i = 0; i < map.length; i += powL)
			for (int j = 0; j < map.length / 2; j += powL)
				Swap(i, j, i, map.length - powL - j);
	}

	/**
	 * ������ �׷� ������ �̷������ �ϱ� ������
	 * 1�� �׷��� �������� 2�� �׷��� �������� �޾� ������ + powL������ ���� ���� �ٲ۴�.
	 * @param x1 1�� �׷��� ������ x
	 * @param y1 1�� �׷��� ������ y
	 * @param x2 2�� �׷��� ������ x
	 * @param y2 2�� �׷��� ������ y
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
	 * 7�� ����
	 * ��ü �迭�� ���������� 90�� ȸ����Ų��.
	 * ȸ���� �κ� �迭 ������ �̷������ �Ѵ�.
	 * �ӽ� �迭 tmp�� ����� ȸ���� ���� ������ �����ϰ� map�� �ִ´�.
	 */
	public static void Seven() {
		int[][] tmp = new int[map.length][map.length];
		for (int i = 0; i < map.length; i += powL)
			for (int j = 0, t = map.length - powL; j < map.length; j += powL, t -= powL)
				GroupMove(tmp, i, j, t, i);
		map = tmp;
	}

	/**
	 * 8�� ����
	 * ��ü �迭�� �������� 90�� ȸ����Ų��.
	 * ȸ���� �κ� �迭 ������ �̷������ �Ѵ�.
	 * �ӽ� �迭 tmp�� ����� ȸ���� ���� ������ �����ϰ� map�� �ִ´�.
	 */
	public static void Eight() {
		int[][] tmp = new int[map.length][map.length];
		for (int i = 0, t = map.length - powL; i < map.length; i += powL, t -= powL)
			for (int j = 0; j < map.length; j += powL)
				GroupMove(tmp, i, j, j, t);
		map = tmp;
	}

	/**
	 * 2�� �׷��� 1�� �׷����� �ű�� �޼ҵ�
	 * 2�� �׷��� �������� �޾� ������ + powL������ ������ 1�� �׷쿡 �ִ´�.
	 * @param tmp ȸ���� ������ �迭
	 * @param x1 1�� �׷��� ������ x
	 * @param y1 1�� �׷��� ������ y
	 * @param x2 2�� �׷��� ������ x
	 * @param y2 2�� �׷��� ������ y
	 */
	public static void GroupMove(int[][] tmp, int x1, int y1, int x2, int y2) {
		for (int i = x1, a = x2; i < x1 + powL; i++, a++)
			for (int j = y1, b = y2; j < y1 + powL; j++, b++)
				tmp[i][j] = map[a][b];
	}

	/**
	 * �迭�� ����ϴ� �޼ҵ�
	 */
	public static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
	}
}
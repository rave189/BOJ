package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �� ĭ�� ���� ������ü�� ������ �־����� ��
 * �� ������ �ѳ��̸� ���ϴ� ����
 * @author Rave
 */
public class Main {

	/**
	 * ���� �Է�
	 * 3 3
	 * 1 3 4
	 * 2 2 3
	 * 1 2 4
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		// �迭�� ũ�⸦ 1 �������� FindArea���� ������ �ε������� ������ �� �ֵ��� �Ѵ�.
		int[][] map = new int[n][m + 1];
		// map�� ���η� Ž���ϱ� ���ϵ��� ��Ī�̵� ��Ų �迭
		int[][] rotateMap = new int[m][n + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				rotateMap[j][i] = map[i][j];
			}
		}
		int answer = 0;
		// ��, �� ���� �ѳ��̸� ���Ѵ�.
		for (int i = 0; i < n; i++)
			answer += FindArea(map[i]);
		// ��, �� ���� �ѳ��̸� ���Ѵ�.
		for (int i = 0; i < m; i++)
			answer += FindArea(rotateMap[i]);
		System.out.println(answer + (n * m * 2));
	}

	/**
	 * ���ʸ��� ���̿� �������� ���Ͽ� �ѳ��̸� ���� �� �ִ�.
	 * �迭�� ũ�⸦ �ϳ� �÷����Ƽ� �������� ���̱��� ������ �� �ִ�.
	 * @param row �ѳ��̸� ���� �迭
	 * @return �ѳ���
	 */
	public static int FindArea(int[] row) {
		int sum = row[0];
		for (int i = 1; i < row.length; i++)
			sum += Math.abs(row[i] - row[i - 1]);
		return sum;
	}
}
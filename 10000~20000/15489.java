package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �Ľ�Į�� �ﰢ������ (r, c)�� ���������� �ϴ�
 * ���� ���̰� w�� ���ﰢ���� ������ ���� ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * �Ľ�Į�� �ﰢ���� ���� �� �� ���� ���̰� w�� ���ﰢ���� ������ ���� ���Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[][] triangle = new int[r + w][];
		for (int i = 0; i < triangle.length; i++) {
			triangle[i] = new int[i + 1];
			for (int j = 0; j < i + 1; j++) {
				try {
					triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
				} catch (Exception e) {
					triangle[i][j] = 1;
				}
			}
		}
		int answer = 0;
		for (int i = r - 1, t = 0; i < r + w - 1; i++, t++)
			for (int j = c - 1; j < c + t; j++)
				answer += triangle[i][j];
		System.out.println(answer);
	}
}
package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 파스칼의 삼각형에서 (r, c)를 꼭짓점으로 하는
 * 변의 길이가 w인 정삼각형의 내부의 값의 합을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 파스칼의 삼각형을 만든 후 한 변의 길이가 w인 정삼각형의 내부의 합을 구한다.
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
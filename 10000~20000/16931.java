package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 각 칸에 놓인 정육면체의 개수가 주어졌을 때
 * 이 도형의 겉넓이를 구하는 문제
 * @author Rave
 */
public class Main {

	/**
	 * 예제 입력
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
		// 배열의 크기를 1 증가시켜 FindArea에서 마지막 인덱스까지 더해줄 수 있도록 한다.
		int[][] map = new int[n][m + 1];
		// map을 세로로 탐색하기 편하도록 대칭이동 시킨 배열
		int[][] rotateMap = new int[m][n + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				rotateMap[j][i] = map[i][j];
			}
		}
		int answer = 0;
		// 좌, 우 면의 겉넓이를 구한다.
		for (int i = 0; i < n; i++)
			answer += FindArea(map[i]);
		// 상, 하 면의 겉넓이를 구한다.
		for (int i = 0; i < m; i++)
			answer += FindArea(rotateMap[i]);
		System.out.println(answer + (n * m * 2));
	}

	/**
	 * 왼쪽면의 넓이에 높이차를 더하여 겉넓이를 구할 수 있다.
	 * 배열의 크기를 하나 늘려놓아서 오른쪽의 넓이까지 더해줄 수 있다.
	 * @param row 겉넓이를 구할 배열
	 * @return 겉넓이
	 */
	public static int FindArea(int[] row) {
		int sum = row[0];
		for (int i = 1; i < row.length; i++)
			sum += Math.abs(row[i] - row[i - 1]);
		return sum;
	}
}
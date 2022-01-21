package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배열을 돌리는 문제
 * 연산은 6개가 있다.
 * 1번은 배열을 상하 반전시키는 연산
 * 2번은 좌우 반전 시키는 연산
 * 3번은 오른쪽으로 90도 회전하는 연산
 * 4번은 왼쪽으로 90도 회전하는 연산
 * 5번과 6번은 배열을 4개의 부분 배열로 나눈 뒤 연산을 한다.
 * 5번은 그룹1은 그룹2로 그룹2는 그룹3으로 그룹3은 그룹4로 그룹4는 그룹1로 이동하는 연산
 * 6번은 그룹1은 그룹4로 그룹4는 그룹3으로 그룹3은 그룹2로 그룹2는 그룹1로 이동하는 연산
 * @author Rave
 *
 */
public class Main {

	static int[][] map;
	static Point[] pointArr;

	/**
	 * 문제에 조건에 맞게 이동하는 연산을 구현한다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < t; i++) {
			int rotate = Integer.parseInt(st.nextToken());
			PointSet();
			switch (rotate) {
			case 1:
				One(rotate);
				break;
			case 2:
				Two(rotate);
				break;
			case 3:
				Three(rotate);
				break;
			case 4:
				Four(rotate);
				break;
			case 5:
				Five(rotate);
				break;
			case 6:
				Six(rotate);
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++)
				sb.append(map[i][j] + " ");
			sb.append("\n");
		}
		System.out.print(sb);
	}

	public static void PointSet() {
		pointArr = new Point[] { new Point(0, 0), new Point(0, map[0].length / 2), new Point(map.length / 2, 0),
				new Point(map.length / 2, map[0].length / 2), new Point(map.length / 2, map[0].length),
				new Point(map.length, map[0].length / 2), new Point(map.length, map[0].length) };
	}

	public static void One(int rotate) {
		int[][] tmp = new int[map.length][map[0].length];
		for (int i = 0, t = map.length - 1; i < map.length; i++, t -= 2)
			for (int j = 0; j < map[0].length; j++)
				tmp[i][j] = map[i + t][j];
		map = tmp;
	}

	public static void Two(int rotate) {
		int[][] tmp = new int[map.length][map[0].length];
		for (int i = 0; i < map.length; i++)
			for (int j = 0, t = map[0].length - 1; j < map[0].length; j++, t -= 2)
				tmp[i][j] = map[i][j + t];
		map = tmp;
	}

	public static void Three(int rotate) {
		int[][] tmp = new int[map[0].length][map.length];
		for (int i = 0; i < map[0].length; i++)
			for (int j = 0, t = map.length - 1; j < map.length; j++, t--)
				tmp[i][j] = map[t][i];
		map = tmp;
	}

	public static void Four(int rotate) {
		int[][] tmp = new int[map[0].length][map.length];
		for (int i = 0, t = map[0].length - 1; i < map[0].length; i++, t--)
			for (int j = 0; j < map.length; j++)
				tmp[i][j] = map[j][t];
		map = tmp;
	}

	public static void Five(int rotate) {
		int[][] tmp = new int[map.length][map[0].length];
		GroupMove(map, tmp, pointArr[0], pointArr[3], pointArr[1], pointArr[4]);
		GroupMove(map, tmp, pointArr[1], pointArr[4], pointArr[3], pointArr[6]);
		GroupMove(map, tmp, pointArr[3], pointArr[6], pointArr[2], pointArr[5]);
		GroupMove(map, tmp, pointArr[2], pointArr[5], pointArr[0], pointArr[3]);
		map = tmp;
	}

	public static void Six(int rotate) {
		int[][] tmp = new int[map.length][map[0].length];
		GroupMove(map, tmp, pointArr[0], pointArr[3], pointArr[2], pointArr[5]);
		GroupMove(map, tmp, pointArr[1], pointArr[4], pointArr[0], pointArr[3]);
		GroupMove(map, tmp, pointArr[3], pointArr[6], pointArr[1], pointArr[4]);
		GroupMove(map, tmp, pointArr[2], pointArr[5], pointArr[3], pointArr[6]);
		map = tmp;
	}

	public static void GroupMove(int[][] map, int[][] tmp, Point s1, Point e1, Point s2, Point e2) {
		for (int i = s1.x, a = s2.x; i < e1.x; i++, a++)
			for (int j = s1.y, b = s2.y; j < e1.y; j++, b++)
				tmp[a][b] = map[i][j];
	}
}

class Point {
	int x, y;

	public Point(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}
}
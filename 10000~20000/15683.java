import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static ArrayList<Point> cctv;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		cctv = new ArrayList<Point>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					answer++;
				else if (map[i][j] != 6)
					cctv.add(new Point(i, j, map[i][j]));
			}
		}
		Solution(0);
		System.out.println(answer);
	}

	public static void Solution(int index) {
		if (index == cctv.size()) {
			int zeroSum = ZeroSum();
			answer = Math.min(answer, zeroSum);
		} else {
			Point cur = cctv.get(index);
			int cctvNum = cur.type;
			int[][] tmp = new int[map.length][map[0].length];
			int direction = 0;
			switch (cctvNum) {
			case 1:
				for (int i = 0; i < 4; i++, direction++) {
					CopyArr(tmp, map);
					Search(cur, direction, cctvNum);
					Solution(index + 1);
					CopyArr(map, tmp);
				}
				break;
			case 2:
				for (int i = 0; i < 2; i++, direction++) {
					CopyArr(tmp, map);
					Search(cur, direction, cctvNum);
					Search(cur, direction + 2, cctvNum);
					Solution(index + 1);
					CopyArr(map, tmp);
				}
				break;
			case 3:
				direction = 3;
				for (int i = 0; i < 4; i++, direction++) {
					CopyArr(tmp, map);
					Search(cur, direction % 4, cctvNum);
					Search(cur, (direction + 1) % 4, cctvNum);
					Solution(index + 1);
					CopyArr(map, tmp);
				}
				break;
			case 4:
				direction = 2;
				for (int i = 0; i < 4; i++, direction++) {
					CopyArr(tmp, map);
					Search(cur, direction % 4, cctvNum);
					Search(cur, (direction + 1) % 4, cctvNum);
					Search(cur, (direction + 2) % 4, cctvNum);
					Solution(index + 1);
					CopyArr(map, tmp);
				}
				break;
			case 5:
				CopyArr(tmp, map);
				for (int i = 0; i < 4; i++, direction++)
					Search(cur, direction, cctvNum);
				Solution(index + 1);
				CopyArr(map, tmp);
			}
		}
	}

	public static void Search(Point cur, int direction, int value) {
		switch (direction) {
		case 0:
			for (int i = cur.y + 1; i < map[0].length; i++)
				if (!Check(cur.x, i, value))
					return;
			break;
		case 1:
			for (int i = cur.x + 1; i < map.length; i++)
				if (!Check(i, cur.y, value))
					return;
			break;
		case 2:
			for (int i = cur.y - 1; i >= 0; i--)
				if (!Check(cur.x, i, value))
					return;
			break;
		case 3:
			for (int i = cur.x - 1; i >= 0; i--)
				if (!Check(i, cur.y, value))
					return;
		}
	}

	public static boolean Check(int x, int y, int value) {
		if (map[x][y] == 6)
			return false;
		map[x][y] = value;
		return true;
	}

	public static int ZeroSum() {
		int sum = 0;
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map[0].length; j++)
				if (map[i][j] == 0)
					sum++;
		return sum;
	}

	public static void CopyArr(int[][] arr1, int[][] arr2) {
		for (int i = 0; i < arr1.length; i++)
			for (int j = 0; j < arr1[0].length; j++)
				arr1[i][j] = arr2[i][j];
	}
}

class Point {
	int x;
	int y;
	int type;

	public Point(int _x, int _y, int _type) {
		this.x = _x;
		this.y = _y;
		this.type = _type;
	}
}

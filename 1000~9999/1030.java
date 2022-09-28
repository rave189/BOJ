package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] map;
	static int n, k, r1, r2, c1, c2, blackStart, blackEnd;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		r1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		blackStart = (n - k) / 2;
		blackEnd = n - blackStart;
		map = new boolean[r2 - r1 + 1][c2 - c1 + 1];
		divide(0, 0, (int) Math.pow(n, s), false);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++)
				sb.append(map[i][j] ? 1 : 0);
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static void divide(int x, int y, int size, boolean isBlack) {
		if (x > r2 || y > c2 || x + size <= r1 || y + size <= c1)
			return;
		if (size == 1) {
			map[x - r1][y - c1] = isBlack;
			return;
		}
		int nextSize = size / n;
		for (int i = 0; i < n; i++) {
			int nx = x + nextSize * i;
			for (int j = 0; j < n; j++) {
				int ny = y + nextSize * j;
				divide(nx, ny, nextSize,
						isBlack || ((blackStart <= i && i < blackEnd) && (blackStart <= j && j < blackEnd)));
			}
		}
	}
}
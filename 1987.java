import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static String[][] arr;
	static boolean[] check;
	static int[] dstX = { 0, 0, -1, 1 };
	static int[] dstY = { 1, -1, 0, 0 };
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		arr = new String[r][c];
		for (int i = 0; i < r; i++) {
			String line = br.readLine();
			for (int j = 0; j < c; j++)
				arr[i][j] = line.substring(j, j + 1);
		}
		check = new boolean[26];
		check[arr[0][0].charAt(0) - 65] = true;
		Back(0, 0, 1);
		bw.write(Integer.toString(max));
		bw.flush();
	}

	public static void Back(int x, int y, int count) {
		if (count > max)
			max = count;
		for (int i = 0; i < 4; i++) {
			int nextX = x + dstX[i];
			int nextY = y + dstY[i];
			if ((0 <= nextX && nextX < arr.length) && (0 <= nextY && nextY < arr[0].length)) {
				String tmp = arr[nextX][nextY];
				char tmp2 = arr[nextX][nextY].charAt(0);
				int checkNumber = arr[nextX][nextY].charAt(0) - 65;
				if (!check[checkNumber]) {
					check[checkNumber] = true;
					Back(nextX, nextY, count + 1);
					check[checkNumber] = false;
				}
			}
		}
	}
}

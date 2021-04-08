import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static boolean[][] check;
	static int count = 0;
	static int[] dstX = { 0, 0, -1, 1 };
	static int[] dstY = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		check = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		int picture = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				count = 0;
				if (!check[i][j] && arr[i][j] == 1) {
					BFS(i, j);
					picture++;
					if (max < count)
						max = count;
				}
			}
		}
		bw.write(picture + "\n" + max);
		bw.flush();
	}

	public static void BFS(int x, int y) {
		if (arr[x][y] == 0) {
			return;
		} else {
			check[x][y] = true;
			for (int i = 0; i < 4; i++) {
				int moveX = x + dstX[i];
				int moveY = y + dstY[i];
				if (0 <= moveX && moveX < arr.length && 0 <= moveY && moveY < arr[0].length)
					if (!check[moveX][moveY])
						BFS(moveX, moveY);
			}
			count++;
		}
	}
}

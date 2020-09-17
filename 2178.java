import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(line[j]);
		}
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
		int[][] result = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				result[i][j] = Integer.MAX_VALUE;
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0, 0));
		result[0][0] = 1;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			int curCount = result[cur.x][cur.y];
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < m)
					if (arr[nx][ny] == 1 && curCount + 1 < result[nx][ny]) {
						q.add(new Point(nx, ny));
						result[nx][ny] = curCount + 1;
					}
			}
		}
		bw.write(Integer.toString(result[n - 1][m - 1]));
		bw.flush();
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

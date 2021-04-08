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
		Queue<Point> cur = new LinkedList<Point>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1)
					cur.add(new Point(i, j));
				arr[i][j] = num;
			}
		}
		int count = 0;
		while (!cur.isEmpty()) {
			Queue<Point> next = new LinkedList<Point>();
			while (!cur.isEmpty()) {
				Point point = cur.poll();
				for (int i = 0; i < 4; i++) {
					int nx = point.x + dx[i];
					int ny = point.y + dy[i];
					if (0 <= nx && nx < n && 0 <= ny && ny < m)
						if (arr[nx][ny] == 0) {
							arr[nx][ny] = 1;
							next.add(new Point(nx, ny));
						}
				}
			}
			cur = next;
			if (!cur.isEmpty())
				count++;
		}
		if (Check(arr))
			bw.write(Integer.toString(count));
		else
			bw.write("-1");
		bw.flush();
	}

	public static boolean Check(int[][] arr) {
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[0].length; j++)
				if (arr[i][j] == 0)
					return false;
		return true;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		Study[] arr = new Study[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());
			arr[i] = new Study(time, point);
		}
		int[][] map = new int[n + 1][t + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= t; j++) {
				int time = arr[i - 1].time;
				int point = arr[i - 1].point;
				if (j - time >= 0)
					map[i][j] = Math.max(point + map[i - 1][j - time], map[i - 1][j]);
				else
					map[i][j] = map[i - 1][j];
			}
		}
		System.out.println(map[n][t]);
	}
}

class Study {
	int time;
	int point;

	public Study(int _time, int _point) {
		this.time = _time;
		this.point = _point;
	}
}

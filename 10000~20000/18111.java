import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static long answerTime = Integer.MAX_VALUE;
	static int answerHeight = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int height = Integer.parseInt(st.nextToken());
				map[i][j] = height;
				max = Math.max(max, height);
				min = Math.min(min, height);
			}
		}
		for (int height = min; height <= max; height++)
			Search(height, b);
		System.out.println(answerTime + " " + answerHeight);
	}

	public static void Search(int height, int bag) {
		int time = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				int diff = map[i][j] - height;
				if (diff > 0) {
					bag += diff;
					time += diff * 2;
				} else if (diff < 0) {
					diff = Math.abs(diff);
					bag -= diff;
					time += diff;
				}
			}
		}
		if (bag < 0)
			return;
		if (answerTime == time && height > answerHeight)
			answerHeight = height;
		else if (time < answerTime) {
			answerTime = time;
			answerHeight = height;
		}
	}
}

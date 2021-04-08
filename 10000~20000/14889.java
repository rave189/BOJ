import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[] selected;
	static long answer = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		selected = new boolean[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		Search(0, 0);
		System.out.println(answer);
	}

	public static void Search(int select, int depth) {
		if (depth == map.length / 2) {
			Check();
		} else
			for (int i = select; i < map.length; i++)
				if (!selected[i]) {
					selected[i] = true;
					Search(i + 1, depth + 1);
					selected[i] = false;
				}
	}

	public static void Check() {
		long startSum = 0;
		long linkSum = 0;
		for (int i = 0; i < selected.length; i++)
			for (int j = i + 1; j < selected.length; j++)
				if (selected[i] && selected[j])
					startSum += map[i][j] + map[j][i];
				else if (!selected[i] && !selected[j])
					linkSum += map[i][j] + map[j][i];
		answer = Math.min(answer, Math.abs(startSum - linkSum));
	}
}

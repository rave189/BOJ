import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[] check;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		check = new boolean[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++) {
			check[i] = true;
			Search(i, i, 0, 1);
			check[i] = false;
		}
		System.out.println(answer);
	}

	public static void Search(int first, int next, int sum, int depth) {
		if (depth == map.length && map[next][first] != 0) {
			answer = Math.min(answer, sum + map[next][first]);
			return;
		}
		for (int i = 0; i < map.length; i++) {
			if (map[next][i] == 0 || i == next || check[i])
				continue;
			check[i] = true;
			Search(first, i, sum + map[next][i], depth + 1);
			check[i] = false;
		}
	}
}

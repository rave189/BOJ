import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Backpack[] arr = new Backpack[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[i] = new Backpack(weight, cost);
		}
		int[][] map = new int[n + 1][k + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				int weight = arr[i - 1].weight;
				int cost = arr[i - 1].cost;
				if (j - weight >= 0)
					map[i][j] = Math.max(cost + map[i - 1][j - weight], map[i - 1][j]);
				else
					map[i][j] = map[i - 1][j];
			}
		}
		System.out.println(map[n][k]);
	}
}

class Backpack {
	int weight;
	int cost;

	public Backpack(int _weight, int _cost) {
		this.weight = _weight;
		this.cost = _cost;
	}
}

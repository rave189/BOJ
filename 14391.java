import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] map;
	static int n;
	static int m;
	static boolean[] visited;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		map = new int[n * m];
		visited = new boolean[n * m];
		for (int i = 0; i < n; i++) {
			line = br.readLine().split("");
			for (int j = 0; j < m; j++)
				map[i * m + j] = Integer.parseInt(line[j]);
		}
		Search(0);
		System.out.println(answer);
	}

	public static void Search(int index) {
		if (index == map.length) {
			Check();
			return;
		}

		visited[index] = false;
		Search(index + 1);

		visited[index] = true;
		Search(index + 1);
	}

	public static void Check() {
		int totalRow = rowSum();
		int totalCol = colSum();
		answer = Math.max(answer, totalRow + totalCol);
	}

	public static int rowSum() {
		int rowSum = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0, index = i * m; j < m; j++, index++) {
				if (!visited[index])
					sum = sum * 10 + map[index];
				else {
					rowSum += sum;
					sum = 0;
				}
			}
			rowSum += sum;
		}
		return rowSum;
	}

	public static int colSum() {
		int colSum = 0;
		for (int i = 0; i < m; i++) {
			int sum = 0;
			for (int j = i; j < map.length; j += m) {
				if (visited[j])
					sum = sum * 10 + map[j];
				else {
					colSum += sum;
					sum = 0;
				}
			}
			colSum += sum;
		}
		return colSum;
	}
}

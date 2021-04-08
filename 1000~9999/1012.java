import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static boolean[][] check;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			String[] line = br.readLine().split(" ");
			int m = Integer.parseInt(line[0]);
			int n = Integer.parseInt(line[1]);
			int location = Integer.parseInt(line[2]);
			arr = new int[m][n];
			check = new boolean[m][n];
			int count = 0;
			for (int j = 0; j < location; j++) {
				String[] point = br.readLine().split(" ");
				arr[Integer.parseInt(point[0])][Integer.parseInt(point[1])] = 1;
			}
			for (int j = 0; j < m; j++)
				for (int t = 0; t < n; t++)
					if (arr[j][t] == 1 && !check[j][t]) {
						Search(j, t);
						count++;
					}
			System.out.println(count);
		}
	}

	public static void Search(int x, int y) {
		if (check[x][y])
			return;
		check[x][y] = true;
		if (y - 1 >= 0 && arr[x][y - 1] == 1)
			Search(x, y - 1);
		if (x - 1 >= 0 && arr[x - 1][y] == 1)
			Search(x - 1, y);
		if (y + 1 < check[0].length && arr[x][y + 1] == 1)
			Search(x, y + 1);
		if (x + 1 < check.length && arr[x + 1][y] == 1)
			Search(x + 1, y);
	}
}

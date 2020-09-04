import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static boolean[] check;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		check = new boolean[n + 1];
		check[1] = true;
		Back(1);
		bw.write(Integer.toString(count));
		bw.flush();
	}

	public static void Back(int n) {
		if (check[n]) {
			for (int i = 1; i < arr.length; i++)
				if (arr[n][i] == 1 && !check[i]) {
					check[i] = true;
					count++;
					Back(i);
				}
		}
	}
}

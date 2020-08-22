import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n + 1][m + 1];
		arr[1][1] = 1;
		int col = 1;
		int row = 1;
		if (k != 0) {
			col = (k - 1) / m + 1;
			row = k - (col - 1) * m;
			for (int i = 1; i <= col; i++) {
				for (int j = 1; j <= row; j++) {
					if (i + 1 <= col)
						arr[i + 1][j] += arr[i][j];
					if (j + 1 <= row)
						arr[i][j + 1] += arr[i][j];
				}
			}
		}
		for (int i = col; i <= n; i++) {
			for (int j = row; j <= m; j++) {
				if (i + 1 <= n)
					arr[i + 1][j] += arr[i][j];
				if (j + 1 <= m)
					arr[i][j + 1] += arr[i][j];
			}
		}
		bw.write(Integer.toString(arr[n][m]));
		bw.flush();
	}
}

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
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		long[][] result = new long[n][n];
		result[0][0] = 1;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (i != n - 1 || j != n - 1)
					if (result[i][j] != 0) {
						if (i + arr[i][j] < n)
							result[i + arr[i][j]][j] += result[i][j];
						if (j + arr[i][j] < n)
							result[i][j + arr[i][j]] += result[i][j];
					}
		bw.write(Long.toString(result[n - 1][n - 1]));
		bw.flush();
	}
}

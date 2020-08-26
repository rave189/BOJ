import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] A = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		int k = Integer.parseInt(st.nextToken());
		int[][] B = new int[m][k];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < k; j++)
				B[i][j] = Integer.parseInt(st.nextToken());
		}
		int[][] result = new int[n][k];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < k; j++)
				for (int t = 0; t < m; t++)
					result[i][j] += A[i][t] * B[t][j];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++)
				sb.append(Integer.toString(result[i][j]) + " ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

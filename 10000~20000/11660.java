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
		int[][] arr = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		int prev = 0;
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= n; j++) {
				arr[i][j] += prev;
				prev = arr[i][j];
			}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int[] point = new int[4];
			for (int j = 0; j < 4; j++)
				point[j] = Integer.parseInt(st.nextToken());
			int sum = 0;
			for (int j = point[0]; j <= point[2]; j++)
				sum += arr[j][point[3]] - arr[j][point[1] - 1];
			sb.append(sum + "\n");
		}
		System.out.println(sb);
	}
}

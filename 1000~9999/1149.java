import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		int[][] result = new int[n][3];
		for (int i = 0; i < result[0].length; i++)
			result[0][i] = arr[0][i];
		for (int i = 1; i < n; i++) {
			result[i][0] = arr[i][0] + Math.min(result[i - 1][1], result[i - 1][2]);
			result[i][1] = arr[i][1] + Math.min(result[i - 1][0], result[i - 1][2]);
			result[i][2] = arr[i][2] + Math.min(result[i - 1][0], result[i - 1][1]);
		}
		System.out.println(Integer.toString(Math.min(result[n - 1][0], Math.min(result[n - 1][1], result[n - 1][2]))));
	}
}

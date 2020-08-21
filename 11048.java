import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				arr[i][j] = input.nextInt();
		int[][] result = new int[n][m];
		result[0][0] = arr[0][0];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				if (j > 0 && arr[i][j] + result[i][j - 1] > result[i][j])
					result[i][j] = arr[i][j] + result[i][j - 1];
				if (i > 0 && arr[i][j] + result[i - 1][j] > result[i][j])
					result[i][j] = arr[i][j] + result[i - 1][j];
				if ((i > 0 && j > 0) && arr[i][j] + result[i - 1][j - 1] > result[i][j])
					result[i][j] = arr[i][j] + result[i - 1][j - 1];
			}
		System.out.println(result[n-1][m-1]);
	}
}

/**
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
		int[][] arr = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++)
				arr[i][j] += Math.max(arr[i][j - 1], arr[i - 1][j]) + Integer.parseInt(st.nextToken());
		}
		bw.write(Integer.toString(arr[n][m]));
		bw.flush();
	}
}
*/

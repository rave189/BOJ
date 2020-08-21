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
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (arr[j][0] < arr[j - 1][0]) {
					int tmpA = arr[j][0];
					int tmpB = arr[j][1];
					arr[j][0] = arr[j - 1][0];
					arr[j][1] = arr[j - 1][1];
					arr[j - 1][0] = tmpA;
					arr[j - 1][1] = tmpB;
				}
			}
		}
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = 1;
			for (int j = 0; j < i; j++) {
				if ((arr[j][0] < arr[i][0] && arr[j][1] < arr[i][1]) && result[i] < result[j] + 1)
					result[i] = result[j] + 1;
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++)
			max = Math.max(max, result[i]);
		bw.write(Integer.toString(n - max));
		bw.flush();
	}
}

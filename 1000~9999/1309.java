import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	final static int mod = 9901;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][3];
		for (int i = 0; i < 3; i++)
			arr[0][i] = 1;
		for (int i = 1; i < n; i++) {
			arr[i][0] = (arr[i - 1][0] % mod + arr[i - 1][1] % mod + arr[i - 1][2] % mod) % mod;
			arr[i][1] = (arr[i - 1][0] % mod + arr[i - 1][2] % mod) % mod;
			arr[i][2] = (arr[i - 1][0] % mod + arr[i - 1][1] % mod) % mod;

		}
		int result = (arr[n - 1][0] + arr[n - 1][1] + arr[n - 1][2]) % mod;
		bw.write(Integer.toString(result));
		bw.flush();
	}
}

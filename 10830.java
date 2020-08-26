import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	final static int mod = 1000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken()) - 1;
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				arr[i][j] = Integer.parseInt(st.nextToken()) % mod;
		}
		int[][] remain = arr;
		while (b != 0) {
			if (b % 2 == 1) {
				remain = matrixPow(remain, arr);
				b--;
			}
			arr = matrixPow(arr, arr);
			b /= 2;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				sb.append(Integer.toString(remain[i][j]) + " ");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static int[][] matrixPow(int[][] a1, int[][] a2) {
		int[][] result = new int[a1.length][a1.length];
		for (int i = 0; i < a1.length; i++)
			for (int j = 0; j < a1.length; j++)
				for (int t = 0; t < a1.length; t++)
					result[i][j] = ((result[i][j] % mod) + ((a1[i][t] % mod) * (a2[t][j] % mod)) % mod) % mod;
		return result;
	}
}

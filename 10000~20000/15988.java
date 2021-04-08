import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	final static int mod = 1000000009;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[1000001];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		for (int j = 3; j < arr.length; j++)
			arr[j] = (arr[j - 1] % mod + arr[j - 2] % mod + arr[j - 3] % mod) % mod;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			bw.write(Long.toString(arr[num - 1]) + "\n");
		}
		bw.flush();
	}
}

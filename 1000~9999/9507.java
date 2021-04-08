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
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[70];
		arr[0] = 1;
		for (int i = 1; i < 4; i++)
			arr[i] = (long) Math.pow(2, i - 1);
		for (int i = 4; i < arr.length; i++)
			arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3] + arr[i - 4];
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			bw.write(Long.toString(arr[num]) + "\n");
		}
		bw.flush();
	}
}

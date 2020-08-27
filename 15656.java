import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		Back(m, "");
		bw.flush();
	}

	public static void Back(int depth, String result) throws IOException {
		if (depth == 0) {
			bw.write(result + "\n");
		} else {
			for (int i = 0; i < arr.length; i++)
				Back(depth - 1, result + arr[i] + " ");
		}
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int s;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int ans = 0;
		for (int i = 0; i < n; i++) {
			Back(arr[i], i);
			ans += count;
			count = 0;
		}
		bw.write(ans + "");
		bw.flush();
	}

	public static void Back(int n, int next) {
		if (n == s)
			count++;
		if (next + 1 < arr.length) {
			Back(n + arr[next + 1], next + 1);
			if (n == s)
				count--;
			Back(n, next + 1);
		}
	}
}

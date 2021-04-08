import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuffer sb = new StringBuffer();
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if (n == 0)
				break;
			arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Back(0, 0, "");
			sb.append("\n");
		}
		System.out.print(sb);
	}

	public static void Back(int next, int depth, String s) {
		if (depth == 6)
			sb.append(s + "\n");
		else {
			if (next < arr.length) {
				Back(next + 1, depth + 1, s + arr[next] + " ");
				Back(next + 1, depth, s);
			}
		}
	}
}

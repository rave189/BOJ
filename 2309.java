import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] arr = new int[9];
	static String result = "";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		for (int i = 0; i < 3; i++)
			Back(0, 0, i, "");
		bw.write(result);
		bw.flush();
	}

	public static void Back(int sum, int depth, int next, String ans) {
		if (depth < 7) {
			if (next < arr.length) {
				Back(sum + arr[next], depth + 1, next + 1, ans + arr[next] + "\n");
				Back(sum, depth, next + 1, ans);
			}
		} else {
			if (sum == 100)
				result = ans;
		}
	}
}

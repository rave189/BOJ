import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		Back(arr, 0, m, "");
	}

	public static void Back(int[] arr, int next, int depth, String result) {
		if (depth == 0)
			System.out.println(result);
		else {
			for (int i = next; i < arr.length; i++)
				Back(arr, i + 1, depth - 1, result + arr[i] + " ");
		}
	}
}

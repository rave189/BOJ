import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (BinarySearch(arr, 0, n - 1, num))
				bw.write(1 + "\n");
			else
				bw.write(0 + "\n");
		}
		bw.flush();
	}

	public static boolean BinarySearch(int[] arr, int left, int right, int num) {
		if (right - left >= 0) {
			int mid = (left + right) / 2;
			if (num == arr[mid])
				return true;
			else if (num < arr[mid])
				return BinarySearch(arr, left, mid - 1, num);
			else
				return BinarySearch(arr, mid + 1, right, num);
		}
		return false;
	}
}

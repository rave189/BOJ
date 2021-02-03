import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for (int j = 0; j < m; j++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken());
			if (Search(Arrays.copyOfRange(arr, start, end)))
				answer.append(1 + "\n");
			else
				answer.append(0 + "\n");
		}
		System.out.println(answer);
	}

	public static boolean Search(int[] subArr) {
		int size = subArr.length;
		for (int i = 0; i < size / 2; i++)
			if (subArr[i] != subArr[size - 1 - i])
				return false;
		return true;
	}
}

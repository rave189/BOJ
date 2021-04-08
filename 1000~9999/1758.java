import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		long answer = 0;
		for (int i = n - 1, j = 1; i >= 0; i--, j++) {
			int sum = arr[i] - (j - 1);
			if (sum > 0)
				answer += sum;
		}
		System.out.println(answer);
	}
}

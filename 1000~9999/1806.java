import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int start = 0, end = 0, sum = 0, answer = Integer.MAX_VALUE;
		while (start <= end && end < n) {
			if (sum + arr[end] >= s) {
				answer = Math.min(answer, end + 1 - start);
				sum -= arr[start++];
			} else
				sum += arr[end++];
		}
		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}
}

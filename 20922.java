import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int[] valueCnt = new int[100001];
		int start = 0, end = 0, answer = 0;
		while (start <= end) {
			if (end == n)
				break;
			if (valueCnt[arr[end]] + 1 > k)
				valueCnt[arr[start++]]--;
			else {
				valueCnt[arr[end]]++;
				answer = Math.max(answer, ++end - start);
			}
		}
		System.out.println(answer);
	}
}

package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		int left = 0;
		int right = 1000000000;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (mid >= max) {
				int sum = 0;
				int count = 0;
				for (int i = 0; i < n; i++) {
					if (sum + arr[i] <= mid)
						sum += arr[i];
					else {
						sum = arr[i];
						count++;
					}
				}
				if (count >= m)
					left = mid + 1;
				else if (count < m)
					right = mid - 1;
			} else
				left = mid + 1;
		}
		System.out.println(left);
	}
}

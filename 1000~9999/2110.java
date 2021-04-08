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
		int c = Integer.parseInt(st.nextToken());
		int[] house = new int[n];
		for (int i = 0; i < n; i++)
			house[i] = Integer.parseInt(br.readLine());
		Arrays.sort(house);
		int left = 0;
		int right = house[n - 1] - house[0];
		while (left <= right) {
			int mid = (left + right) / 2;
			int count = 1;
			int next = house[0];
			for (int i = 1; i < n; i++)
				if (next + mid <= house[i]) {
					count++;
					next = house[i];
				}
			if (count < c)
				right = mid - 1;
			else
				left = mid + 1;
		}
		System.out.println(left - 1);
	}
}

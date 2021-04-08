import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] line = br.readLine().split(" ");
		int h = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(line[i]);
			h = arr[i] > h ? arr[i] : h;
		}
		int max = Integer.parseInt(br.readLine());
		int left = 0;
		int right = max;
		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;
			for (int i = 0; i < n; i++)
				if (mid < arr[i])
					sum += mid;
				else
					sum += arr[i];
			if (sum > max)
				right = mid - 1;
			else
				left = mid + 1;
		}
		if (right > h)
			System.out.println(h);
		else
			System.out.println(right);
	}
}

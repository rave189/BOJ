import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		long x = Long.parseLong(line[0]);
		long y = Long.parseLong(line[1]);
		int z = (int) ((y * 100 / x));
		long left = 0;
		long right = x;
		if (z >= 99) {
			System.out.println(-1);
			return;
		}
		while (left <= right) {
			long mid = (right + left) / 2;
			int compare = (int) (((y + mid) * 100) / (x + mid));
			if (compare < z)
				left = mid + 1;
			else if (compare == z) {
				compare = (int) (((y + mid + 1) * 100) / (x + mid + 1));
				if (compare <= z)
					left = mid + 1;
				else
					right = mid - 1;
			} else
				right = mid - 1;
		}
		System.out.println(left + 1);
	}
}

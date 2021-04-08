import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] plus = new int[n];
		int[] minus = new int[n];
		int plusCnt = 0;
		int minusCnt = 0;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > 0)
				plus[plusCnt++] = num;
			else
				minus[minusCnt++] = num;
		}
		Arrays.sort(plus);
		Arrays.sort(minus);
		int sum = 0;
		for (int i = n - 1; i >= n - plusCnt; i -= 2) {
			try {
				if (plus[i] * plus[i - 1] > plus[i] + plus[i - 1])
					sum += plus[i] * plus[i - 1];
				else
					sum += plus[i] + plus[i - 1];
			} catch (Exception e) {
				sum += plus[i];
			}
		}
		for (int i = 0; i < minusCnt; i += 2) {
			if (i + 1 < minusCnt)
				sum += minus[i] * minus[i + 1];
			else
				sum += minus[i];
		}
		System.out.println(sum);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		long[] calc = new long[21];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		calc[arr[0]] = 1;
		for (int i = 1; i < n - 1; i++) {
			long[] subCalc = new long[21];
			for (int j = 0; j < calc.length; j++)
				if (calc[j] != 0) {
					if (j + arr[i] <= 20)
						subCalc[j + arr[i]] += calc[j];
					if (j - arr[i] >= 0)
						subCalc[j - arr[i]] += calc[j];
				}
			calc = subCalc;
		}
		System.out.println(calc[arr[n - 1]]);
	}
}

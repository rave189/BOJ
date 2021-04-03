import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] loseWeight = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			loseWeight[i] = Long.parseLong(st.nextToken());
		Arrays.sort(loseWeight);
		long answer = 0;
		if (n % 2 != 0)
			answer = loseWeight[n-- - 1];
		for (int i = 0, j = n - 1; i < n / 2; i++, j--)
			answer = Math.max(answer, loseWeight[i] + loseWeight[j]);
		System.out.println(answer);
	}
}

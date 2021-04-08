import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long fiveCount = Count(n, 5) - Count(n - m, 5) - Count(m, 5);
		long twoCount = Count(n, 2) - Count(n - m, 2) - Count(m, 2);
		System.out.println(Math.min(fiveCount, twoCount));
	}

	public static long Count(long n, int div) {
		long count = 0;
		for (long i = div; n / i >= 1; i *= div)
			count += n / i;
		return count;
	}
}

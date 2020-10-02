import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int r = 31;
	static int mod = 1234567891;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String line = br.readLine();
		long sum = 0;
		for (int i = 0; i < line.length(); i++) {
			int cur = line.charAt(i) - 96;
			sum = ((sum % mod) + ((cur * Pow(i)) % mod)) % mod;
		}
		System.out.println(sum);
	}

	public static long Pow(int n) {
		long result = 1;
		long value = r;
		while (n != 0) {
			if (n % 2 == 0) {
				value = ((value % mod) * (value % mod)) % mod;
				n /= 2;
			} else {
				result = ((result % mod) * (value % mod)) % mod;
				n--;
			}
		}
		return result;
	}
}

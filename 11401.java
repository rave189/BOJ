import java.util.Scanner;

public class Main {

	final static int mod = 1000000007;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		if (n == m || m == 0)
			System.out.println(1);
		else {
			long multiple = 1, inverse = 1, result;
			for (int i = n, j = 1; j <= m; i--, j++) {
				multiple = ((multiple % mod) * i) % mod;
				inverse = ((inverse % mod) * j) % mod;
			}
			inverse = pow(inverse, mod - 2);
			result = ((multiple % mod) * (inverse % mod)) % mod;
			System.out.println(result % mod);
		}
	}

	public static long pow(long n, int count) {
		long remain = 1;
		while (count != 0) {
			if (count % 2 != 0) {
				remain = ((remain % mod) * (n % mod)) % mod;
				count--;
			}
			n = ((n % mod) * (n % mod)) % mod;
			count /= 2;
		}
		return remain % mod;
	}
}

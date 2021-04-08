import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	final static int divide = 10007;

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		BigInteger bi = new BigInteger("1");
		if (k == 0)
			System.out.println(1);
		else {
			for (int i = n; i > n - k; i--)
				bi = bi.multiply(new BigInteger(Integer.toString(i)));
			for (int i = k; i > 0; i--)
				bi = bi.divide(new BigInteger(Integer.toString(i)));
			System.out.println(bi.mod(new BigInteger(Integer.toString(divide))));
		}
	}
}

// 다이나믹 프로그램 풀이
import java.util.Scanner;

public class Main {

	final static int mod = 10007;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int[][] arr = new int[n + 1][n + 1];
		if (n == m || m == 0)
			System.out.println(1);
		else {
			for (int i = 0; i <= n; i++)
				arr[i][0] = 1;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= i; j++) {
					if (i == j)
						arr[i][j] = 1;
					else
						arr[i][j] = ((arr[i - 1][j - 1] % mod) + (arr[i - 1][j] % mod)) % mod;
				}
			}
			System.out.println(arr[n][m]);
		}
	}
}

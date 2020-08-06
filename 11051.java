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

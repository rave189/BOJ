import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		BigInteger bi = new BigInteger("2");
		if (num <= 20) {
			hanoi(num, 1, 2, 3);
			System.out.println(count + "\n" + sb.toString());
		} else
			System.out.println(bi.pow(num).subtract(new BigInteger("1")));
	}

	public static void hanoi(int n, int fir, int sec, int last) throws IOException {
		if (n == 1) {
			sb.append(fir + " " + last + "\n");
			count++;
		} else {
			hanoi(n - 1, fir, last, sec);
			sb.append(fir + " " + last + "\n");
			count++;
			hanoi(n - 1, sec, fir, last);
		}
	}
}

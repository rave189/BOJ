import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long answer = 1;
		for (int i = 2; i <= n; i++) {
			answer *= i;
			while (answer % 10 == 0)
				answer /= 10;
			answer %= 1000000;
		}
		System.out.println(answer % 10);
	}
}

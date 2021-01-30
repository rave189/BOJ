import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final int mod = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if (n == 0) {
			System.out.println(0 + "\n" + 0);
			return;
		}
		int[] arr = new int[Math.abs(n) + 1];
		arr[1] = 1;
		boolean sign = n > 0 ? true : false;
		for (int i = 2; i < arr.length; i++)
			if (sign)
				arr[i] = ((arr[i - 1] % mod) + (arr[i - 2] % mod));
			else
				arr[i] = ((arr[i - 2] % mod) - (arr[i - 1] % mod));
		int answer = arr[Math.abs(n)];
		System.out.println(answer > 0 ? 1 : answer == 0 ? 0 : -1);
		System.out.println(Math.abs(answer) % mod);
	}
}

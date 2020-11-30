import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while (true) {
			String strNum = Integer.toString(n);
			if (Palindrome(strNum))
				if (IsPrime(n)) {
					System.out.println(n);
					break;
				}
			n++;
		}
	}

	public static boolean Palindrome(String n) {
		for (int i = 0; i < n.length() / 2; i++)
			if (!n.substring(i, i + 1).equals(n.substring(n.length() - 1 - i, n.length() - i)))
				return false;
		return true;
	}

	public static boolean IsPrime(int x) {
		if (x < 2)
			return false;
		for (int i = 2; i * i <= x; i++)
			if (x % i == 0)
				return false;
		return true;
	}
}

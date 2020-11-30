import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		for (int i = 0; i < line.length(); i++) {
			StringBuilder sb = new StringBuilder(line.substring(0, i));
			String newString = line + sb.reverse();
			if (IsPalindrome(newString)) {
				System.out.println(newString.length());
				break;
			}
		}
	}

	public static boolean IsPalindrome(String str) {
		for (int i = 0; i < str.length() / 2; i++)
			if (!str.substring(i, i + 1).equals(str.substring(str.length() - 1 - i, str.length() - i)))
				return false;
		return true;
	}
}

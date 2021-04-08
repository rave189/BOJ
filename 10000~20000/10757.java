import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		String answer = StringSum(line[0], line[1]);
		System.out.println(answer);
	}

	public static String StringSum(String s1, String s2) {
		StringBuilder sb = new StringBuilder();
		int length = s1.length() > s2.length() ? s1.length() : s2.length();
		int carry = 0;
		for (int i = 1; i <= length; i++) {
			int sum = carry;
			if (s1.length() - i >= 0)
				sum += Integer.parseInt(s1.charAt(s1.length() - i) + "");
			if (s2.length() - i >= 0)
				sum += Integer.parseInt(s2.charAt(s2.length() - i) + "");
			carry = sum >= 10 ? 1 : 0;
			sb.append(sum % 10);
		}
		if (carry != 0)
			sb.append(carry);
		return sb.reverse().toString();
	}
}

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] s = input.nextLine().split("");
		StringBuilder sb;
		StringBuilder result = new StringBuilder();
		if (!s[0].equals("0"))
			for (int i = 0; i < s.length; i++) {
				sb = new StringBuilder();
				String byt = "";
				int num = Integer.parseInt(s[i]);
				while (num != 0) {
					sb.append(num % 2);
					num /= 2;
				}
				byt = sb.reverse().toString();
				if (byt.length() != 3 && i != 0)
					for (int j = byt.length(); j < 3; j++)
						byt = "0" + byt;
				result.append(byt);
			}
		else
			result.append(0);
		System.out.println(result.toString());
	}
}

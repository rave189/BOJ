import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).equals("=")) {
				if (i - 2 >= 0 && s.substring(i-1, i).equals("z"))
					if (s.substring(i - 2, i - 1).equals("d"))
						count--;
			} else if (s.substring(i, i + 1).equals("-"))
				;
			else if (s.substring(i, i + 1).equals("j")) {
				if (i - 1 >= 0) {
					if (s.substring(i - 1, i).equals("l") || s.substring(i - 1, i).equals("n"))
						;
					else
						count++;
				} else
					count++;
			} else
				count++;
		}
		System.out.println(count);
	}
}

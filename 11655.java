import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String[] s = input.nextLine().split("");
		for (int i = 0; i < s.length; i++) {
			char c = s[i].charAt(0);
			if(s[i].equals(" ") || (c>=48 && c <= 57))
				System.out.print(s[i]);
			else{
				if(c >= 65 && c <= 90) {
					c += 13;
					if(c > 90)
						c -= 26;
				}
				else {
					c += 13;
					if(c > 122)
						c -= 26;
				}
				System.out.print(String.valueOf(c));
			}
		}
	}
}

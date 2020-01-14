import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String s = input.next();
		int base = 0;
		int count = 0;
		String[] splPS = s.split("");
		for (int i = 0; i < splPS.length; i++) {
			if (splPS[i].equals("(")) {
				base++;
				count++;
			}
			else if (splPS[i].equals(")")) {
				base--;
				if(splPS[i-1].equals("(")) {
					count += base;
					count--;
				}
			}
		}
		System.out.println(count);
	}
}

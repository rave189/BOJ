import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String num = input.next();
		System.out.println((byte)num.charAt(0));
	}
}

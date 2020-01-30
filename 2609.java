import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int A = a;
		int B = b;
		while(b != 0) {
			int r = a%b;
			a = b;
			b = r;
		}
		int lcm = a * (A/a) * (B/a);
		System.out.println(a);
		System.out.println(lcm);
	}
}

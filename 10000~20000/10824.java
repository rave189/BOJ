import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String[] s = input.nextLine().split(" ");
		BigInteger a = new BigInteger(s[0]+s[1]);
		BigInteger b = new BigInteger(s[2]+s[3]);
		System.out.println(a.add(b));
	}
}

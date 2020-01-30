import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String A = input.next();
		String B = input.next();
		String reverseA = A.substring(2, 3)+A.substring(1, 2)+A.substring(0, 1);
		String reverseB = B.substring(2, 3)+B.substring(1, 2)+B.substring(0, 1);
		System.out.println(Integer.max(Integer.parseInt(reverseA), Integer.parseInt(reverseB)));
	}
}

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int count = 0;
		String s = input.nextLine().trim();
		StringTokenizer stk = new StringTokenizer(s);
		while(stk.hasMoreTokens()) {
			stk.nextToken();
			count++;
		}
		System.out.println(count);
	}
}

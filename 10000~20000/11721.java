import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String[] s = input.nextLine().split("");
		for(int i=1; i<s.length+1; i++) {
			System.out.print(s[i-1]);
			if(i%10 == 0)
				System.out.println();
		}
	}
}

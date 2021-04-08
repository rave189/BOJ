import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			System.out.println(input.nextInt() + input.nextInt());
		}
	}
}

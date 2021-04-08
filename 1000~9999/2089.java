import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		long number = input.nextLong();
		StringBuilder sb = new StringBuilder();
		if (number != 0)
			while (number != 0) {
				if (number % -2 == 0) {
					sb.append(0);
					number /= -2;
				} else {
					number -= 1;
					sb.append(1);
					number /= -2;
				}
			}
		else
			sb.append(0);
		sb = sb.reverse();
		System.out.println(sb.toString());
	}
}

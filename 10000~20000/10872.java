import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int sum = 1;
		for(int i=number; i>0; i--)
			sum *= i;
		System.out.println(sum);
	}
}

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		for(int i=1; i<=number; i++) {
			for(int j=0; j<number-i; j++)
				System.out.print(" ");
			for(int j=0; j<i; j++)
				System.out.print("*");
			System.out.println();
		}
		for(int i=1; i<=number; i++) {
			for(int j=0; j<i; j++)
				System.out.print(" ");
			for(int j=0; j<number-i; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}

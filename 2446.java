import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		for(int i=number; i>0; i--) {
			for(int j=0; j<number-i; j++)
				System.out.print(" ");
			for(int j=0; j<2*i-1; j++)
				System.out.print("*");
			System.out.println();
		}
		for(int i=2; i<=number; i++) {
			for(int j=0; j<number-i; j++)
				System.out.print(" ");
			for(int j=0; j<2*i-1; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}

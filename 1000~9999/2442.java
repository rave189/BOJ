import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		for(int i=1; i<=number; i++) {
			for(int j=number-i; j>0; j--)
				System.out.print(" ");
			for(int j=1; j<=2*i-1; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}

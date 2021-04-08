import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		for (int i = 1; i < number; i++) {
			for (int j = 0; j < number-i; j++)
				System.out.print(" ");
			for (int j = 0; j < 2*i-1; j++) {
				if(j == 0 || j == 2*i-2)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		for(int i=0; i<2*number-1; i++)
			System.out.print("*");
	}
}

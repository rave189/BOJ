import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j+=2)
				System.out.print("* ");
			System.out.println();
			for(int j=1; j<num; j+=2)
				System.out.print(" *");
			System.out.println();
		}
	}
}

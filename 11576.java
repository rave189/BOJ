import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int A = input.nextInt();
		int B = input.nextInt();
		int digit = input.nextInt();
		int sum = 0;
		for(int i=0; i<digit; i++)
			sum = sum * A + input.nextInt();
		convert(sum, B);
	}
	public static void convert(int num, int base) {
		if(num == 0)
			return;
		else {
			convert(num/base, base);
			System.out.print(num%base+" ");
		}
	}
}

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public final static int mod = 10007;
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		long[] array = new long[90];
		array[0] = 1;
		array[1] = 1;
		for(int i=2; i<array.length; i++)
			array[i] = array[i-1] + array[i-2];
		System.out.println(array[number-1]);
	}
}

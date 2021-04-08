import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int[] array = new int[10];
		array[0] = 1;
		array[1] = 2;
		array[2] = 4;
		for(int i=3; i<array.length; i++)
			array[i] = array[i-1] + array[i-2] + array[i-3];
		for(int i=0; i<number; i++)
			System.out.println(array[input.nextInt()-1]);
	}
}

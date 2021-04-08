import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static int[] array;

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		array = new int[number + 1];
		makeOne(number);
		System.out.println(array[number]);
	}

	public static int makeOne(int number) {
		if (number == 1)
			return 0;
		if (array[number] > 0)
			return array[number];
		array[number] = makeOne(number - 1) + 1;
		if (number % 2 == 0) {
			int temp = makeOne(number / 2) + 1;
			if (array[number] > temp)
				array[number] = temp;
		}
		if (number % 3 == 0) {
			int temp = makeOne(number / 3) + 1;
			if (array[number] > temp)
				array[number] = temp;
		}
		return array[number];
	}
}

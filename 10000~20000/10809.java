import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		int[] array = new int[26];
		for (int i = 0; i < array.length; i++)
			array[i] = -1;
		for (int i = 0; i < line.length(); i++) {
			int num = (byte) line.substring(i, i + 1).charAt(0);
			if (array[num - 97] == -1)
				array[num - 97] = i;
		}
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}
}

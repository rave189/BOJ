import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String line = input.nextLine().toLowerCase();
		int[] array = new int[26];
		for (int i = 0; i < line.length(); i++) {
			int b = (byte) line.substring(i, i + 1).charAt(0);
			array[b - 97]++;
		}
		int max = 0;
		int alphabet = 0;
		for (int i = 0; i < array.length; i++)
			if (array[i] == max) {
				alphabet = -2;
			} else if (array[i] > max) {
				max = array[i];
				alphabet = i;
			}
		char result = (char) (alphabet + 65);
		System.out.println(result);
	}
}

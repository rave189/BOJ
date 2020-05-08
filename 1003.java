import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int[] ZeroArray;
		int[] OneArray;
		for (int i = 0; i < number; i++) {
			int num = input.nextInt();
			ZeroArray = new int[num + 2];
			OneArray = new int[num + 2];
			ZeroArray[0] = 1;
			OneArray[1] = 1;
			for (int j = 2; j < num + 1; j++) {
				ZeroArray[j] = ZeroArray[j - 1] + ZeroArray[j - 2];
				OneArray[j] = OneArray[j - 1] + OneArray[j - 2];
			}
			System.out.println(ZeroArray[num] + " " + OneArray[num]);
		}
	}
}

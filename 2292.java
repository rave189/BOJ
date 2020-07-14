import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int count = 0;
		for (int i = 1; i < num; i += 6 * count) {
			count++;
		}
		System.out.println(++count);
	}
}

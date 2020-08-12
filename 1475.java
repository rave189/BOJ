import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String num = input.next();
		int[] arr = new int[10];
		for (int i = 0; i < num.length(); i++) {
			int n = Integer.parseInt(num.substring(i, i + 1));
			arr[n]++;
		}
		arr[6] = (int) Math.ceil((arr[6] + arr[9]) / 2.0);
		int max = 0;
		for (int i = 0; i < 9; i++)
			if (arr[i] > max)
				max = arr[i];
		System.out.println(max);
	}
}

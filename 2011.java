import java.util.Scanner;

public class Main {

	final static int mod = 1000000;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		int[] arr = new int[s.length() + 1];
		for (int i = 0; i < arr.length - 1; i++)
			arr[i + 1] = Integer.parseInt(s.substring(i, i + 1));
		int[] result = new int[s.length() + 1];
		result[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != 0)
				result[i] = (result[i - 1] + result[i]) % mod;
			if (i != 1) {
				int x = arr[i - 1] * 10 + arr[i];
				if (10 <= x && x <= 26)
					result[i] = (result[i - 2] + result[i]) % mod;
			}
		}
		System.out.println(result[arr.length - 1]);
	}
}

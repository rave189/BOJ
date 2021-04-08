import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] arr = new int[n + 3];
		arr[1] = 2;
		arr[2] = 3;
		for (int i = 3; i < n; i++) {
			int sum = arr[i - 1] + arr[i - 2];
			if (sum >= 10)
				sum -= 10;
			arr[i] = sum;
		}
		System.out.println(arr[n - 1]);
	}
}

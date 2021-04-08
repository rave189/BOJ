import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		int[] arr = new int[2 * (n + k) + 1];
		for (int i = n - 1; i >= 0; i--)
			arr[i] = arr[i + 1] + 1;
		for (int i = n + 1; i < arr.length; i++)
			arr[i] = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (2 * i < arr.length && arr[i] + 1 < arr[2 * i]) {
				arr[2 * i] = arr[i] + 1;
				if (arr[2 * i] + 1 < arr[2 * i - 1])
					arr[2 * i - 1] = arr[2 * i] + 1;
			}
			if (i - 1 >= 0 && arr[i] + 1 < arr[i - 1])
				arr[i - 1] = arr[i] + 1;
			if (i + 1 < arr.length && arr[i] + 1 < arr[i + 1])
				arr[i + 1] = arr[i] + 1;
		}
		System.out.println(arr[k]);
	}
}

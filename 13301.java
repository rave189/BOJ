import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		long[] arr = new long[N + 1];
		arr[0] = 1;
		arr[1] = 1;
		for (int i = 2; i <= N; i++)
			arr[i] = arr[i - 1] + arr[i - 2];
		System.out.println(arr[N] * 2 + arr[N - 1] * 2);
	}
}

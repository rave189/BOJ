import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int A = input.nextInt();
		int B = input.nextInt();
		int C = input.nextInt();
		int N = input.nextInt();
		int[] arr = new int[500];
		arr[A] = A;
		arr[B] = B;
		arr[C] = C;
		for (int i = 0; i < N; i++) {
			if (arr[i] != 0) {
				arr[i + A] = arr[i] + A;
				arr[i + B] = arr[i] + B;
				arr[i + C] = arr[i] + C;
			}
		}
		if (arr[N] != 0)
			System.out.println(1);
		else
			System.out.println(0);
	}
}

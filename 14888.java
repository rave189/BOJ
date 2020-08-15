import java.util.Scanner;

public class Main {

	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = input.nextInt();
		int[] op = new int[4];
		for (int i = 0; i < 4; i++)
			op[i] = input.nextInt();
		Operation(arr, op, 1, arr[0]);
		System.out.println(max + "\n" + min);
	}

	public static void Operation(int[] arr, int[] op, int next, int result) {
		if (next >= arr.length) {
			if (result > max)
				max = result;
			if (result < min)
				min = result;
		} else {
			for (int i = 0; i < 4; i++)
				if (op[i] != 0) {
					op[i]--;
					switch (i) {
					case 0:
						Operation(arr, op, next + 1, result + arr[next]);
						break;
					case 1:
						Operation(arr, op, next + 1, result - arr[next]);
						break;
					case 2:
						Operation(arr, op, next + 1, result * arr[next]);
						break;
					case 3:
						Operation(arr, op, next + 1, result / arr[next]);
						break;
					}
					op[i]++;
				}
		}
	}
}

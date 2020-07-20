import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		for (int i = 0; i < num; i++) {
			int x = input.nextInt();
			int y = input.nextInt();
			int distance = y - x;
			double[] arr = new double[93000];
			arr[0] = 1;
			for (int j = 1, k = 1; j < arr.length; j++) {
				arr[j] = arr[j - 1] + k;
				if (j % 2 == 1)
					k++;
			}
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] > 0)
					if (arr[j] >= distance) {
						System.out.println(j + 1);
						break;
					}
			}
		}
	}
}

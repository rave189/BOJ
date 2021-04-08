import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++)
			arr[i] = input.nextInt();
		if (num == 1)
			System.out.println(arr[0] * arr[0]);
		else {
			for (int i = 0; i < num; i++)
				for (int j = 1; j < num; j++)
					if (arr[j] > arr[j - 1]) {
						int temp = arr[j];
						arr[j] = arr[j - 1];
						arr[j - 1] = temp;
					}
			System.out.println(arr[0] * arr[num - 1]);
		}
	}
}

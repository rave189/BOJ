import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] arr = new int[num + 1];
		if (num > 1)
			arr[2] = 1;
		if (num > 4)
			arr[5] = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > 0) {
				if (i + 2 < arr.length && (arr[i + 2] == 0 || arr[i + 2] > arr[i] + 1))
					arr[i + 2] = arr[i] + 1;
				if (i + 5 < arr.length && (arr[i + 5] == 0 || arr[i + 5] > arr[i] + 1))
					arr[i + 5] = arr[i] + 1;
			}
		}
		if (arr[num] == 0)
			System.out.println(-1);
		else
			System.out.println(arr[num]);
	}
}

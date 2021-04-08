import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] arr = new int[21];
		arr[1] = 1;
		for(int i=2; i<=num;i++)
			arr[i] = arr[i-1] + arr[i-2];
		System.out.println(arr[num]);
	}
}

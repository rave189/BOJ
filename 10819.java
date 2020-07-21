import java.util.Scanner;

public class Main {

	static int max = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = input.nextInt();
			if (i > 0)
				max = Math.abs(arr[i] - arr[i - 1]);
		}
		next_Permutation(arr, 0, num);
		System.out.println(max);
	}

	public static void next_Permutation(int[] arr, int depth, int n) {
		if (depth == n) {
			max(arr);
			return;
		}
		for (int i = depth; i < n; i++) {
			swap(arr, i, depth);
			next_Permutation(arr, depth + 1, n);
			swap(arr, i, depth);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void max(int[] arr) {
		int sum = 0;
		for(int i=1; i<arr.length; i++)
			sum += Math.abs(arr[i]-arr[i-1]);
		if(sum > max)
			max = sum;
	}
}

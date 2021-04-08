import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] arr = new int[num+1];
		for(int i=1; i<=num; i++)
			arr[i] = input.nextInt();
		int[][] d = new int[2][num+1];
		d[0][1] = arr[1];
		for(int i=2; i<=num; i++) {
			d[0][i] = Math.max(d[0][i-2], d[1][i-2]) + arr[i];
			d[1][i] = d[0][i-1] + arr[i];
		}
		System.out.println(Math.max(d[0][num], d[1][num]));
	}
}

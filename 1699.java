import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] arr = new int[num + 1];
		int[] d = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			d[i] = d[i - 1] + 1;
			for (int j = 1; j * j <= i; j++) {
				int index = i - j*j;
				if(d[i] > d[index])
					d[i] = d[index]+1;
			}
		}
		System.out.println(d[num]);
	}
}

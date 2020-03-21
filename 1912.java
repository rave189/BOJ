import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int[] a = new int[number];
		for(int i=0; i<number; i++)
			a[i] = input.nextInt();
		int[] result = new int[number];
		for(int i=0; i<number; i++) {
			result[i] = a[i];
			if(i != 0)
				if(result[i-1] + a[i] > a[i])
					result[i] = result[i-1] + a[i];
		}
		int max = -10000;
		for(int i=0; i<number; i++)
			if(result[i] > max)
				max = result[i];
		System.out.println(max);
	}
}

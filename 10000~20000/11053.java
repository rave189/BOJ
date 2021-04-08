import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int[] array = new int[number];
		for (int i = 0; i < number; i++)
			array[i] = input.nextInt();
		int[] result = new int[number];
		for(int i=0; i<number; i++) {
			result[i] = 1;
			for(int j=0; j<i; j++)
				if(array[i] > array[j] && result[i] < result[j]+1)
					result[i] = result[j]+1;
		}
		int max = 0;
		for(int i=0; i<number; i++)
			if(result[i] > max)
				max = result[i];
		System.out.println(max);
	}
}

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int[] a = new int[number];
		for (int i = 0; i < number; i++)
			a[i] = input.nextInt();
		int[] increase = new int[number];
		for (int i = 0; i < number; i++) {
			increase[i] = 1;
			for (int j = 0; j < i; j++)
				if (a[i] > a[j] && increase[i] < increase[j] + 1)
					increase[i] = increase[j] + 1;
		}
		
		int[] decrease = new int[number];
		for (int i = number-1; i >= 0; i--) {
			decrease[i] = 1;
			for (int j = number-1; j > i; j--)
				if (a[i] > a[j] && decrease[i] < decrease[j] + 1)
					decrease[i] = decrease[j] + 1;
		}
		
		int max = 0;
		for (int i = 0; i < number; i++) {
			int value = increase[i] + decrease[i] - 1;
			if (value > max)
				max = value;
		}
		System.out.println(max);
	}
}

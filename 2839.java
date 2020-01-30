import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int count = -1;
		for (int i = 0; i <= num / 5; i++) {
			int A = num - (5 * i);
			for (int j = 0; j <= num / 3; j++)
				if ((A + num - (3 * j)) == num)
					if (count == -1)
						count = i + j;
					else
						if (i + j < count)
							count = i + j;
		}
		System.out.println(count);
	}
}

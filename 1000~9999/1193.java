import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int count = 1;
		int sum = 1;
		while(true) {
			if(sum >= num)
				break;
			sum += count++;
		}
		if(sum != num)
			sum -= --count;
		if(count%2 != 0)
			System.out.println((count-(num-sum))+"/"+(1+(num-sum)));
		else
			System.out.println((1+(num-sum))+"/"+(count-(num-sum)));
	}
}

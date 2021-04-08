import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		int sum = 0;
		for(int i=0; i<5; i++) {
			int num = input.nextInt();
			if(num < 40)
				num = 40;
			sum += num;
		}
		System.out.println(sum/5);
	}
}

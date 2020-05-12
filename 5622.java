import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		int sum = 0;
		for(int i=0; i<s.length(); i++) {
			int temp = (byte)s.substring(i, i+1).charAt(0);
			if(temp >= 65 && temp <= 67)
				sum += 3;
			else if(temp >= 68 && temp <= 70)
				sum += 4;
			else if(temp >= 71 && temp <= 73)
				sum += 5;
			else if(temp >= 74 && temp <= 76)
				sum += 6;
			else if(temp >= 77 && temp <= 79)
				sum += 7;
			else if(temp >= 80 && temp <= 83)
				sum += 8;
			else if(temp >= 84 && temp <= 86)
				sum += 9;
			else if(temp >= 87 && temp <= 90)
				sum += 10;
		}
		System.out.println(sum);
	}
}

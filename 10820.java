import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int[] result;
		while (input.hasNextLine()) {
			result = new int[4];
			String[] s = input.nextLine().split("");
			for(int i=0; i<s.length; i++) {
				byte t = (byte)s[i].charAt(0);
				if(s[i].equals(" "))
					result[3]++;
				else if(t >= 48 && t <= 57)
					result[2]++;
				else if(t >= 65 && t <= 90)
					result[1]++;
				else if(t >= 97 && t <= 122)
					result[0]++;
			}
			for(int i=0; i<4; i++)
				System.out.print(result[i]+" ");
			System.out.println();
		}
	}
}

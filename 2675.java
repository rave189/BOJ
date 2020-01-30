import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int testNum = input.nextInt();
		for (int i = 0; i < testNum; i++) {
			int num = input.nextInt();
			String s = input.next();
			String result = "";
			for(int j=0; j<s.length(); j++)
				for(int t=0; t<num; t++)
					result += s.substring(j, j+1);
			System.out.println(result);
		}
	}
}

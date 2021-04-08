import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int count = 0;
		for(int i=0; i<num; i++) {
			String s = input.next();
			boolean cont = true;
			for(int j=0; j<s.length(); j++) {
				String temp = s.substring(j, j+1);
				for(int t=j+1; t<s.length(); t++) {
					if(temp.equals(s.substring(t, t+1)))
						if(!temp.equals(s.substring(t-1, t)))
							cont = false;
				}
			}
			if(cont)
				count++;
		}
		System.out.println(count);
	}
}

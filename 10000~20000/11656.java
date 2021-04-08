import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		String[] array = new String[s.length()];
		for(int i=0; i<s.length(); i++)
			array[i] = s.substring(i, s.length());
		for(int i=0; i<s.length(); i++) {
			int tarlen = array[i].length();
			for(int j=i+1; j<s.length(); j++) {
				int len = array[j].length();
				int range;
				if(tarlen > len)
					range = len;
				else
					range = tarlen;
				for(int t=0; t<range; t++) {
					char target = array[i].charAt(t);
					char c = array[j].charAt(t);
					if(c < target) {
						String temp = array[i];
						array[i] = array[j];
						array[j] = temp;
						break;
					}
					else if(c > target)
						break;
					else {
						if(t == range-1)
							if(range == len) {
								String temp = array[i];
								array[i] = array[j];
								array[j] = temp;
							}
					}
				}
			}
		}
		for(int i=0; i<s.length(); i++)
			System.out.println(array[i]);
	}
}

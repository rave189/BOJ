import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String[] s = input.nextLine().split("");
		int[] result = new int[26];
		for(int i=0; i<s.length; i++) {
			byte t = (byte)s[i].charAt(0);
			result[t-97]++;
		}
		for(int i=0; i<26; i++)
			System.out.print(result[i]+" ");
	}
}

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int p = input.nextInt();
		int[] array = new int[1000];
		int[] check = new int[1000];
		array[0] = a;
		for(int i=1; i<1000; i++) {
			int sum = 0;
			String s = Integer.toString(array[i-1]);
			for(int j=0; j<s.length(); j++) {
				sum += Math.pow(Integer.parseInt(s.substring(j, j+1)), p);
			}
			for(int j=0; j<=i; j++) {
				if(array[j] == sum) {
					check[j]++;
					break;
				}
			}
			array[i] = sum;
		}
		int count = 0;
		for(int i=0; i<1000; i++) {
			if(check[i] != 0)
				break;
			count++;
		}
		System.out.println(count);
	}
}

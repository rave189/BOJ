import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int n = input.nextInt();
		int min= n;
		int sum = 0;
		for(int i=m; i<=n; i++) {
			if(prime(i) > 0) {
				sum += i;
				if(i < min)
					min = i;
			}
		}
		if(sum == 0)
			System.out.println(-1);
		else
			System.out.println(sum+"\n"+min);
	}
	public static int prime(int n) {
		if(n < 2)
			return -1;
		for(int i=2; i*i<=n; i++)
			if(n % i == 0)
				return -1;
		return n;
	}
}

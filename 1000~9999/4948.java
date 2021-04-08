import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(true) {
			int x = input.nextInt();
			if(x == 0)
				break;
			int count =0;
			for(int i=x+1; i<=2*x ;i++) {
				if(prime(i) > 0)
					count++;
			}
			System.out.println(count);
		}
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

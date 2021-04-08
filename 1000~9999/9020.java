import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		for (int i = 0; i < num; i++) {
			int x = input.nextInt();
			String ans = "";
			for (int j = 1; j <= x / 2; j++) {
				int a = prime(j);
				int b = 0;
				int diff = x;
				if (a > 0) {
					b = prime(x-a);
					if(b > 0 && b-a < diff) {
						ans = a+" "+b;
					}
				}
			}
			System.out.println(ans);
		}
	}

	public static int prime(int n) {
		if (n < 2)
			return -1;
		for (int i = 2; i * i <= n; i++)
			if (n % i == 0)
				return -1;
		return n;
	}
}

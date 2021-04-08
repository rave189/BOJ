import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		for (int i = 0; i < num; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			int remain = 1;
			while (b != 0) {
				if (b % 2 != 0) {
					remain = (remain % 10) * (a % 10);
					b--;
				}
				a = (a % 10) * (a % 10);
				b /= 2;
			}
			if (remain % 10 == 0)
				System.out.println(10);
			else
				System.out.println(remain % 10);
		}
	}
}

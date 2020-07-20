import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(true) {
			int x = input.nextInt();
			int y = input.nextInt();
			int z = input.nextInt();
			if(x == 0 && y == 0 && z == 0)
				break;
			int max = Math.max(x, Math.max(y, z));
			if(max == x) {
				int temp = x;
				x = z;
				z = temp;
			} else if(max == y) {
				int temp = y;
				y = z;
				z = temp;
			}
			if(x*x + y*y == z*z)
				System.out.println("right");
			else
				System.out.println("wrong");
		}
	}
}

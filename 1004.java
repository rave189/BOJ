import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for (int i = 0; i < n; i++) {
			int startX = input.nextInt();
			int startY = input.nextInt();
			int dstX = input.nextInt();
			int dstY = input.nextInt();
			int planet = input.nextInt();
			int count = 0;
			for (int j = 0; j < planet; j++) {
				int x = input.nextInt();
				int y = input.nextInt();
				int r = input.nextInt();
				double stDistance = Math.pow(x - startX, 2) + Math.pow(y - startY, 2);
				double endDistance = Math.pow(x - dstX, 2) + Math.pow(y - dstY, 2);
				if (stDistance < r * r && endDistance >= r * r)
					count++;
				else if (stDistance >= r * r & endDistance < r * r)
					count++;
			}
			System.out.println(count);
		}
	}
}

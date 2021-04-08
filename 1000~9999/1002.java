import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		for(int i=0; i<num; i++){
			int x1 = input.nextInt();
			int y1 = input.nextInt();
			int r1 = input.nextInt();
			int x2 = input.nextInt();
			int y2 = input.nextInt();
			int r2 = input.nextInt();
			if(x1 == x2 && y1 == y2 && r1 == r2)
				System.out.println(-1);
			else {
				double distance = Math.sqrt(Math.pow(Math.abs(x1-x2), 2) + Math.pow(Math.abs(y1-y2), 2));
				if(distance == r1+r2 || distance == Math.abs(r1-r2))
					System.out.println(1);
				else if(distance < r1+r2) {
					if(distance < Math.abs(r1-r2))
						System.out.println(0);
					else
						System.out.println(2);
				}
				else
					System.out.println(0);
			}
		}
	}
}

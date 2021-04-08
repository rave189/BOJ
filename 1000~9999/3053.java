import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int radius = input.nextInt();
		System.out.println(radius*radius*Math.PI);
		System.out.println(2*radius*radius);
	}
}

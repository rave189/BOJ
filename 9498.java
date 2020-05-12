import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int number = s.nextInt();
		if(number >= 90)
			System.out.println("A");
		else if(number >= 80)
			System.out.println("B");
		else if(number >= 70)
			System.out.println("C");
		else if(number >= 60)
			System.out.println("D");
		else
			System.out.println("F");
	}
}

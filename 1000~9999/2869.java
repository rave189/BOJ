import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int A = input.nextInt();
		int B = input.nextInt();
		int V = input.nextInt();
		System.out.println((int)(Math.ceil(((double)(V-A)/(A-B)))+1));
	}
}

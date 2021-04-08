import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		for(int i=0; i<num; i++)
		{
			int A = s.nextInt();
			int B = s.nextInt();
			System.out.println(A+B);
		}
	}
}

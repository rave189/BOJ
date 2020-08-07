import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		String B = s.next();
		System.out.println(A*Integer.parseInt(B.substring(2, 3)));
		System.out.println(A*Integer.parseInt(B.substring(1, 2)));
		System.out.println(A*Integer.parseInt(B.substring(0,1)));
		System.out.println(A*Integer.parseInt(B));
	}
}

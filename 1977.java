import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int n = input.nextInt();
		int sum = 0;
		String result = "";
		for (int i = (int) Math.sqrt(m); i * i <= n; i++) {
			if (i * i >= m) {
				if (result.equals(""))
					result = Integer.toString(i * i);
				sum += i * i;
			}
		}
		if (sum == 0)
			System.out.println(-1);
		else {
			result = Integer.toString(sum) + "\n" + result;
			System.out.println(result);
		}
	}
}

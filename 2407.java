import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		String[][] arr = new String[n + 1][m + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= m; j++)
				if (j == 0)
					arr[i][j] = "1";
				else
					arr[i][j] = "0";
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++)
				if (i == j)
					arr[i][j] = "1";
				else {
					if (arr[i - 1][j - 1].length() > arr[i - 1][j].length())
						arr[i][j] = sum(arr[i - 1][j - 1], arr[i - 1][j]);
					else
						arr[i][j] = sum(arr[i - 1][j], arr[i - 1][j - 1]);
				}
		System.out.println(arr[n][m]);
	}

	public static String sum(String a, String b) {
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = a.length(), j = b.length(); i > 0; i--, j--) {
			int stringA = Integer.parseInt(a.substring(i - 1, i));
			int stringB = 0;
			if (j > 0)
				stringB = Integer.parseInt(b.substring(j - 1, j));
			int sum = stringA + stringB + carry;
			if (sum >= 10) {
				carry = 1;
				sb.append(Integer.toString(sum - 10));
			} else {
				carry = 0;
				sb.append(Integer.toString(sum));
			}
		}
		if (carry != 0)
			sb.append(Integer.toString(carry));
		return sb.reverse().toString();
	}
}

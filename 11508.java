import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] product = new int[n];
		for (int i = 0; i < n; i++)
			product[i] = Integer.parseInt(br.readLine());
		Arrays.sort(product);
		int answer = 0;
		for (int i = n - 1; i >= 0; i -= 3) {
			if (i - 1 >= 0)
				answer += product[i] + product[i - 1];
			else
				answer += product[i];
		}
		System.out.println(answer);
	}
}

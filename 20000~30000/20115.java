import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] energyDrink = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			energyDrink[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(energyDrink);
		double answer = energyDrink[n - 1];
		for (int i = n - 2; i >= 0; i--)
			answer += energyDrink[i] / 2.0;
		System.out.println(answer);
	}
}

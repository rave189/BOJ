import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(s[i]);
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n - 1; j++)
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
		int sum = 0;
		int result = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			result += sum;
		}
		bw.write(Integer.toString(result));
		bw.flush();
	}
}

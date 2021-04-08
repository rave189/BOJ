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
		int num = Integer.parseInt(br.readLine());
		int count = 1;
		int i;
		int sum = 0;
		for (i = 1; Math.pow(10, i) <= num; i++) {
			if (i == 1)
				sum += 9 * count++;
			else
				sum += (Math.pow(10, i) - Math.pow(10, i - 1)) * count++;
		}
		sum += (num - Math.pow(10, i - 1) + 1) * count;
		bw.write(Integer.toString(sum));
		bw.flush();
	}
}

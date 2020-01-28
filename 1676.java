import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(bf.readLine());
		int count = 0;
		for (int i = 5; i <= num; i+=5) {
			int tmp = i;
			while (tmp % 5 == 0) {
				count++;
				tmp /= 5;
			}
		}
		System.out.println(count);
	}
}
